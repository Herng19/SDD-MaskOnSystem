package com.example.maskon.controller.MovementTracementManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maskon.R;

public class CheckInMenu extends AppCompatActivity {
    private Button btnCheckinCheckout, btnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_menu);

        //checkinmenu
        btnCheckinCheckout = findViewById(R.id.btnCheckinCheckout);
        btnCheckinCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMovementHistory();
            }
        });

        //scan
        btnScan = findViewById(R.id.btnScan);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScanQRCode();
            }
        });
    }

    public void openMovementHistory (){
        Intent intent = new Intent(this,MovementHistory.class);
        startActivity(intent);
    }

    public void openScanQRCode (){
        Intent intent = new Intent(this,ScanQRCode.class);
        startActivity(intent);
    }
}