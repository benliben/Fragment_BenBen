package com.example.benben.fragment_benben;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by LiYuanXiong on 2016/9/22 23:18.
 * Email:3187683623@qq.com
 */
public class HorizontalChartFragment extends Fragment {

    private HorizontalBarChart chart;
    private BarData data;
    private ArrayList<String> xVals = new ArrayList<>();
    private List<BarEntry> yVals = new ArrayList<>();
    private BarDataSet dataSet;
    private View rootView;

    public static HorizontalChartFragment newInstance(int index) {
        HorizontalChartFragment fragment = new HorizontalChartFragment();
        Bundle args = new Bundle();
        args.putInt("KEY_INDEX", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_chart_horizontal_bar, container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chart = (HorizontalBarChart) getActivity().findViewById(R.id.chart_horizontal_bar);

        for (int i = 0; i < 12; i++) {
            float profit = new Random().nextFloat();
            yVals.add(new BarEntry(profit, i));
            xVals.add((i +1) + "月");
        }

        dataSet = new BarDataSet(yVals, "年利润");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data = new BarData(xVals, dataSet);
        chart.setData(data);
        chart.setDescription("年利润");
    }
}
