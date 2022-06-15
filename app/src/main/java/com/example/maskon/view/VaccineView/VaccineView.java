package com.example.maskon.view.VaccineView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maskon.R;

public class VaccineView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_view);

        //hide titlebar in emulator
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_vaccine_view);

        //move to the VaccineRegistration page
        Button btnOpenVaccineRegister = (Button) findViewById(R.id.btn_VaccineRegister);
        btnOpenVaccineRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineView.this, VaccineInformation.class));
            }
        });

        //move to DigitalCert page
        Button btnOpenDigCert = (Button) findViewById(R.id.btn_Certificate);
        btnOpenDigCert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineView.this, VaccineCertificate.class));
            }
        });

        //move to addDependent page
        Button btnAddDependent = (Button) findViewById(R.id.btn_AddDependent);
        btnAddDependent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineView.this, VaccineDependent.class));
            }
        });


    }

}