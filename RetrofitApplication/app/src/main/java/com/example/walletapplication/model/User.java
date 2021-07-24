package com.example.walletapplication.model;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    public  String sId;
    @SerializedName("email")
    public  String sEmail;
    @SerializedName("password")
    public  String sPassword;

//    public User(String id) {this.sId = id};
    public User(String sId, String sEmail, String sPassword) {
        this.sId = sId;
        this.sEmail = sEmail;
        this.sPassword = sPassword;
    }
}
