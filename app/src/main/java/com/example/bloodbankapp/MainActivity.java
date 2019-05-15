package com.example.bloodbankapp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long back_pressed=0;
    private TextView donor, blood, health, info;
    private  int INTERNET_PERMISSION_CODE = 2019;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // check for internet permission
        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED){
            return;
//            Toast.makeText(this, "You have already granted this permission",
//                    Toast.LENGTH_SHORT).show();
        }
        else {
            requestInternetPermission();
        }

        donor = findViewById(R.id.donor);
        blood = findViewById(R.id.blood);
        health = findViewById(R.id.health);
        info = findViewById(R.id.info);
    }

    private void requestInternetPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET)){
            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("Internet permission is needed for this app")
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[] {Manifest.permission.INTERNET},
                                    INTERNET_PERMISSION_CODE);
                        }
                    }).create().show();
        }
        else {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.INTERNET}, INTERNET_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == INTERNET_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }

    public void itemClick(View view){
        TextView textView = (TextView)view;
        String text = textView.getText().toString().substring(0, 1);
        Intent intent = new Intent(MainActivity.this, BaseActivity.class);
        intent.putExtra("text",text);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            super.onBackPressed();
        else
        {
            Toast.makeText(getBaseContext(), "Double tap to exit", Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }
}
