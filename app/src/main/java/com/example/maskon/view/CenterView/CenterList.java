package com.example.maskon.view.CenterView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maskon.R;

public class CenterList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_list);

        Button addBtn = (Button) findViewById(R.id.addNewCenterBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CenterList.this, AddNewCenter.class);
                startActivity(intent);
            }
        });
    }
}