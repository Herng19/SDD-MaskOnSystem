package com.example.maskon.controller.InformationManagement.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maskon.R;
import com.example.maskon.controller.InformationManagement.adapters.RecyclerAdapter;


public class QuestionsActivityRecycler extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_questions_recycler);
        findViewById(R.id.back_btn).setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_btn:
                startActivity( new Intent( QuestionsActivityRecycler.this, InformationMain.class ));
                finish();
                return;
            default:
                return;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity( new Intent( QuestionsActivityRecycler.this, InformationMain.class ));
        finish();
    }
}
