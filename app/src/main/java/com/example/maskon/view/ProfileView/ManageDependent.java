package com.example.maskon.view.ProfileView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maskon.R;

public class ManageDependent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_dependent);

        //Add Dependent Button
        Button btnAddDependent = (Button) findViewById(R.id.AddDependent_btn);
        btnAddDependent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageDependent.this , AddDependent.class));
            }
        });
    }
}