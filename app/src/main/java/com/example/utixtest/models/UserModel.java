package com.example.utixtest.models;

public class UserModel {

    private String user_name;
    private String user_email;
    private String user_id;
    private String user_passwords;

    public UserModel(String user_name, String user_email, String user_id, String user_passwords) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_id = user_id;
        this.user_passwords = user_passwords;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_passwords() {
        return user_passwords;
    }

    public void setUser_passwords(String user_passwords) {
        this.user_passwords = user_passwords;
    }
}
