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
import android.widget.Toast;

import com.example.myapplication.main.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.FirebaseDatabase;

public class SignIn extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    EditText mail2;
    EditText pass2;
    Button button;
    EditText name;
    EditText age;
    private ProgressBar progressBarSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        firebaseAuth= FirebaseAuth.getInstance();
        mail2=(EditText)findViewById(R.id.Signemail);
        pass2=(EditText)findViewById(R.id.Signpassword);
        name=findViewById(R.id.SignName);
        age=findViewById(R.id.SignAge);
        progressBarSignin=findViewById(R.id.pgsign);
        button=findViewById(R.id.signin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String sname=name.getText().toString();
               String sage=age.getText().toString();
               String email=mail2.getText().toString();
               String password=pass2.getText().toString();
                if (sname.isEmpty() ) {
                    name.setError("Please enter Name");
                    name.requestFocus();
                } else if (sage.isEmpty()) {
                    age.setError("Please enter Age");
                    age.requestFocus();
                }
                else if(Integer.parseInt(sage)>100) {
                    age.setError("Please enter Valid Age");
                    age.requestFocus();
                }
                else if (email.isEmpty()) {
                    mail2.setError("Please enter Email id");
                    mail2.requestFocus();
                } else if (password.isEmpty()) {
                    pass2.setError("Please enter Password");
                    pass2.requestFocus();
                }
                else if (password.length() <6) {
                    pass2.setError("Minimum password length should be 6 characters.");
                    pass2.requestFocus();
                }
                else  {
                   progressBarSignin.setVisibility(View.VISIBLE);
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                User user=new User(sname,sage,email,null);
                                FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(), "DATA stored!", Toast.LENGTH_LONG).show();
                                            progressBarSignin.setVisibility(View.INVISIBLE);
                                            Intent signtoLogin=new Intent(SignIn.this, Login.class);
                                            startActivity(signtoLogin);
                                        }
                                        else
                                            {
                                                Toast.makeText(getApplicationContext(), "ERROR: DATA  not stored!", Toast.LENGTH_LONG).show();

                                            }
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.e("FIREBASE", "Some exception occurred: ", e);

                                            }
                                        })
                                ;
                            }

                            else
                                {
                                    try{
                                        throw task.getException();
                                    }
                                    catch (FirebaseAuthUserCollisionException firebaseAuthUserCollisionException)
                                    {
                                        progressBarSignin.setVisibility(View.INVISIBLE);
                                        mail2.setText("");
                                        mail2.setError("User mail Already Exists");
                                        mail2.requestFocus();
                                    }
                                    catch(FirebaseAuthWeakPasswordException weakPasswordException)
                                    {
                                        progressBarSignin.setVisibility(View.INVISIBLE);
                                        pass2.setText("");
                                        pass2.setError("Weak Password Strength");
                                        pass2.requestFocus();
                                    }
                                    catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    progressBarSignin.setVisibility(View.INVISIBLE);

                                    Toast.makeText(getApplicationContext(), "SignUp  Not successful!", Toast.LENGTH_SHORT).show();
                            }


                    }

                });
            }

        }
    });
    // Write a message to the database


}


}