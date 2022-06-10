package com.example.maskon.controller.QuarantineCenterManagement;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maskon.R;
import com.example.maskon.model.CenterRecord.CenterRecord;

import java.util.ArrayList;

//class to display card in recycler view
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    int singleData;
    ArrayList<CenterRecord>centerRecordArrayList;
    SQLiteDatabase sqLiteDatabase;
    boolean isUser;

    //constructor for adapter class
    public MyAdapter(Context context, int singleData, ArrayList<CenterRecord> centerRecordArrayList, SQLiteDatabase sqLiteDatabase, boolean isUser) {
        this.context = context;
        this.singleData = singleData;
        this.centerRecordArrayList = centerRecordArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
        this.isUser=isUser;
    }

    //function to let each card view to display in recycler view
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.card_view, parent, false);
        return new ViewHolder(view);
    }

    //function to set data to each card according to data entered
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        final CenterRecord centerRecord= centerRecordArrayList.get(position);
        byte[]image=centerRecord.getCenter_Image();
        Bitmap bitmap= BitmapFactory.decodeByteArray(image, 0, image.length);

        holder.centerImage.setImageBitmap(bitmap);
        holder.txtCenterName.setText(centerRecord.getCenter_Name());
        holder.txtCenterAddress.setText("Adress: "+centerRecord.getCenter_Address());
        holder.txtCenterPIC.setText("PIC: "+centerRecord.getCenter_PIC());
        holder.txtCenterPhoneNum.setText("Contact: "+centerRecord.getCenter_PhoneNum());
        holder.txtCenterEmail.setText("Email: "+centerRecord.getCenter_Email());
        holder.txtCenterCurrCap.setText("Capacity: "+String.valueOf(centerRecord.getCurr_Cap())+"/"+String.valueOf(centerRecord.getMax_Cap()));

        if(isUser){
            holder.updateBtn.setVisibility(View.GONE);
            holder.deleteBtn.setVisibility(View.GONE);
        }else {
            //set onclick function for delete button in each card view
            holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alertBox = new AlertDialog.Builder(context);
                    alertBox.setCancelable(true);
                    alertBox.setTitle("Delete Center");
                    alertBox.setMessage("Confirm to delete this center ?");

                    alertBox.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    alertBox.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            centerRecord.setContext(context);
                            centerRecord.deleteCenter(centerRecord.getCenter_ID());
                            centerRecordArrayList.remove(holder.getAdapterPosition());
                            notifyDataSetChanged();
                        }
                    });
                    alertBox.show();
                        //Toast.makeText(context, "Center Not Deleted, ", Toast.LENGTH_SHORT).show();
                }
            });

            //set onclick function for update button in each card view
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
    }

    //function to get total number of center to display
    @Override
    public int getItemCount() {
        return centerRecordArrayList.size();
    }

    //find each text view and assign to variable
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
