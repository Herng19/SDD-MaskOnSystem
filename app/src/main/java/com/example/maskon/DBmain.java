package com.example.maskon;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBmain extends SQLiteOpenHelper {

    public DBmain(Context context) {
        super(context, "MaskOn.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table profile()");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

    }
}
