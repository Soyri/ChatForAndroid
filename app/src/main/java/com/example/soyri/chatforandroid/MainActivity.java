package com.example.soyri.chatforandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.widget.EditText;

import java.util.Objects;

import static android.text.format.Formatter.formatIpAddress;


public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    Server server;
    TextView textViewIPAddress;
    TextView textViewPort;
    TextView response;
    EditText editTextAddress;
    public TextView msg;
    public static String EXTRA_CHATWINDOW = "This is meant to be a chat ";
    String chatMessage;
    public String connectedIPAddress = "";
    //User otherPerson = new User ("OtherUser","192.168.0.17");
    //otherPerson.setProfileIP(String "");

    @SuppressLint("WifiManagerLeak")
    WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
    public static String myIP;

    public MainActivity() {
        myIP = formatIpAddress(wm.getConnectionInfo().getIpAddress());
    }


    @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            textViewIPAddress = (TextView) findViewById(R.id.textViewIPAddress_id);
            textViewPort = (TextView) findViewById(R.id.textViewPort_id);
            //server = new Server(this);
           // textViewIPAddress.setText(server.getIpAddress() + ":" + server.getPort());//Could't work. Didn't .
            // Should hardcode server and port
            setContentView(R.layout.activity_main);
            Button listen_button = (Button) findViewById(R.id.button_listen_id);
            listen_button.setOnClickListener(this); // calling onClick() method
            Button connect_button = (Button) findViewById(R.id.button_connect_id);
            connect_button.setOnClickListener(this);
            editTextAddress = (EditText) findViewById(R.id.editTextIPAddress_id);
           // response = (TextView) findViewById(R.id.textViewResponse_id);

        }




        /** Called when the user taps the Connect button */
        public void chatWindow(View v) {
        // Do something in response to button
            Intent intent = new Intent(this, DisplayChatWindowActivity.class);
            //EditText editText = (EditText) findViewById(R.id.editText);
            //String chatMessage = editText.getText().toString();
            intent.putExtra(EXTRA_CHATWINDOW, chatMessage);
            startActivity(intent);


        }




        @Override
        public void onClick(View v) {
            // default method for handling onClick Events..
                switch (v.getId()) {

                    case R.id.button_listen_id:
                        // do your code
                        //Server uses listen to alert the TCP/IP machine of the willingness to accept connections.
                        server = new Server(this);
                        //textViewIPAddress.setText(server.getIpAddress());
                        textViewPort.setText("Hail Cthulhu!");
                        //textViewPort.setText(server.getPort());








                        Toast.makeText(getApplicationContext(),"Ok,listen works" ,Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.button_connect_id:
                        // do your code
                        // Client connects socket  to a foreign host with the connect button.
                        //Toast.makeText(getApplicationContext(),"Ok,connect works" ,Toast.LENGTH_SHORT).show();
                       // Client myClient = new Client(editTextAddress.getText().toString(), response);
                       // myClient.execute();
                        //User otherPerson.setProfileIP(connectedIPAddress) =  "";//editTextAddress.toString();
                        chatWindow(v);
                        break;

                    default:
                        break;
                }
            }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (server != null)
            server.onDestroy();
    }




        }











