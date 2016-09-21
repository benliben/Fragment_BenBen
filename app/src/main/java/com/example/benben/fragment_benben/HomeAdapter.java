package com.example.benben.fragment_benben;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiYuanXiong on 2016/9/21 21:57.
 * Email:3187683623@qq.com
 */
public class HomeAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList = new ArrayList<>();
    List<String> tabList = new ArrayList<>();


    public HomeAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> tabList) {

        super(fm);
        this.fragmentList.addAll(fragmentList);
        this.tabList.addAll(tabList);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position);
    }
}
