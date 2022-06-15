package com.example.maskon.view.VaccineView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maskon.R;

public class VaccineInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_information);

        //hide titlebar in emulator
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_vaccine_information);


        //move to the next page
        Button btnOpenRegister = (Button) findViewById(R.id.btn_register);
        btnOpenRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineInformation.this, VaccineRegistration.class));
            }
        });
    }
}