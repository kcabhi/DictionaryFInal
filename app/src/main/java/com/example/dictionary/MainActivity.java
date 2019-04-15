package com.example.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button btnCall;
    private ListView lstView;
    private Map<String,String> dictionary;

    public static final String values[] = {
        "Yeta aunus", "Come here",
                "Uta Janus", "Go there",
                "Namaste","Hello"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstView = findViewById(R.id.lstItem);
        dictionary = new HashMap<>();

        for (int i = 0; i < values.length; i +=2){
            dictionary.put(values[i], values[i+1]);
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(
            this,android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );

        lstView.setAdapter(arrayAdapter);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String key = parent.getItemAtPosition(position).toString();
             String meaning = dictionary.get(key);

             Intent intent = new Intent(MainActivity.this,Display.class);
             intent.putExtra("message", meaning);
             startActivity(intent);

            }
        });
    }
}
