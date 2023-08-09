package com.example.codeTamerBack.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Question {
    @Id
    private String questionId;
    private String email;
    private String name;
    private String question;

    @JsonCreator
    public Question(@JsonProperty("email") String email, @JsonProperty("name") String name, @JsonProperty("queston") String question) {
        super();
        this.email = email;
        this.name = name;
        this.question = question;
    }

    public String getEmail() {return email;}
    public String getQuestion() {return question;}
    public String getName() {return name;}
}
