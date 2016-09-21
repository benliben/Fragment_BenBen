package com.example.benben.fragment_benben;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends FragmentActivity {


    @InjectView(R.id.tb_layout)
    TabLayout tbLayout;
    @InjectView(R.id.id_page_vp)
    ViewPager idPageVp;

    TabWithPageAdapter mPageAdapter;

    List<Fragment> fragmentList = new ArrayList<>();
    List<String> tabs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


        initFragmentData();

        mPageAdapter = new TabWithPageAdapter(getSupportFragmentManager() ,fragmentList, tabs);

        idPageVp.setAdapter(mPageAdapter);
        tbLayout.setupWithViewPager(idPageVp);
        tbLayout.setupWithViewPager(idPageVp);
    }

    private void initFragmentData() {
        for (int i = 0; i < 15; i++) {
            fragmentList.add(MyFragment.newInstance(i));
            tabs.add("tab"+i);
        }
    }


}
