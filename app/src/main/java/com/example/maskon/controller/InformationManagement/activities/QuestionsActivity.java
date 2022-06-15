package com.example.maskon.controller.InformationManagement.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.maskon.R;


public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_questions);
        findViewById(R.id.back_btn).setOnClickListener(this);

    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_btn:
                startActivity( new Intent( QuestionsActivity.this, InformationMain.class ));
                finish();
                return;
            default:
                return;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity( new Intent( QuestionsActivity.this, InformationMain.class ));
        finish();
    }
}
