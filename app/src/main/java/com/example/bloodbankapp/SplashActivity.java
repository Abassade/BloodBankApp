package com.example.bloodbankapp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.activity_go, R.anim.activity_anim);
                finish();
            }
        };

        Handler handler = new Handler();
        handler.postDelayed(runnable, 3000);
    }


    //    void anim(){
//        YoYo.with(Techniques.FlipInX)
//                .duration(100)
//                .repeat(5)
//                .playOn(coin);
//    }
}
