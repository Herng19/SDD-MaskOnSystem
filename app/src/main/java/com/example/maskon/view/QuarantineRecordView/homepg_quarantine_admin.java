package com.example.maskon.view.QuarantineRecordView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.maskon.R;
import com.google.android.material.button.MaterialButton;

public class homepg_quarantine_admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepg_quarantine_admin);

        //code for view quarantine button
        MaterialButton materialButton3 = findViewById(R.id.materialButton3);
        materialButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepg_quarantine_admin.this, view_quarantine_details.class);
                startActivity(intent);
            }
        });
    }
}