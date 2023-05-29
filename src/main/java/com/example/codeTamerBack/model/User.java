package com.example.codeTamerBack.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String userId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String password;

    @JsonCreator
    public User(
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("password") String password
    ) {
        super();
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    public String getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
}
