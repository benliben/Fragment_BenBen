package com.example.benben.fragment_benben;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by LiYuanXiong on 2016/9/21 21:53.
 * Email:3187683623@qq.com
 */
public class HomeActivity extends AppCompatActivity {
    @InjectView(R.id.tab_layout)
    TabLayout mTabLayout;
    @InjectView(R.id.view_pager)
    ViewPager mViewPager;


    List<Fragment> fragmentList = new ArrayList<>();
    List<String> listTab = new ArrayList<>();

    HomeAdapter mHomeAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);


        initFragmentData();

        mHomeAdapter = new HomeAdapter(getSupportFragmentManager(), fragmentList, listTab);

        mViewPager.setAdapter(mHomeAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void initFragmentData() {
        listTab.add("线性图标");
        fragmentList.add(LineChartFragment.newInstance(1));

        listTab.add("柱形图");
        fragmentList.add(BarChartFragment.newInstance(2));

        listTab.add("水平柱形图");
        fragmentList.add(HorizontalChartFragment.newInstance(3));

        listTab.add("混合图");
        fragmentList.add(CombinedChartFragment.newInstance(4));

        listTab.add("饼图");
        fragmentList.add(PieChartFragment.newInstance(5));

        listTab.add("散列图");
        fragmentList.add(ScatterChartFragment.newInstance(6));

        listTab.add("蜡烛图");
        fragmentList.add(CandleStickChartFragment.newInstance(7));

        listTab.add("雷大海图");
        fragmentList.add(RadarChartFragment.newInstance(8));


    }
}
