package com.example.benben.fragment_benben;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by LiYuanXiong on 2016/9/22 23:20.
 * Email:3187683623@qq.com
 */
public class PieChartFragment extends Fragment {

    private PieChart chart;
    private PieData data;
    private ArrayList<String> xVals=new ArrayList<>();
    private ArrayList<Entry>  yVals=new ArrayList<>();
    private PieDataSet dataSet;
    private Random random = new Random();
    private View rootView;

    public static PieChartFragment newInstance(int index) {
        PieChartFragment fragment = new PieChartFragment();
        Bundle args = new Bundle();
        args.putInt("KEY_INDEX", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_chart_pie, container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chart = (PieChart) getActivity().findViewById(R.id.chart_pie);
        for (int i = 0; i < 6; i++) {
            float profit = random.nextFloat()*1000;
            yVals.add(new Entry(profit, i));
            xVals.add((i + 1) + "月");
        }
        dataSet = new PieDataSet(yVals, "公司年利润");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data = new PieData(xVals, dataSet);
        chart.setData(data);
        chart.setDescription("公司年利润");
        chart.animateY(3000);
    }
}
