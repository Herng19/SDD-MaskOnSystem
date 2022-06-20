package com.example.maskon.controller.VaccineManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.maskon.R;
import com.example.maskon.model.VaccinationRecord;

public class VaccineDependent extends AppCompatActivity {

    //declare text input
    EditText full_name_input,  relation_input, phone_number_input, current_address_input;
    Button btn_SubmitDep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_dependent);

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
        Button btnOpenNext = (Button) findViewById(R.id.btn_next);
        btnOpenNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineDependent.this, register_success.class));
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
}