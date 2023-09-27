package com.example.codeTamerBack.rest.v1.user.models;
import com.example.codeTamerBack.rest.v1.user.interfaces.UserRole;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.UnsupportedEncodingException;

@Document
public class User {
    @Id
    private String userId;
    private String name;
    private String surname;
    private String phoneNumber;
    @Indexed(unique = true)
    private String email;
    public String password;
//    private String token;
    private UserRole role;
    private String token;
//    private String birthDayDate;
    private String avatar;

    private String birthDay;

    @JsonCreator
    public User(
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email,
            @JsonProperty("role") UserRole role,
            @JsonProperty("token") String token,
            @JsonProperty("birthDay") String birthDay
    ) throws UnsupportedEncodingException {
        super();
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.token = token;
        this.birthDay = birthDay;
    }
    public String getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public String getBirthDay() {
        return birthDay;
    }
    public String getSurname() {
        return surname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public UserRole getRole() {
        return role;
    }

    public String getEmail() { return email; }
//    public String getPassword() {return new String(crypto.makeAes(password.getBytes(), Cipher.DECRYPT_MODE));}
    public String getPassword() {return password;}
    public String getToken() {return token;}
    public String getAvatar() {
        return avatar;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
