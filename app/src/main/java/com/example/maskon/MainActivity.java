package com.example.maskon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maskon.view.QuarantineRecordView.Homepg_Quarantine;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.maskon.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button vaccinationBtn, informationBtn, quarantineBtn, dependentBtn, centerBtn;
    BottomNavigationView bottomNavigationView;
    FloatingActionButton qrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findId();
        navigation();
        centerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigate(AdminViewCenterList.class);
            }
        });
    }

    private void findId(){
        vaccinationBtn=findViewById(R.id.vaccinationBtn);
        informationBtn=findViewById(R.id.informationBtn);
        quarantineBtn=findViewById(R.id.quarantineBtn);
        dependentBtn=findViewById(R.id.dependentBtn);
        centerBtn=findViewById(R.id.quarantineCenterBtn);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        qrCode=findViewById(R.id.qrCode);
    }

    private void navigation(){
        //navigation for bottom app bar
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.quarantine:
                        Toast.makeText(MainActivity.this, "quarantine", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.notification:
                        Toast.makeText(MainActivity.this, "notification", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.profile:
                        Intent intent = new Intent(MainActivity.this, AdminViewCenterList.class);
                        startActivity(intent);
                        return true;
                }
                return true;
            }
        });

        //navigation for qrCode
        qrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Homepg_Quarantine.class);
                startActivity(intent);
            }
        });
    }

    private void navigate(Class destination){
        Intent intent = new Intent(this, destination);
        startActivity(intent);
    }

}