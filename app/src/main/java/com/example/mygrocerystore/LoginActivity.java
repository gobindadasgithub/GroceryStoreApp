package com.example.mygrocerystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {
    private Button signIn;
    private EditText email,passsword;
    private TextView signUp;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signIn=findViewById(R.id.login_btn);
       email=findViewById(R.id.email_logn);
       passsword=findViewById(R.id.password_logn);
       signUp=findViewById(R.id.sign_Up);
       auth=FirebaseAuth.getInstance();

       signUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(LoginActivity.this,RegistrictionActivity.class));
           }
       });

       signIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String useremail=email.getText().toString();
               String userepassword=passsword.getText().toString();
               if (TextUtils.isEmpty(useremail)){
                   Toast.makeText(LoginActivity.this,"Email is Empty!",Toast.LENGTH_SHORT).show();
                   return;
               }
               if (TextUtils.isEmpty(userepassword)){
                   Toast.makeText(LoginActivity.this,"Password is Empty!",Toast.LENGTH_SHORT).show();
                   return;


               }
          if (userepassword.length()<6){
              Toast.makeText(LoginActivity.this, "Password length must be greater then 6 letter", Toast.LENGTH_SHORT).show();
              return;

          }
          auth.signInWithEmailAndPassword(useremail,userepassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                  if (task.isSuccessful()){
                      Toast.makeText(LoginActivity.this,"Login Successfull",Toast.LENGTH_SHORT).show();

                  }
                  else{
                      Toast.makeText(LoginActivity.this,"Error"+task.getException(),Toast.LENGTH_SHORT).show();


                  }

              }
          });



           }
       });


    }


}