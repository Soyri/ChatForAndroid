package com.example.soyri.chatforandroid;
import java.util.Calendar;
import java.util.Date;

public class Message {
    String messageBody;
    User sender;
    long createdAt;
    int position;
    public Message(String messageBody,User sender, long createdAt){

         this.messageBody = messageBody;
         this.sender = sender;
         this.createdAt = createdAt;
         this.position = position;
        }

    public String getMessageBody(){
         return messageBody;
        }

    public User getSender(){
        return sender;
        }

    /*public int getPosition(){
        return position;
    }*/

    public long setCreatedAt(long createdAt){
        Date dateCreatedAt =  Calendar.getInstance().getTime();
        createdAt = dateCreatedAt.getTime();
        return createdAt;
       }


    public long getCreatedAt(){
        return createdAt;
    }

}





