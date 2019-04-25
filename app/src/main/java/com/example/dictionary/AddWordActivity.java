package com.example.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddWordActivity extends AppCompatActivity {

    private EditText etMeaning, etWord;
    private Button btnAddWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        etMeaning = findViewById(R.id.etMeaning);
        etWord = findViewById(R.id.etWord);
        btnAddWord= findViewById(R.id.btnAddWord);

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()){
                Save();
                clean();
                }
            }
        });
    }

    private void Save(){
        try {


            PrintStream printStream = new PrintStream(openFileOutput("word.txt", MODE_PRIVATE|MODE_APPEND));
            printStream.println(etWord.getText().toString() + " =>" + etMeaning.getText().toString());
            printStream.close();
            Toast.makeText(getApplicationContext(), "Saved to :" + getFilesDir(), Toast.LENGTH_LONG).show();
        }catch (IOException e){
            Log.d("Dictionary app:" ,"Error"+ e.toString());
            e.printStackTrace();

        }

    }


    private Boolean validate() {
        boolean validate = true;
        if (TextUtils.isEmpty(etWord.getText().toString())) {
            etWord.setError("Please Enter Word");
            etWord.requestFocus();
            validate = false;
        }
        if (TextUtils.isEmpty(etMeaning.getText().toString())) {
            etMeaning.setError("Please Enter Meaning");
            etMeaning.requestFocus();
            validate = false;
        }
        return validate;
    }

    private void clean(){
        etWord.setText("");
        etMeaning.setText("");
    }
}
