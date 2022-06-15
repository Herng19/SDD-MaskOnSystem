package com.example.maskon.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

//database
public class VaccinationRecord extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="maskOn.db";
    public static final int VER=1;

    public static final String TABLE_NAME="vaccine";
    public static final String COLUMN_ID= "_id";
    public static final String COLUMN_NAME= "full_name";
    public static final String COLUMN_RELATION= "relation";
    public static final String COLUMN_PHONE= "phone_number";
    public static final String COLUMN_ADDRESS= "current_address";
    private final Context context;

    public VaccinationRecord(@Nullable Context context) {

        super(context, DATABASE_NAME, null, VER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE " + TABLE_NAME+ "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME
        + " TEXT, " + COLUMN_RELATION + " TEXT, " + COLUMN_PHONE + " TEXT, " + COLUMN_ADDRESS + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        String query="drop table if exists " + TABLE_NAME+"";
        onCreate(db);
        }

        //Method : Add Dependent Data to Database
        public void addDependent(String full_name, String relation, String phone_number, String current_address){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues(); //To store the data from apps to database

            //declare column for every data
            cv.put(COLUMN_NAME ,full_name);
            cv.put(COLUMN_RELATION ,relation);
            cv.put(COLUMN_PHONE ,phone_number);
            cv.put(COLUMN_ADDRESS ,current_address);
            long result = db.insert(TABLE_NAME, null, cv); // store result

            //If the data failed to store in database
            if(result == -1) {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show(); // if success
            }
        }

        //Read data in database
        public Cursor readAllData(){
         String query = "SELECT * FROM" + TABLE_NAME;
         SQLiteDatabase db = this.getReadableDatabase();

         //check database if not null
         Cursor cursor = null;
         if(db !=null) {
             db.rawQuery(query, null);
         }

         return cursor;

        }
}
