package com.example.codeTamerBack.services.socketIo;


import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.example.codeTamerBack.rest.v1.Interfaces.MessageType;
import com.example.codeTamerBack.rest.v1.model.User;
import com.example.codeTamerBack.rest.v1.repository.ChatMessageRepository;
import com.example.codeTamerBack.rest.v1.repository.UserRepository;
import com.example.codeTamerBack.services.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class SocketModule {

    private final SocketIOServer server;
    private final SocketService socketService;

    @Autowired
    private UserRepository userRepository;

    public SocketModule(SocketIOServer server, SocketService socketService) {
        this.server = server;
        this.socketService = socketService;
        log.info("start module ");
        server.addConnectListener(onConnected());
        server.addDisconnectListener(onDisconnected());
        server.addEventListener("send_message", Message.class, onChatReceived());
    }


    private DataListener<Message> onChatReceived() {
        return (senderClient, data, ackSender) -> {
        log.info("onreceived");
//            String[] split = data.getRoom().split("-");
//            Message message = new Message(
//                    senderClient.get("user"),
//                    data.getMessage()
//            );
//            chatMessageRepository.save(message);
            socketService.sendMessage(data.getRoom(),"get_message", senderClient, data.getMessage());
        };
    }


    private ConnectListener onConnected() {
        return (client) -> {
            String token = client.getHandshakeData().getSingleUrlParam("token");
            try {
                client.set("user", userRepository.findByToken(token));
            } catch (Exception exception) {
                client.disconnect();
                return;
            }
            joinRoom(
                    client.getHandshakeData().getSingleUrlParam("room"),
                    client.getHandshakeData().getSingleUrlParam("userId"),
                    client
            );
        };

    }

    private DisconnectListener onDisconnected() {
        return client -> {
            log.info("Client[{}] - Disconnected from socket", client.getSessionId().toString());
        };
    }

    private void joinRoom(String roomId, String userId, SocketIOClient client) {
        if (roomId == null || userId == null) {
            client.disconnect();
            return;
        }

        Optional<User> currentUser = userRepository.findById(userId);

        if(currentUser.isEmpty()) {
            client.disconnect();
            return;
        }

        String roomKey = currentUser.get().getUserId() + "-" + roomId;

        client.joinRoom(roomKey);
        socketService.saveInfoMessage(client, String.format(Constants.WELCOME_MESSAGE, userId), roomKey);
        log.info(client.getAllRooms().toString());
    };

}