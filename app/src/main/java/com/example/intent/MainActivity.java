package com.example.intent;


import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button maps, sendMessage;
    EditText latitude, longitude, number;
    ImplicitAct imp = new ImplicitAct();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maps = findViewById(R.id.maps);
        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        number = findViewById(R.id.number);
        sendMessage = findViewById(R.id.sendMessage);

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = findViewById(R.id.layout1);
                Snackbar snackbar = Snackbar.make(view, "Are you Sure, you want to Open Maps?", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Yes", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(imp.OpenMaps(latitude.getText().toString(), longitude.getText().toString()));
                        }
                    });
                snackbar.show();
            }
        });

        sendMessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getBaseContext(), ImplicitIntent.class);
                Log.i("Number", number.getText().toString());
                intent.putExtra("Number", number.getText().toString());
                startActivity(intent);
            }
        });
    }
}