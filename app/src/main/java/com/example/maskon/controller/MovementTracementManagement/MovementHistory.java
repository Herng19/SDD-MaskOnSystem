package com.example.maskon.controller.MovementTracementManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maskon.R;

import org.w3c.dom.Text;

public class MovementHistory extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement_history);

        //back
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
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