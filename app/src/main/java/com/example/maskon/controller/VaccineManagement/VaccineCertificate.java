package com.example.maskon.controller.VaccineManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maskon.R;

public class VaccineCertificate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_certificate);



        //Move to home page
        Button btnHomeDigit = (Button) findViewById(R.id.btn_HomeDigital);
        btnHomeDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineCertificate.this, VaccineView.class));
            }
        });
    }
}