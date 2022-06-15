package com.example.maskon.controller.MovementTracementManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maskon.R;

public class UserTracement extends AppCompatActivity {
    private Button button4, button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tracement);

        //back
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCheckInMenu();
            }
        });

        //checkout
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCheckedOut();
            }
        });
    }

    public void openCheckInMenu (){
        Intent intent = new Intent(this,CheckInMenu.class);
        startActivity(intent);
    }

    public void openCheckedOut (){
        Intent intent = new Intent(this,CheckedOut.class);
        startActivity(intent);
    }

}