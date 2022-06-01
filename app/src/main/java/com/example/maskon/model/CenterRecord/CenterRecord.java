package com.example.maskon.model.CenterRecord;

public class CenterRecord{
    private int Center_ID;
    private byte[] Center_Image;
    private String Center_Name, Center_Address, Center_PIC, Center_PhoneNum, Center_Email;
    private int Max_Cap, Curr_Cap;


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
