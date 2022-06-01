package com.example.maskon.view.CenterView;

import static com.example.maskon.model.DBMain.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.maskon.R;
import com.example.maskon.model.CenterRecord.CenterRecord;
import com.example.maskon.model.DBMain;

import java.util.ArrayList;
import java.util.Collection;

public class CenterList extends AppCompatActivity {
DBMain dbMain;
SQLiteDatabase sqLiteDatabase;
RecyclerView recyclerView;
MyAdapter myAdapter;
Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_list);

        dbMain=new DBMain(this);
        findId();
        toAddCenterPage();
        displayCenter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void displayCenter() {
        sqLiteDatabase=dbMain.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from " + TABLENAME + "", null);
        ArrayList<CenterRecord>centers=new ArrayList<>();
        while(cursor.moveToNext()){
            int id=cursor.getInt(0);
            byte[] image=cursor.getBlob(1);
            String name=cursor.getString(2);
            String address=cursor.getString(3);
            String PIC=cursor.getString(4);
            String phoneNum=cursor.getString(5);
            String email=cursor.getString(6);
            int maxCap=cursor.getInt(7);
            int currCap=cursor.getInt(8);
            centers.add(new CenterRecord(id,image,name,address,PIC,phoneNum,email,maxCap,currCap));
        }
        cursor.close();
        myAdapter=new MyAdapter(this, R.layout.card_view, centers, sqLiteDatabase);
        recyclerView.setAdapter(myAdapter);

    }

    private void findId() {
        recyclerView=findViewById(R.id.recyclerView);
        addBtn=(Button) findViewById(R.id.addNewCenterBtn);
    }

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