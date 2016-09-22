package com.example.benben.fragment_benben;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by LiYuanXiong on 2016/9/22 23:22.
 * Email:3187683623@qq.com
 */
public class RadarChartFragment extends Fragment {

    private RadarChart chart;
    private RadarData data;
    private ArrayList<String> xVals = new ArrayList<>();
    private RadarDataSet dataSet;
    private ArrayList<Entry> yVals = new ArrayList<>();
    private Random random = new Random();
    private View rootView;

    public static RadarChartFragment newInstance(int index) {
        RadarChartFragment fragment = new RadarChartFragment();
        Bundle args = new Bundle();
        args.putInt("KEY_INDEX", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_chart_radar, container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chart = (RadarChart) getActivity().findViewById(R.id.chart_radar);
        for (int i = 0; i < 12; i++) {
            float profit = random.nextFloat();
            xVals.add((i + 1) + "月");
            yVals.add(new Entry(profit, i));
        }

        dataSet = new RadarDataSet(yVals, "公司年利润");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data = new RadarData(xVals, dataSet);
        chart.setData(data);
        chart.setDescription("公司年利润");
        chart.animateY(3000);
    }
}
