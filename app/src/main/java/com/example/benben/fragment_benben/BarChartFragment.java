package com.example.benben.fragment_benben;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by LiYuanXiong on 2016/9/22 23:16.
 * Email:3187683623@qq.com
 */
public class BarChartFragment extends Fragment {

    private Random random=new Random();//产生随机数
    private BarChart chart;
    private BarData data;
    private BarDataSet dataSet;
    private View rootView;

    ArrayList<BarEntry> entries = new ArrayList<>();//显示条码
    ArrayList<String> xVals = new ArrayList<>();//横坐标标签

    public static BarChartFragment newInstance(int index) {
        BarChartFragment fragment = new BarChartFragment();
        Bundle args = new Bundle();
        args.putInt("KEY_INDEX", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_chart_bar,container,false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chart = (BarChart) getActivity().findViewById(R.id.chart_bar);
        for (int i = 0; i < 12; i++) {
            float profit = random.nextFloat() * 1000;
            entries.add(new BarEntry(profit, i));
            xVals.add((i + 1) + "月");
        }

        dataSet = new BarDataSet(entries, "公司年利润报表");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data = new BarData(xVals, dataSet);
        chart.setData(data);
        chart.animateY(3000);
        chart.setDescription("公司前半年财务报表（单位：万元）");
    }
}
