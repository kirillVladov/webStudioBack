package com.example.codeTamerBack.rest.v1.chatMessage.model;

import com.example.codeTamerBack.rest.v1.user.models.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ChatMessage {
    @Id
    private String messageId;
    private MessageType type;
    private String roomId;
    private String content;
    private User sender;

//    private List<Files> files;
    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public ChatMessage() {}

    @JsonCreator
    public ChatMessage(
            @JsonProperty("content") String content,
            @JsonProperty("sender") User sender,
            @JsonProperty("type") MessageType type,
            @JsonProperty("roomId") String roomId
    ) {
        super();
        this.type = type;
        this.content = content;
        this.sender = sender;
        this.roomId = roomId;
    }

    public MessageType getType() {
        return type;
    }
    public void setType(MessageType type) {
        this.type = type;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public User getSender() {
        return sender;
    }
    public void setSender(User sender) {
        this.sender = sender;
    }
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public String getRoomId() {
        return this.roomId;
    }
}
