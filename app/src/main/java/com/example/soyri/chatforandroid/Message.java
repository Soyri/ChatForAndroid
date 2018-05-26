package com.example.soyri.chatforandroid;
import java.util.Calendar;
import java.util.Date;

public class Message {
    String messageBody;
    User sender;
    long createdAt;
    public Message(String messageBody,User sender, long createdAt){

         this.messageBody = messageBody;
         this.sender = sender;
         this.createdAt = createdAt;
        }

    public String getMessageBody(){
         return messageBody;
        }

    public User getSender(){
        return sender;
        }



    long getCreatedAt(){
        Date dateCreatedAt =  Calendar.getInstance().getTime();
        createdAt = dateCreatedAt.getTime();
        return createdAt;
       }
}





