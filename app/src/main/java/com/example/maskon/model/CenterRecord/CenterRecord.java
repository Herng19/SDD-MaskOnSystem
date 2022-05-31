package com.example.maskon.model.CenterRecord;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CenterRecord extends SQLiteOpenHelper {
    public static final String DBNAME="maskOn.db";
    public static final String TABLENAME="centerRecord";
    public static final int VER=1;
    String query;

    public CenterRecord(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        query="create table "+ TABLENAME + "(Center_ID integer primary key, Center_Name text, Address text, PIC text, Contact_Num text, Email text, Max_Capacity integer, Curr_Capacity integer)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        query="drop table if exists " + TABLENAME + "";
        db.execSQL(query);
        onCreate(db);
    }
}
