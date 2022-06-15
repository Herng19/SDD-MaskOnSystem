package com.example.maskon.controller.InformationManagement.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.maskon.R;
import com.example.maskon.controller.InformationManagement.adapters.TabPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class InformationMain extends AppCompatActivity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_information_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("Things to know"));
        tabLayout.addTab(tabLayout.newTab().setText("Things to do"));

        ViewPager viewPager = findViewById(R.id.pager);

        PagerAdapter adapter = new TabPagerAdapter( getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == 1) {
                    startActivity( new Intent( InformationMain.this, QuestionsActivity.class ));
                    //startActivity( new Intent( MainActivity.this, QuestionsActivityRecycler.class ));
                    finish();
                }
                else{
                    viewPager.setCurrentItem(tab.getPosition());
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        NestedScrollView nestedScrollView = findViewById(R.id.scroll_view);
        nestedScrollView.scrollTo(0,0);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.wanna_exit);
        builder.setPositiveButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(R.string.confirm, (dialogInterface, i) -> System.exit(0));
        builder.show();
    }


}
