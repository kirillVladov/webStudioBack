package com.example.codeTamerBack.rest.v1.common.interfaces;

public enum FileTypes {
    png("image/png"),jpeg("image/jpeg"), mp3("image/mp3");;
    private String code;
    FileTypes(String code){
        this.code = code;
    }
    public String getType(){ return code;}
}
