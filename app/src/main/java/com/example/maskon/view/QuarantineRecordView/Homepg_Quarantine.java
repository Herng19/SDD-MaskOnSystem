package com.example.maskon.view.QuarantineRecordView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.maskon.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Homepg_Quarantine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepg_quarantine);
        BottomNavigationView btmNavigateView = findViewById(R.id.bottomNavigationView);
        btmNavigateView.setBackground(null);
    }
}