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

    RecyclerView recycleView;
    FloatingActionButton btn_SubmitDep;

    //Initialize
    VaccinationRecord myDB;
    ArrayList<String> _id, full_name,  relation,  phone_number,  current_address;


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

        myDB = new VaccinationRecord(register_success.this);
        _id = new ArrayList<>();
        full_name = new ArrayList<>();
        relation = new ArrayList<>();
        phone_number = new ArrayList<>();
        current_address = new ArrayList<>();
    }

    //new method to display data
     void displayData(){

        Cursor cursor = myDB.readAllData();
        //check cursor
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                full_name.add(cursor.getString(0));
                relation.add(cursor.getString(0));
                phone_number.add(cursor.getString(0));
                current_address.add(cursor.getString(0));

            }
        }


     }
}