package com.example.utixtest.helper;

public class UserIdDataPasser {

    private static UserIdDataPasser instance;
    private String user_id;

    public static UserIdDataPasser getInstance(){
        if(instance == null){
            instance = new UserIdDataPasser();
        }
        return instance;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
