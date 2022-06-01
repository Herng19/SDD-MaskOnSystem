package com.example.maskon.view.CenterView;

import static com.example.maskon.model.DBMain.TABLENAME;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.maskon.R;
import com.example.maskon.model.DBMain;
import com.example.maskon.model.DBMain;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class AddNewCenter extends AppCompatActivity {
DBMain dbmain;
SQLiteDatabase sqLiteDatabase;
ImageView centerImage;
EditText centerName, centerAddress, centerPhoneNum, centerPIC, centerEmail, centerMaxCap, centerCurrCap;
Button submit, backBtn, updateBtn;
int id=0;

public static final int CAMERA_REQUEST=100;
public static final int STORAGE_REQUEST=101;
public static final int SELECT_PICTURE=200;
String[]cameraPermission;
String[]storagePermission;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_center);
        cameraPermission=new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        dbmain=new DBMain(this);
        findId();
        back();
        insertData();
        imagePick();
        editData();
    }

    private void editData() {
        if (getIntent().getBundleExtra("centerdata")!=null){
            Bundle bundle = getIntent().getBundleExtra("centerdata");
            id=bundle.getInt("Center_ID");

            byte[]bytes = bundle.getByteArray("Center_Image");
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            centerImage.setImageBitmap(bitmap);

            centerName.setText(bundle.getString("Center_Name"));
            centerAddress.setText(bundle.getString("Address"));
            centerPIC.setText(bundle.getString("PIC"));
            centerPhoneNum.setText(bundle.getString("Contact_Num"));
            centerEmail.setText(bundle.getString("Email"));
            centerMaxCap.setText(String.valueOf(bundle.getInt("Max_Capacity")));
            centerCurrCap.setText(String.valueOf(bundle.getInt("Curr_Capacity")));

            submit.setVisibility(View.GONE);
            updateBtn.setVisibility(View.VISIBLE);

        }
    }

    private void imagePick() {
        centerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int image=0;
                if(image==0){
                    if(!checkCameraPermission()){
                        requestCameraPermission();
                    }
                    else{
                        pickFromGallery();
                    }
                }
                else if(image==1){
                    if(!checkStoragePermission()){
                        requestStoragePermission();
                    }
                    else{
                        pickFromGallery();
                    }
                }
            }
        });
    }

    private void requestStoragePermission() {
        requestPermissions(storagePermission, STORAGE_REQUEST);
    }

    private boolean checkStoragePermission() {
        boolean result=ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)==(PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void pickFromGallery() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                Picasso.with(this).load(selectedImageUri).into(centerImage);
                /*if (null != selectedImageUri) {
                    // update the preview image in the layout
                    centerImage.setImageURI(selectedImageUri);
                }*/
            }
        }
    }

    //function to get camera permission from user
    private void requestCameraPermission() {
        requestPermissions(cameraPermission, CAMERA_REQUEST);
    }

    //function to check whether this app have permission to access user's camera and gallery
    private boolean checkCameraPermission() {
        boolean storage_permission= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)==(PackageManager.PERMISSION_GRANTED);
        boolean camera_permission=ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)==(PackageManager.PERMISSION_GRANTED);
        return storage_permission && camera_permission;
    }

    //function to go back to center list page
    private void back() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNewCenter.this, CenterList.class);
                startActivity(intent);
            }
        });
    }


    //function to insert data into database and set all values to null after data inserted
    private void insertData() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv=new ContentValues();
                cv.put("Center_Image", ImageViewToByte(centerImage));
                cv.put("Center_Name", centerName.getText().toString());
                cv.put("Address", centerAddress.getText().toString());
                cv.put("PIC", centerPIC.getText().toString());
                cv.put("Contact_Num", centerPhoneNum.getText().toString());
                cv.put("Email", centerEmail.getText().toString());
                cv.put("Max_Capacity", Integer.parseInt(centerMaxCap.getText().toString()));
                cv.put("Curr_Capacity", Integer.parseInt(centerCurrCap.getText().toString()));

                try {
                    sqLiteDatabase = dbmain.getWritableDatabase();
                    Long insert = sqLiteDatabase.insert(TABLENAME, null, cv);
                    if (insert != null) {
                        Toast.makeText(AddNewCenter.this, "New Center Created!", Toast.LENGTH_SHORT).show();
                        //clear input text when data submitted
                        centerImage.setImageResource(R.mipmap.ic_launcher);
                        centerName.setText("");
                        centerAddress.setText("");
                        centerPIC.setText("");
                        centerEmail.setText("");
                        centerPhoneNum.setText("");
                        centerMaxCap.setText("");
                        centerCurrCap.setText("");
                        Intent intent = new Intent(AddNewCenter.this, CenterList.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(AddNewCenter.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(AddNewCenter.this, "Error when inserting data, " + e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //for update data
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("Center_Image", ImageViewToByte(centerImage));
                cv.put("Center_Name", centerName.getText().toString());
                cv.put("Address", centerAddress.getText().toString());
                cv.put("PIC", centerPIC.getText().toString());
                cv.put("Contact_Num", centerPhoneNum.getText().toString());
                cv.put("Email", centerEmail.getText().toString());
                cv.put("Max_Capacity", Integer.parseInt(centerMaxCap.getText().toString()));
                cv.put("Curr_Capacity", Integer.parseInt(centerCurrCap.getText().toString()));
                sqLiteDatabase=dbmain.getWritableDatabase();

                long update = sqLiteDatabase.update(TABLENAME, cv, "Center_ID="+id, null);
                if(update!=-1){
                    Toast.makeText(AddNewCenter.this, "Center Updated Successfully", Toast.LENGTH_SHORT).show();
                    centerImage.setImageResource(R.mipmap.ic_launcher);
                    centerName.setText("");
                    centerAddress.setText("");
                    centerPIC.setText("");
                    centerEmail.setText("");
                    centerPhoneNum.setText("");
                    centerMaxCap.setText("");
                    centerCurrCap.setText("");

                    updateBtn.setVisibility(View.GONE);
                    submit.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(AddNewCenter.this, CenterList.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(AddNewCenter.this, "Center Update Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //function to convert image to byte
    private byte[] ImageViewToByte(ImageView centerImage){
        Bitmap bitmap=((BitmapDrawable)centerImage.getDrawable()).getBitmap();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
        byte[] bytes=stream.toByteArray();
        return bytes;
    }

    //function to get all id of view
    private void findId() {
        centerImage=(ImageView) findViewById(R.id.centerImage);
        centerName=(EditText) findViewById(R.id.inputCenterName);
        centerAddress=(EditText) findViewById(R.id.inputCenterAddress);
        centerPIC=(EditText)  findViewById(R.id.inputPIC);
        centerPhoneNum=(EditText)  findViewById(R.id.inputPhoneNum);
        centerEmail= (EditText) findViewById(R.id.inputEmail);
        centerMaxCap= (EditText) findViewById(R.id.inputMaxCap);
        centerCurrCap= (EditText) findViewById(R.id.inputCurrCap);
        submit= (Button) findViewById(R.id.addBtn);
        backBtn = (Button) findViewById(R.id.backBtn);
        updateBtn = (Button) findViewById(R.id.updateBtn);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case CAMERA_REQUEST:{
                if(grantResults.length>0){
                    boolean camera_accept=grantResults[0]==PackageManager.PERMISSION_GRANTED;
                    boolean storage_accept=grantResults[1]==PackageManager.PERMISSION_GRANTED;
                    if(camera_accept&&storage_accept){
                        pickFromGallery();
                    }else{
                        Toast.makeText(this, "Enable camera and storage permission", Toast.LENGTH_SHORT);

                    }
                }
            }
            break;
            case STORAGE_REQUEST:{
                if(grantResults.length>0){
                    boolean storage_accept=grantResults[0]==PackageManager.PERMISSION_GRANTED;
                    if(storage_accept){
                        pickFromGallery();
                    }else{
                        Toast.makeText(this, "Please enable storage permission",Toast.LENGTH_SHORT);
                    }
                }
            }
            break;
        }
    }
}