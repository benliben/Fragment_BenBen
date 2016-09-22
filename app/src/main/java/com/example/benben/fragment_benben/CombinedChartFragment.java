package com.example.benben.fragment_benben;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CombinedData;

import java.util.ArrayList;

/**
 * Created by LiYuanXiong on 2016/9/22 23:19.
 * Email:3187683623@qq.com
 */
public class CombinedChartFragment extends Fragment {
    private View rootView;
    private CombinedChart chart;
    private CombinedData data;
    private ArrayList<String> xVals=new ArrayList<>();

    public static CombinedChartFragment newInstance(int index) {
        CombinedChartFragment fragment = new CombinedChartFragment();
        Bundle args = new Bundle();
        args.putInt("KEY_INDEX", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_chart_combined, container, false);

        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chart = (CombinedChart) getActivity().findViewById(R.id.chart_combined);
        for (int i = 0; i < 12; i++) {
            xVals.add(i, "Hello");
        }

        data = new CombinedData(xVals);
        chart.setData(data);
    }
}
