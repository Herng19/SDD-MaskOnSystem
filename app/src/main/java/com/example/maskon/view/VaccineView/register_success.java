package com.example.maskon.view.VaccineView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.maskon.R;
import com.example.maskon.model.VaccinationRecord;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class register_success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_success);

        //move to vaccineview page
        Button btnOpenHome = (Button) findViewById(R.id.btn_Home);
        btnOpenHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register_success.this, VaccineView.class));
            }
        });

        //Initialize


    }


}