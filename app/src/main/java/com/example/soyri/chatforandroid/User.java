package com.example.soyri.chatforandroid;

import java.util.Arrays;

public class User {
    public String nickname;
    public String profileIP;

    public User(String nickname,String profileIP){

        this.nickname = nickname;
        this.profileIP = profileIP;

    }

    public String getNickname(){
        return nickname;
    }

    public String getProfileIP(){
        return profileIP;

    }

    public void setProfileIP(String setIPAddress){
        profileIP = setIPAddress;
        //return profileIP;
    }

}
