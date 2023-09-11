package com.example.codeTamerBack.services.socketIo;

import com.corundumstudio.socketio.SocketIOClient;
import com.example.codeTamerBack.rest.v1.Interfaces.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SocketService {

    public void sendMessage(String room, String eventName, SocketIOClient senderClient, String message) {
        for (
                SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
//            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent(eventName,
                        new Message(MessageType.SERVER, message));
//            }
        }
    }

    public void sendSocketMessage(SocketIOClient senderClient, Message message, String room) {
        for (
                SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent("read_message",
                        message);
            }
        }
    }


    public void saveInfoMessage(SocketIOClient senderClient, String message, String room) {
//        Message storedMessage = messageService.saveMessage(Message.builder()
//                .messageType(MessageType.SERVER)
//                .content(message)
//                .room(room)
//                .build());
        sendSocketMessage(senderClient, new Message(MessageType.SERVER, "ouhfiuehwoifhewi"), room);
    }
}
