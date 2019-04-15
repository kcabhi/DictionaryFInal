package com.example.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Display extends AppCompatActivity {

    private TextView tvDisplayMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvDisplayMessage = findViewById(R.id.tvDisplayMessage);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String meaning = bundle.getString("message");
            tvDisplayMessage.setText(meaning);
        }else{
            Toast.makeText(this,"No message", Toast.LENGTH_LONG).show();
        }
    }
}
