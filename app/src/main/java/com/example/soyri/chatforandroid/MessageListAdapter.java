package com.example.soyri.chatforandroid;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Adapter;
import android.view.LayoutInflater;


public class MessageListAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<BaseMessage> mMessageList;

    public MessageListAdapter(Context context, List<BaseMessage> messageList) {
        mContext = context;
        mMessageList = messageList;
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

        void bind(UserMessage message) {
            messageText.setText(message.getMessage());

            // Format the stored timestamp into a readable String using method.
            timeText.setText(Utils.formatDateTime(message.getCreatedAt()));
            nameText.setText(message.getSender().getNickname());

            // Insert the profile image from the URL into the ImageView.
            Utils.displayRoundImageFromUrl(mContext, message.getSender().getProfileUrl(), profileImage);
        }
    }
}
