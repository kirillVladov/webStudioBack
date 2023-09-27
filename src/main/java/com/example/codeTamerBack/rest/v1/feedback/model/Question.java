package com.example.codeTamerBack.rest.v1.feedback.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Question {
    @Id
    private String questionId;
    private String email;
    private String name;
    private String question;

    @JsonCreator
    public Question(
            @JsonProperty("email") String email,
            @JsonProperty("name") String name,
            @JsonProperty("queston") String question
    ) {
        super();
        this.email = email;
        this.name = name;
        this.question = question;
    }

    public String getEmail() {return email;}
    public String getQuestion() {return question;}
    public String getName() {return name;}
}
