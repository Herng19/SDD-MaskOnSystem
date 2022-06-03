package com.example.maskon.view.CenterView;

import static com.example.maskon.model.DBMain.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.maskon.R;
import com.example.maskon.model.CenterRecord.CenterRecord;
import com.example.maskon.model.DBMain;

import java.util.ArrayList;

public class CenterList extends AppCompatActivity {
DBMain dbMain;
SQLiteDatabase sqLiteDatabase;
RecyclerView recyclerView;
MyAdapter myAdapter;
Button addBtn, userBtn;
CenterRecord centerRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_list);

        userBtn=(Button) findViewById(R.id.useCenterList);
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CenterList.this, QuarantineCenterList.class);
                startActivity(intent);
            }
        });

        centerRecord = new CenterRecord();
        dbMain=new DBMain(this);
        findId();
        toAddCenterPage();
        displayCenter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    //function to display all centers for admin
    private void displayCenter() {
        centerRecord.setContext(CenterList.this);
        Cursor cursor = centerRecord.readCenter();
        ArrayList<CenterRecord> centers=new ArrayList<>();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                byte[] image = cursor.getBlob(1);
                String name = cursor.getString(2);
                String address = cursor.getString(3);
                String PIC = cursor.getString(4);
                String phoneNum = cursor.getString(5);
                String email = cursor.getString(6);
                int maxCap = cursor.getInt(7);
                int currCap = cursor.getInt(8);
                centers.add(new CenterRecord(id, image, name, address, PIC, phoneNum, email, maxCap, currCap));
            }
            myAdapter = new MyAdapter(this, R.layout.card_view, centers, sqLiteDatabase, false);
            recyclerView.setAdapter(myAdapter);
        }
    }

    //function to find id from xml
    private void findId() {
        recyclerView=findViewById(R.id.recyclerView);
        addBtn=(Button) findViewById(R.id.addNewCenterBtn);
    }

    //function to navigate to add center page
    private void toAddCenterPage(){
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CenterList.this, AddNewCenter.class);
                startActivity(intent);
            }
        });
    }
}