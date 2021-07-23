package com.example.mygrocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private Button signIn;
    private EditText email,passsword;
    private TextView signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signIn=findViewById(R.id.login_btn);
       email=findViewById(R.id.email_logn);
       passsword=findViewById(R.id.password_logn);
       signUp=findViewById(R.id.sign_Up);

       signUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(LoginActivity.this,RegistrictionActivity.class));
           }
       });

       signIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });


    }


}