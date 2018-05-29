package com.example.soyri.chatforandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Adapter;
import android.view.LayoutInflater;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MessageListAdapter extends RecyclerView.Adapter {
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    private Context mContext;
    private List<Message> mMessageList;

    public MessageListAdapter(Context context, List<Message> messageList) {
        mContext = context;
        mMessageList = messageList;
    }


    public void add(Message message) {
        this.mMessageList.add(message);
        notifyDataSetChanged(); // to render the list we need to notify
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }


    @Override
    public int getItemViewType(int position) {
        Message message = (Message) mMessageList.get(position);
        MainActivity mainactivity = new MainActivity();
        return VIEW_TYPE_MESSAGE_SENT;
    }

    // Inflates the appropriate layout according to the ViewType.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_sent, parent, false);
            return new SentMessageHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_received, parent, false);
            return new ReceivedMessageHolder(view);
        }

        return null;
    }

    // Passes the message object to a ViewHolder so that the contents can be bound to UI.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Message message = (Message) mMessageList.get(position);

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceivedMessageHolder) holder).bind(message);
        }
    }

    private class SentMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText;

        SentMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            timeText = (TextView) itemView.findViewById(R.id.text_message_time);
        }

        void bind(Message message) {
            messageText.setText(message.getMessageBody());

            // Format the stored timestamp into a readable String using method.
            Long timeStampAsLong = Long.valueOf(0);
            String timestamp;
            //timeStampAsLong = message.setCreatedAt(timeStampAsLong);//toString;
            timestamp = timeStampAsLong.toString();
            timeText.setText(timestamp);
        }
    }

    private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText, nameText;
        ImageView profileImage;

        ReceivedMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            timeText = (TextView) itemView.findViewById(R.id.text_message_time);
            nameText = (TextView) itemView.findViewById(R.id.text_message_name);
            profileImage = (ImageView) itemView.findViewById(R.id.image_message_profile);
        }

        void bind(Message message) {
            messageText.setText(message.getMessageBody());

            // Format the stored timestamp into a readable String using method.
            Long timeStampAsLong = Long.valueOf(0);
            String timestamp;
            //timeStampAsLong = message.setCreatedAt(timeStampAsLong);//toString;
            timestamp = timeStampAsLong.toString();
            timeText.setText(timestamp);
            String nickname;
            if(message.isMine()) {
                nickname = "Mine";
            } else {
                nickname = "Friend";
            }
            nameText.setText(nickname);

        }


    }
}