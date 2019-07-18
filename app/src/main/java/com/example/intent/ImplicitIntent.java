package com.example.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitIntent extends AppCompatActivity {

    EditText number, message;
    Button sendMessage, call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        number = findViewById(R.id.fNumber);
        message = findViewById(R.id.message);
        sendMessage = findViewById(R.id.sendMessage);
        call = findViewById(R.id.call);

        String rNumber = getIntent().getStringExtra("Number");

        number.setText(rNumber);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("smsto:" + number.getText().toString()));
                intent.putExtra("sms_body", message.getText().toString());
                startActivity(intent);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number.getText().toString().equals("")){
                    Log.i("Run","Running");
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(
                            "com.android.contacts"
                            ,"com.android.contacts.DialtactsContactsEntryActivity"));
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number.getText().toString()));
                    startActivity(intent);
                }
            }
        });
    }
}
