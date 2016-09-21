package com.example.benben.fragment_benben;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by LiYuanXiong on 2016/9/21 19:41.
 * Email:3187683623@qq.com
 */
public class MyFragment extends Fragment {

    int index;

    public static MyFragment newInstance(int index) {

        Bundle args = new Bundle();
        args.putInt("KEY_INDEX",index);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        index = getArguments().getInt("KEY_INDEX");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(container.getContext());
        textView.setText(index+"页Fragemnt");
        return textView;
    }


}
