package com.example.luxchat.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.luxchat.Fragment.FragmentAboutMe;
import com.example.luxchat.Fragment.FragmentGroup;
import com.example.luxchat.Fragment.FragmentOne;

public class TabLayoutAdaprer extends FragmentStatePagerAdapter {
    private String listTittle[] = {"Messenger","Group Chat","About you"};
    private FragmentOne fragmentOne;
    private FragmentAboutMe fragmentAboutMe;
    private FragmentGroup fragmentGroup;
    public TabLayoutAdaprer(FragmentManager fm) {

        super(fm);
        fragmentOne = new FragmentOne();
        fragmentGroup = new FragmentGroup();
        fragmentAboutMe = new FragmentAboutMe();
    }

    @Override
    public Fragment getItem(int i) {
        if(i  == 0){
            return fragmentOne;
        }
        else if (i == 1){
            return  fragmentGroup;
        }
        else if(i == 2){
            return fragmentAboutMe;
        }
        else {}
        return null;
    }

    @Override
    public int getCount() {
        return listTittle.length;
    }



}
