package com.example.soyri.chatforandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
        Server server;
         TextView infoip;
    public TextView msg;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);


            server = new Server(this);

            setContentView(R.layout.activity_main);
            Button listen_button = (Button) findViewById(R.id.button_listen_id);
            listen_button.setOnClickListener(this); // calling onClick() method
            Button connect_button = (Button) findViewById(R.id.button_connect_id);
            connect_button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // default method for handling onClick Events..
                switch (v.getId()) {

                    case R.id.button_listen_id:
                        // do your code
                        Toast.makeText(getApplicationContext(),"Ok,listen works" ,Toast.LENGTH_SHORT).show();
                        case R.id.button_connect_id:
                        // do your code
                            Toast.makeText(getApplicationContext(),"Ok,connect works" ,Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;
                }
            }






        }











