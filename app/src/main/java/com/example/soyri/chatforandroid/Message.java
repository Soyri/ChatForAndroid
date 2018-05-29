package com.example.soyri.chatforandroid;
import java.util.Calendar;
import java.util.Date;

public class Message {
    String messageBody;


    //User sender;
    boolean mine;
    long createdAt;
    int position;
    public Message(String messageBody,boolean mine , long createdAt){

         this.messageBody = messageBody;
         this.mine = mine;
        //this.sender = sender;
         this.createdAt = createdAt;
         this.position = position;

        }

    public String getMessageBody(){
         return messageBody;
        }

    //public User getSender(){
    //    return sender;
     //   }

    /*public int getPosition(){
        return position;
    }*/



    public boolean isMine() {
        return mine;
    }

    public long getCreatedAt(){
        return createdAt;
    }

}





