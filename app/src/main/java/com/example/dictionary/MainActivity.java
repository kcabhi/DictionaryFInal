package com.example.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView lstView;
    private Map<String,String> dictionary;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstView = findViewById(R.id.lstItem);
        dictionary = new HashMap<>();

//        read from file

        readFromFile();
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );

        lstView.setAdapter(arrayAdapter);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String key = parent.getItemAtPosition(position).toString();
             String meaning = dictionary.get(key);

             Intent intent = new Intent(MainActivity.this,MeaningActivity.class);
             intent.putExtra("meaning", meaning);
             startActivity(intent);

            }
        });
    }

    private void readFromFile(){
        try {
            FileInputStream fileInputStream  = openFileInput("word.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line ="";

            while ((line = bufferedReader.readLine()) !=null){
                String[] parts = line.split("->");
                dictionary.put(parts[0],parts[1]);

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
