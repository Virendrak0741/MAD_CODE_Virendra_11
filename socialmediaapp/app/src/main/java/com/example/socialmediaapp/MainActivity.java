package com.example.socialmediaapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnWhatsapp, btnInstagram, btnFacebook, btnTwitter, btnYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWhatsapp = findViewById(R.id.btnWhatsapp);
        btnInstagram = findViewById(R.id.btnInstagram);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnTwitter = findViewById(R.id.btnTwitter);
        btnYoutube = findViewById(R.id.btnYoutube);

        // WhatsApp
        btnWhatsapp.setOnClickListener(v -> openApp("https://wa.me/"));

        // Instagram
        btnInstagram.setOnClickListener(v -> openApp("https://www.instagram.com/"));

        // Facebook
        btnFacebook.setOnClickListener(v -> openApp("https://www.facebook.com/"));

        // Twitter (X)
        btnTwitter.setOnClickListener(v -> openApp("https://twitter.com/"));

        // YouTube
        btnYoutube.setOnClickListener(v -> openApp("https://www.youtube.com/"));
    }

    private void openApp(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "App not installed", Toast.LENGTH_SHORT).show();
        }
    }
}