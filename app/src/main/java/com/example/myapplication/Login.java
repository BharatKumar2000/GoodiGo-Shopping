package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

     EditText mail;
     EditText pass;
     Button button1;
     FirebaseAuth firebaseAuth;
     FirebaseAuth.AuthStateListener authStateListener;
     TextView register;
     EditText mailerr;
     EditText passerr;
     TextView forgotpassword;
     private ProgressBar progressBarlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBarlogin=findViewById(R.id.pglogin);
        firebaseAuth=FirebaseAuth.getInstance();
        mail=findViewById(R.id.email);
        //mailerr=findViewById(R.id.emailError);
        //passerr=findViewById(R.id.passError);
        pass=findViewById(R.id.password);
        button1=findViewById(R.id.login);
        register=findViewById(R.id.register);
        //forgotpassword=findViewById(R.id.tvforgotpassword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,SignIn.class));
            }
        });
        authStateListener=new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                if(firebaseUser!=null)
                {

                    //Toast.makeText(getApplicationContext(),"You are logged in",Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(Login.this, MainActivity.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please Sign up first",Toast.LENGTH_SHORT).show();
                   // startActivity(new Intent(Login.this, SignIn.class));
                }
            }
        };
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mail.getText().toString();
                String password = pass.getText().toString();
                if (email.isEmpty()) {
                    mail.setError("Please Enter email id.");
                    mail.requestFocus();
                } else if (password.isEmpty()) {
                    pass.setError("Please Enter password.");
                    pass.requestFocus();
                } else if (password.isEmpty() && email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fields are Empty", Toast.LENGTH_SHORT).show();
                } else
                    {
                        progressBarlogin.setVisibility(View.VISIBLE);

                        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()) {
                                //Toast.makeText(getApplicationContext(), "Error Occured", Toast.LENGTH_SHORT).show();
                                try
                                {
                                    throw task.getException();
                                }
                                // if user enters wrong email.

                                catch (FirebaseAuthInvalidUserException invalidEmail)
                                {
                                    progressBarlogin.setVisibility(View.INVISIBLE);
                                    mail.setText("");
                                    mail.setError("User mail does not exist");
                                    mail.requestFocus();
                                }
                                // if user enters wrong password.
                                catch (FirebaseAuthInvalidCredentialsException wrongPassword)
                                {
                                    progressBarlogin.setVisibility(View.INVISIBLE);
                                    pass.setText("");
                                    pass.setError("Invalid Password");
                                    pass.requestFocus();
                                }
                                catch (Exception e)
                                {
                                    Log.d("TAG", "onComplete: " + e.getMessage());
                                }
                            }
                            else
                            {
                                progressBarlogin.setVisibility(View.INVISIBLE);

                                Toast.makeText(getApplicationContext(),"You are logged in",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this, MainActivity.class));
                            }
                        }
                    });
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }
}