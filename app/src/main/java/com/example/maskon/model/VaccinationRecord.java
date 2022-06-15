package com.example.maskon.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//database
public class VaccinationRecord extends SQLiteOpenHelper {
    public static final String DBNAME="maskOn.db";
    public static final String TABLENAME="vaccine.db";
    public static final int VER=1;

    public VaccinationRecord(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="create table " + TABLENAME+ "(id Integer primary key, avatar blob, name text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="drop table if exists " + TABLENAME+"";
        db.execSQL(query);
        }
}
