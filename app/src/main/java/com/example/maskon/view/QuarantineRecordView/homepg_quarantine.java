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

    //Database related
    //declare text input
    EditText name_input,  relation_input, phone_number_input, current_address_input;
    Button btn_SubmitDep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quarantine_detail);

        //Declare to insert Input
        full_name_input = findViewById(R.id.full_name_input);
        relation_input = findViewById(R.id.relation_input);
        phone_number_input = findViewById(R.id.phone_number_input);
        current_address_input = findViewById(R.id.current_address_input);
        btn_SubmitDep = findViewById(R.id.btn_SubmitDep);

        //call method from database class

        btn_SubmitDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VaccinationRecord myDB = new VaccinationRecord(VaccineDependent.this);
                //call submit dependent method
                myDB.addDependent(full_name_input.getText().toString().trim(), relation_input.getText().toString().trim(),
                        phone_number_input.getText().toString().trim(),current_address_input.getText().toString().trim());
            }
        });



        //Move to home page
        Button btnOpenHome = (Button) findViewById(R.id.btn_cancelDep);
        btnOpenHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineDependent.this, VaccineView.class));
            }
        });
}