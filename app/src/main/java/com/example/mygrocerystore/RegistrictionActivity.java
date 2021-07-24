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

import com.example.mygrocerystore.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class RegistrictionActivity extends AppCompatActivity {

private Button signUp;
private EditText name,email,password;
    private TextView  signIn;
    FirebaseAuth auth;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registriction);

        signUp=findViewById(R.id.reg_btn);
        signIn=findViewById(R.id.sign_in);
        name=findViewById(R.id.name_reg);
        email=findViewById(R.id.email_reg);
        password=findViewById(R.id.password_reg);
        auth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();



        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrictionActivity.this,LoginActivity.class));
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String username=name.getText().toString();
                String useremail=email.getText().toString();
                String userpassword=password.getText().toString();
                if (TextUtils.isEmpty(username)){
                    Toast.makeText(RegistrictionActivity.this,"Name is Empty!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(useremail)){
                    Toast.makeText(RegistrictionActivity.this,"Email is Empty!",Toast.LENGTH_SHORT).show();
                    return;

                }if (TextUtils.isEmpty(userpassword)){
                    Toast.makeText(RegistrictionActivity.this,"Password is Empty!",Toast.LENGTH_SHORT).show();
                    return;

                }
                if (userpassword.length()<6) {
                    Toast.makeText(RegistrictionActivity.this, "Password length must be greater then 6 letter", Toast.LENGTH_SHORT).show();
                    return;
                }
                    auth.createUserWithEmailAndPassword(useremail,userpassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        UserModel userModel=new UserModel(username,useremail,userpassword);
                                        String id=task.getResult().getUser().getUid();
                                        firebaseDatabase.getReference().child("Users").child(id).setValue(userModel);

                                        Toast.makeText(RegistrictionActivity.this,"Registraction Successfull",Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Toast.makeText(RegistrictionActivity.this,"Error"+task.getException(),Toast.LENGTH_SHORT).show();

                                    }

                                }
                            });


                }
        });

        


    }




}