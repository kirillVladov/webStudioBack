package com.example.codeTamerBack.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.UnsupportedEncodingException;

@Document
public class User {
    @Id
    private String userId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    public String password;

    @JsonCreator
    public User(
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email
    ) throws UnsupportedEncodingException {
        super();
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
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

    public String getEmail() { return email; }
//    public String getPassword() {return new String(crypto.makeAes(password.getBytes(), Cipher.DECRYPT_MODE));}
    public String getPassword() {return password;}
    public void setName(String name) {
        this.name = name;
    }
}
