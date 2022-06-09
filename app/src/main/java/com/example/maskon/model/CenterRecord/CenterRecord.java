package com.example.maskon.model.CenterRecord;


import static com.example.maskon.model.DBMain.TABLENAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.maskon.model.DBMain;

public class CenterRecord{
    private int Center_ID;
    private byte[] Center_Image;
    private String Center_Name, Center_Address, Center_PIC, Center_PhoneNum, Center_Email;
    private int Max_Cap, Curr_Cap;
    SQLiteDatabase sqLiteDatabase;
    DBMain dbMain;
    private Context context;

    //constructor for model center record
    public CenterRecord(int center_id, byte[] center_image, String center_name, String center_address, String center_pic, String center_phoneNum, String center_email, int max_cap, int curr_cap) {
        this.Center_ID = center_id;
        this.Center_Image = center_image;
        this.Center_Name = center_name;
        this.Center_Address = center_address;
        this.Center_PIC = center_pic;
        this.Center_PhoneNum = center_phoneNum;
        this.Center_Email = center_email;
        this.Max_Cap = max_cap;
        this.Curr_Cap = curr_cap;
    }

    public CenterRecord(){
    }

    //function to set context
    public void setContext(Context context) {
        this.context = context;
    }

    //function to read center information
    public Cursor readCenter(){
        dbMain = new DBMain(context);
        sqLiteDatabase=dbMain.getReadableDatabase();
        Cursor cursor=null;
        if(sqLiteDatabase!= null) {
            cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLENAME, null);
        }
        return cursor;
    }

    //function to add new center
    public void addCenter(ContentValues cv) {
        dbMain = new DBMain(context);
        sqLiteDatabase = dbMain.getWritableDatabase();

        Long insert = sqLiteDatabase.insert(TABLENAME, null, cv);
        if (insert != null) {
            Toast.makeText(context, "New Center Created!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
    }

    //function to update center information
    public void updateCenter(ContentValues cv, int id){
        dbMain = new DBMain(context);
        sqLiteDatabase = dbMain.getWritableDatabase();

        long update = sqLiteDatabase.update(TABLENAME, cv, "Center_ID="+id, null);

        if(update!=-1) {
            Toast.makeText(context, "Center Updated Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Center Update Failed", Toast.LENGTH_SHORT).show();
        }
    }

    //function to delete center
    public void deleteCenter(int id){
        dbMain = new DBMain(context);
        sqLiteDatabase = dbMain.getReadableDatabase();
        long delete = sqLiteDatabase.delete(TABLENAME, "Center_ID=" + id, null);
    }

    //getter and setter section for information of quarantine centers
    public int getCenter_ID() {
        return Center_ID;
    }

    public void setCenter_ID(int center_ID) {
        this.Center_ID = center_ID;
    }

    public byte[] getCenter_Image() {
        return Center_Image;
    }

    public void setCenter_Image(byte[] center_Image) {
        this.Center_Image = center_Image;
    }

    public String getCenter_Name() {
        return Center_Name;
    }

    public void setCenter_Name(String center_Name) {
        this.Center_Name = center_Name;
    }

    public String getCenter_Address() {
        return Center_Address;
    }

    public void setCenter_Address(String center_Address) {
        this.Center_Address = center_Address;
    }

    public String getCenter_PIC() {
        return Center_PIC;
    }

    public void setCenter_PIC(String center_PIC) {
        Center_PIC = center_PIC;
    }

    public String getCenter_PhoneNum() {
        return Center_PhoneNum;
    }

    public void setCenter_PhoneNum(String center_PhoneNum) {
        this.Center_PhoneNum = center_PhoneNum;
    }

    public String getCenter_Email() {
        return Center_Email;
    }

    public void setCenter_Email(String center_Email) {
        this.Center_Email = center_Email;
    }

    public int getMax_Cap() {
        return Max_Cap;
    }

    public void setMax_Cap(int max_Cap) {
        this.Max_Cap = max_Cap;
    }

    public int getCurr_Cap() {
        return Curr_Cap;
    }

    public void setCurr_Cap(int curr_Cap) {
        this.Curr_Cap = curr_Cap;
    }

}
