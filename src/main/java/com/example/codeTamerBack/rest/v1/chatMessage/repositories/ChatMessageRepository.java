package com.example.codeTamerBack.rest.v1.chatMessage.repositories;

import com.example.codeTamerBack.rest.v1.chatMessage.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    @Query
    public List<ChatMessage> findByRoomId(String roomId);
}
