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
 * Created by LiYuanXiong on 2016/9/21 22:02.
 * Email:3187683623@qq.com
 */
public class HomeFragment extends Fragment {


    int index;

    /**
     * 静态工厂方法需要一个int型的值来初始化fragment的参数，
     * 然后返回新的fragment到调用者
     * @param index 初始化的参数
     * @return 新的Fragment
     */
    public static HomeFragment newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt("KEY_INDEX", index);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);//将外部传入的参数保存在自己身上
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
        textView.setText("第"+index+"页");
        return textView;
    }


}
