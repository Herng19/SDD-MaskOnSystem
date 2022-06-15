package com.example.maskon.model;

public class QuarantineRecord extends SQLiteOpenHelper {
    public static final String DBNAME="maskOn.db";
    public static final String TABLENAME="QUARANTINE_RECORD";
    public static final int VER=1;
    public QuarantineRecord(@Nullable Context context){
                super(context, DBNAME, null, VER);
            }

    public void onCreate(SQLiteDatabase db) {
        String query="create table " ++ "+"
    }

}
