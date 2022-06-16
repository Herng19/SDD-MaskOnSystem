package com.example.maskon.model.MovementTracement;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;

public class MovementRecord extends SQLiteOpenHelper{
    private final static String DATABASE_NAME= "MRC.db";
    private final static int DATABASE_VERSION= 1;

    public MovementRecord(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //*** table  ***
    private final static String TABLE_NAME= "MOVEMENT_TRACEMENT";

    //*** column inside table  ***
    private final static String COLUMN_ID = "Tracement_ID";
    private final static String COLUMN_PREMISESID = "Premises_ID";
    private final static String COLUMN_USERID = "User_ID";
    private final static String COLUMN_VACCINATIONSTATUS = "VaccinationStatus";
    private final static String COLUMN_RISKSTATUS = "RiskStatus";
    private final static String COLUMN_IN = "CheckOut_DateTime";
    private final static String COLUMN_OUT = "CheckInDateTime";

    //***table ***
    private void createTable(SQLiteDatabase db){
        String query = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME + " ("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_PREMISESID + " INTEGER, "+
                COLUMN_USERID + " INTEGER, "+
                COLUMN_VACCINATIONSTATUS + " INTEGER, "+
                COLUMN_RISKSTATUS + " INTEGER, "+
                COLUMN_IN + " DATE, "+
                COLUMN_OUT + " DATE);";

        db.execSQL(query);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP Table if exists "+ TABLE_NAME);
    }

    //insert info function
    public void addInfoData(int PremisesID, String CheckInDateTime, String CheckOutDateTime){

        SQLiteDatabase db = this.getWritableDatabase();

        //Create table if table not exist
        createTable(db);

        //*** table ***
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERID, 1); //auto increment
        contentValues.put(COLUMN_PREMISESID, PremisesID);
        contentValues.put(COLUMN_IN, CheckInDateTime);
        contentValues.put(COLUMN_OUT, CheckOutDateTime);

        db.insert(TABLE_NAME, null, contentValues);

        db.close();
    }

    //edit info function
    public void editInfoData(int id, int PremisesID, String CheckInDateTime, String CheckOutDateTime){

        SQLiteDatabase db = this.getWritableDatabase();

        //*** table ***
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USERID,id);
        cv.put(COLUMN_PREMISESID,PremisesID);
        cv.put(COLUMN_IN,CheckInDateTime);
        cv.put(COLUMN_OUT,CheckOutDateTime);

        db.update(TABLE_NAME, cv, COLUMN_ID+ " = ?", new String[]{String.valueOf(id)});

        db.close();
    }

    //Database read
    public Cursor readAllData(){
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor cursor = null;
        try{
            SQLiteDatabase db = this.getReadableDatabase();

            if(db != null){
                cursor = db.rawQuery(query, null);
            }
        }
        catch (Exception e){
            e.getMessage();
        }
        return cursor;
    }

    //delete info function
    public void deleteInfoData(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        //*** table  ***
        String whereClause = COLUMN_ID+ "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        db.delete(TABLE_NAME, whereClause, whereArgs);

        db.close();
    }










}
