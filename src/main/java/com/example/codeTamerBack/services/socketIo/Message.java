package com.example.codeTamerBack.services.socketIo;

import com.example.codeTamerBack.rest.v1.chatMessage.interfaces.MessageType;
import lombok.Data;

@Data
public class Message {
    private MessageType type;
    private String message;
    private String room;

    public Message() {
    }

    public Message(MessageType type, String message) {
        this.type = type;
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getRoom() {
        return room;
    }

}
