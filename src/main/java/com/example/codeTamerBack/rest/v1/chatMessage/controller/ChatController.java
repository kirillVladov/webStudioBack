package com.example.codeTamerBack.rest.v1.chatMessage.controller;

import com.example.codeTamerBack.rest.v1.chatMessage.model.ChatMessage;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.stereotype.Controller;
import com.example.codeTamerBack.rest.v1.chatMessage.repositories.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class ChatController {
    @Autowired
    private ChatMessageRepository chatMessageRepository;
//    @MessageMapping("/chat/send-message")
//    @SendTo("/topic/public")
    @PostMapping("/chat/send-message")
    public ChatMessage sendMessage(
//            @Payload ChatMessage chatMessage
            @RequestBody ChatMessage chatMessage
    ) {
        return chatMessageRepository.save(chatMessage);
    }
//    @MessageMapping("/chat/add-user")
//    @SendTo("/topic/public")
//    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
//        // Add username in web socket session
////        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        return chatMessage;
//    }

    @GetMapping("/chat/get-messages")
    public List<ChatMessage> getMessagesByRoom(@RequestParam("roomId") String roomId) {
        return chatMessageRepository.findByRoomId(roomId);
    }
}
