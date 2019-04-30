package com.example.dictionary;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText etUsername,etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      etUsername=findViewById(R.id.etUsername);
      etPassword=findViewById(R.id.etPassword);
      btnLogin=findViewById(R.id.btnLogin);

      btnLogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              checkUser();
          }
      });
    }
    private void checkUser(){
        SharedPreferences sharedPreferences=getSharedPreferences("user",MODE_PRIVATE);
        String username =sharedPreferences.getString("username","");
        String password =sharedPreferences.getString("password","");

        if (username.equals(etUsername.getText().toString())&&
                password.equals(etPassword.getText().toString())){
            Toast.makeText(this,"Login Sucessful",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"Login Failed",Toast.LENGTH_LONG).show();
        }
    }
}
