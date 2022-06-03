package com.example.maskon.view.CenterView;

import static com.example.maskon.model.DBMain.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.maskon.R;
import com.example.maskon.model.CenterRecord.CenterRecord;
import com.example.maskon.model.DBMain;

import java.util.ArrayList;

public class QuarantineCenterList extends AppCompatActivity {
    DBMain dbMain;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    CenterRecord centerRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarantine_center_list);

        centerRecord = new CenterRecord();
        dbMain=new DBMain(this);
        findId();
        displayCenter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    //funcion to display all centers for user
    private void displayCenter() {
        centerRecord.setContext(QuarantineCenterList.this);
        Cursor cursor=centerRecord.readCenter();
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
            myAdapter = new MyAdapter(this, R.layout.card_view, centers, sqLiteDatabase, true);
            recyclerView.setAdapter(myAdapter);
        }
    }

    //function to find id from xml
    private void findId() {
        recyclerView = findViewById(R.id.userRecyclerView);
    }
}