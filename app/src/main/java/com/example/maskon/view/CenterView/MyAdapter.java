package com.example.maskon.view.CenterView;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maskon.R;
import com.example.maskon.model.CenterRecord.CenterRecord;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    int singleData;
    ArrayList<CenterRecord>centerRecordArrayList;
    SQLiteDatabase sqLiteDatabase;

    public MyAdapter(Context context, int singleData, ArrayList<CenterRecord> centerRecordArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.singleData = singleData;
        this.centerRecordArrayList = centerRecordArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        final CenterRecord centerRecord= centerRecordArrayList.get(position);
        byte[]image=centerRecord.getCenter_Image();
        Bitmap bitmap= BitmapFactory.decodeByteArray(image, 0, image.length);

        holder.centerImage.setImageBitmap(bitmap);
        holder.txtCenterName.setText(centerRecord.getCenter_Name());
        holder.txtCenterAddress.setText(centerRecord.getCenter_Address());
        holder.txtCenterPIC.setText(centerRecord.getCenter_PIC());
        holder.txtCenterPhoneNum.setText(centerRecord.getCenter_PhoneNum());
        holder.txtCenterEmail.setText(centerRecord.getCenter_Email());
        holder.txtCenterCurrCap.setText(String.valueOf(centerRecord.getCurr_Cap())+"/"+String.valueOf(centerRecord.getMax_Cap()));

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delete operation
            }
        });

        holder.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("Center_ID", centerRecord.getCenter_ID());
                bundle.putByteArray("Center_Image", centerRecord.getCenter_Image());
                bundle.putString("Center_Name", centerRecord.getCenter_Name());
                bundle.putString("Address", centerRecord.getCenter_Address());
                bundle.putString("PIC", centerRecord.getCenter_PIC());
                bundle.putString("Contact_Num", centerRecord.getCenter_PhoneNum());
                bundle.putString("Email", centerRecord.getCenter_Email());
                bundle.putInt("Max_Capacity", centerRecord.getMax_Cap());
                bundle.putInt("Curr_Capacity", centerRecord.getCurr_Cap());

                Intent intent = new Intent(context, AddNewCenter.class);
                intent.putExtra("centerdata", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return centerRecordArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView centerImage;
        TextView txtCenterName, txtCenterAddress, txtCenterPIC, txtCenterPhoneNum, txtCenterEmail, txtCenterMaxCap, txtCenterCurrCap;
        Button deleteBtn, updateBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            centerImage=(ImageView) itemView.findViewById(R.id.viewCenterImage);
            txtCenterName=(TextView) itemView.findViewById(R.id.viewCenterName);
            txtCenterAddress=(TextView) itemView.findViewById(R.id.viewCenterAddress);
            txtCenterPIC=(TextView) itemView.findViewById(R.id.viewCenterPIC);
            txtCenterPhoneNum=(TextView) itemView.findViewById(R.id.viewCenterPhoneNum);
            txtCenterEmail=(TextView) itemView.findViewById(R.id.viewCenterEmail);
            txtCenterCurrCap=(TextView) itemView.findViewById(R.id.viewCenterCurrCap);
            deleteBtn=(Button) itemView.findViewById(R.id.deleteBtn);
            updateBtn=(Button) itemView.findViewById(R.id.updateBtn);
        }
    }
}
