package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;

public class SplashLaunchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_launch);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        new Handler().postDelayed(() -> {
            Intent i=new Intent(SplashLaunchActivity.this, MainActivity.class);
            finish(); startActivity(i);
        }, 1000);
    }
}

