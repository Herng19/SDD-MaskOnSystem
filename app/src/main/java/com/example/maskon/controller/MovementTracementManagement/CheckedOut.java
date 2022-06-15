package com.example.maskon.controller.MovementTracementManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maskon.R;

public class CheckedOut extends AppCompatActivity {
    private Button buttonback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checked_out);

        //back
        buttonback = findViewById(R.id.button);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCheckInMenu();
            }
        });
    }

    public void openCheckInMenu (){
        Intent intent = new Intent(this,CheckInMenu.class);
        startActivity(intent);
    }
}