package com.example.benben.fragment_benben;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by LiYuanXiong on 2016/9/22 23:21.
 * Email:3187683623@qq.com
 */
public class ScatterChartFragment extends Fragment {
    private View rootView;
    private ScatterChart chart;
    private ScatterData data;
    private ScatterDataSet dataSet;
    private ArrayList<String> xVals = new ArrayList<>();
    private ArrayList<Entry> yVals=new ArrayList<>();
    private Random random=new Random();

    public static ScatterChartFragment newInstance(int index) {
        ScatterChartFragment fragment = new ScatterChartFragment();
        Bundle args = new Bundle();
        args.putInt("KEY_INDEX", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_chart_scatter, container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chart = (ScatterChart) getActivity().findViewById(R.id.chart_scatter);
        for (int i = 0; i < 12; i++) {
            float profit = random.nextFloat()*1000;
            xVals.add((i + 1) + "月");
            yVals.add(new Entry(profit, i));
        }

        dataSet = new ScatterDataSet(yVals, "公司年利润");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data = new ScatterData(xVals, dataSet);
        chart.setData(data);
        chart.setDescription("公司年利润");
        chart.animateY(3000);

    }
}
