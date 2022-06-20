package com.example.maskon.controller.VaccineManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maskon.R;

public class VaccineRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_registration);

        //hide titlebar in emulator
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_vaccine_registration);

        //move to vaccineview page
        Button btnOpenSubmitRegister = (Button) findViewById(R.id.btn_submitRegister);
        btnOpenSubmitRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineRegistration.this, register_success.class));
            }
        });

        //move to vaccineview page
        Button btnOpenCancelRegister = (Button) findViewById(R.id.btn_cancelRegister);
        btnOpenCancelRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineRegistration.this, VaccineView.class));
            }
        });
    }
}