package com.example.codeTamerBack.rest.v1.repository;

import com.example.codeTamerBack.rest.v1.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    @Query
    public List<ChatMessage> findByRoomId(String roomId);
}
