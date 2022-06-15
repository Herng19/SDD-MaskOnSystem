package com.example.maskon.view.QuarantineRecordView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.maskon.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

public class homepg_quarantine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepg_quarantine);
        BottomNavigationView btmNavigateView = findViewById(R.id.bottomNavigationView);
        btmNavigateView.setBackground(null);

        //code for add quarantine button
        MaterialButton materialButton2 = findViewById(R.id.materialButton2);
        materialButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepg_quarantine.this, add_quarantine_details.class);
                startActivity(intent);
            }
        });

        //code for edit button
        MaterialButton materialButton4 = findViewById(R.id.materialButton4);
        materialButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepg_quarantine.this, edit_quarantine_details.class);
                startActivity(intent);
            }
        });

        //code for view button
        MaterialButton materialButton3 = findViewById(R.id.materialButton3);
        materialButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepg_quarantine.this, view_quarantine_details.class);
                startActivity(intent);
            }
        });

    }
}