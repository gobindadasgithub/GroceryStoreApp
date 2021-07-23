package com.example.mygrocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrictionActivity extends AppCompatActivity {

private Button signUp;
private EditText name,email,password;
    private TextView  signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registriction);

        signUp=findViewById(R.id.reg_btn);
        signIn=findViewById(R.id.sign_in);
        name=findViewById(R.id.name_reg);
        email=findViewById(R.id.email_reg);
        password=findViewById(R.id.password_reg);


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrictionActivity.this,LoginActivity.class));
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

}