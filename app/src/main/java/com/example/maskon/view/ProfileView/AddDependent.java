package com.example.maskon.view.ProfileView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.maskon.DBmain;
import com.example.maskon.R;

public class AddDependent extends AppCompatActivity {

    EditText PassNumber_input, OriginCountry_input, Gender_input, PhoneNumber_input, Address_input;
    Button AddDependent_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dependent);

        //Add Dependent Button
        Button btnAddDependent = (Button) findViewById(R.id.AddDependent_btn);
        btnAddDependent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddDependent.this , AddDependent.class));
            }
        });

    }
}