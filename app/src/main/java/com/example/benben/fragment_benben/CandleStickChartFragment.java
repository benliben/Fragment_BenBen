package com.example.benben.fragment_benben;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by LiYuanXiong on 2016/9/22 23:21.
 * Email:3187683623@qq.com
 */
public class CandleStickChartFragment extends Fragment {
    private View rootView;
    private final ArrayList<String> xVals = new ArrayList<>();
    private final ArrayList<CandleEntry> yVals=new ArrayList<>();
    private final Random random=new Random();

    public static CandleStickChartFragment newInstance(int index) {
        CandleStickChartFragment fragment = new CandleStickChartFragment();
        Bundle args = new Bundle();
        args.putInt("KEY_INDEX", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_chart_candle_stick, container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CandleStickChart chart = (CandleStickChart) getActivity().findViewById(R.id.chart_candle_stick);
        for (int i = 0; i < 12; i++) {
            float profit = random.nextFloat();
            xVals.add((i + 1) + "月");
            yVals.add(new CandleEntry(i, 2f, 1.5f, 1.0f, profit));
        }
        CandleDataSet dataSet = new CandleDataSet(yVals, "公司年利润");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        CandleData data = new CandleData(xVals, dataSet);
        chart.setData(data);
        chart.setDescription("公司年利润");
        chart.animateY(5000);

    }
}
