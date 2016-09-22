package com.example.benben.fragment_benben;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by LiYuanXiong on 2016/9/22 22:23.
 * Email:3187683623@qq.com
 */
public class LineChartFragment extends Fragment {

    private LineChart chart;
    private LineData data;
    private ArrayList<String> xVals;
    private LineDataSet dataSet;
    private ArrayList<Entry> yVals;
    private Random random;
    private View rootView;


    public static LineChartFragment newInstance(int index) {
        LineChartFragment fragment = new LineChartFragment();
        Bundle args = new Bundle();
        args.putInt("KEY_INDEX", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {

            rootView = inflater.inflate( R.layout.fragment_line_chart, container, false);
        }
        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chart = (LineChart) getActivity().findViewById(R.id.chart);
        xVals = new ArrayList<>();
        yVals = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < 12; i++) {
            float profix = random.nextFloat();
            yVals.add(new Entry(profix, i));
            xVals.add((i + 1) + "月");
        }

        dataSet = new LineDataSet(yVals, "公司年度利润");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data = new LineData(xVals, dataSet);
        chart.setData(data);
        chart.setDescription("公司年度利润");
        chart.animateY(3000);

    }
}
