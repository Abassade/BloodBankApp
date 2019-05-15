package com.example.bloodbankapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Intent intent = getIntent();
        String textPassed = intent.getExtras().getString("text");

        switch (textPassed){
            case "B":
                fragment = new DonorFragment();
                break;
            case "N":
                fragment = new BloodFragment();
                break;
            case "H":
                fragment = new HealthFragment();
                break;
                default:
                    return;

        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.base, fragment);
        transaction.commit();
    }

}
