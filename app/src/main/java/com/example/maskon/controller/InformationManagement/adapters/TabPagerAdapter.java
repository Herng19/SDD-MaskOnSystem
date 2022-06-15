package com.example.maskon.controller.InformationManagement.adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.maskon.controller.InformationManagement.fragments.EmptyFragment;
import com.example.maskon.controller.InformationManagement.fragments.WebFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public TabPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                WebFragment tab1 = new WebFragment();
                return tab1;
            case 1:
                EmptyFragment tab2 = new EmptyFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}