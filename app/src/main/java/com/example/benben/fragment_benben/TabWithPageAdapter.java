package com.example.benben.fragment_benben;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiYuanXiong on 2016/9/21 19:35.
 * Email:3187683623@qq.com
 */
public class TabWithPageAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragments = new ArrayList<>();
    List<String> tabs = new ArrayList<>();

    public TabWithPageAdapter(FragmentManager fm,List<Fragment> fragments,List<String> list) {
        super(fm);
        this.fragments.addAll(fragments);
        this.tabs.addAll(list);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }
}
