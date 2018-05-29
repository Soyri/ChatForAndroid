package com.example.soyri.chatforandroid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DisplayChatWindowActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;
    //private ArrayList<String> messageList ;
    ArrayList<Message> messageList= new ArrayList<Message>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_chat_window);
        Button listen_button = (Button) findViewById(R.id.button_chatbox_send);
        listen_button.setOnClickListener(this); // calling onClick() method
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_CHATWINDOW);
        // Capture the layout's TextView and set the string as its text
        //TextView textView = findViewById(R.id.textView);
        //textView.setText(message);
        mMessageRecycler = (RecyclerView) findViewById(R.id.reyclerview_message_list);
        mMessageAdapter = new MessageListAdapter(this, messageList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onClick(View v){
        mMessageAdapter.add(new Message("Hello",true, Calendar.getInstance().getTime().getTime()));

    }

}
