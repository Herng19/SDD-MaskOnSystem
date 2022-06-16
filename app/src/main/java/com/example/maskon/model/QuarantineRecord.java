package com.example.maskon.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

//database
public class QuarantineRecord extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="maskOn.db";
    public static final int VER=1;

    public static final String TABLE_NAME="QUARANTINE_RECORD";
    public static final String COLUMN_ID= "Record_id";
    public static final String COLUMN_NAME= "name";
    public static final String COLUMN_PHONE= "phone_number";
    public static final String COLUMN_IC= "ic_number";
    public static final String COLUMN_ADDRESS= "address";
    public static final String COLUMN_TEST= "test_result";
    public static final String COLUMN_START= "date_start";
    public static final String COLUMN_END= "date_end";
    public static final String COLUMN_PLACE= "quarantine_place";
    private final Context context;

    public QuarantineRecord(@Nullable Context context) {

        super(context, DATABASE_NAME, null, VER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE " + TABLE_NAME+ "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME
                + " TEXT, " + COLUMN_PHONE + " TEXT, " + COLUMN_IC + " TEXT, " + COLUMN_ADDRESS + " TEXT, " + COLUMN_TEST
                + "TEXT, " + COLUMN_START + " TEXT, " + COLUMN_END + " TEXT, " + COLUMN_PLACE + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        String query="drop table if exists " + TABLE_NAME+"";
        onCreate(db);
    }

    //Method : Add Quarantine Details to Database
    public void addQuarantine(String name, String phone_number, String ic_number, String address, String test_result, String date_start,
                              String date_end, String quarantine_place){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues(); //To store the data from apps to database

        //declare column for every data
        cv.put(COLUMN_NAME ,name);
        cv.put(COLUMN_PHONE ,phone_number);
        cv.put(COLUMN_IC ,ic_number);
        cv.put(COLUMN_ADDRESS ,address);
        cv.put(COLUMN_TEST ,test_result);
        cv.put(COLUMN_START ,date_start);
        cv.put(COLUMN_END ,date_end);
        cv.put(COLUMN_PLACE ,quarantine_place);
        long result = db.insert(TABLE_NAME, null, cv); // store result

        //If the data failed to store in database
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show(); // if success
        }
    }
}
