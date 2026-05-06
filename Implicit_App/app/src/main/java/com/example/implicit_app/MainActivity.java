package com.example.implicit_app;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSms, btnCall, btnSettings, btnNetwork;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSms = findViewById(R.id.btnSms);
        btnCall = findViewById(R.id.btnCall);
        btnSettings = findViewById(R.id.btnSettings);
        btnNetwork = findViewById(R.id.btnNetwork);

        // SMS Intent
        btnSms.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:9876543210"));
            intent.putExtra("sms_body", "Hello from my App!");
            startActivity(intent);
        });

        // Call Intent
        btnCall.setOnClickListener(view -> {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE}, 1);

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:9423050757"));
            startActivity(intent);
        });

        // Open Settings
        btnSettings.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
        });

        // Network Details
        btnNetwork.setOnClickListener(view -> {
            ConnectivityManager cm =
                    (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

            if (activeNetwork != null && activeNetwork.isConnected()) {
                Toast.makeText(this,
                        "Connected to: " + activeNetwork.getTypeName(),
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,
                        "No Internet Connection",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}