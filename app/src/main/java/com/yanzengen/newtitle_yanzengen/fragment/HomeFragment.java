package com.yanzengen.newtitle_yanzengen.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanzengen.newtitle_yanzengen.R;
import com.yanzengen.newtitle_yanzengen.adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private String[] title = {"推荐", "热点", "阳光宽带", "北京", "社会", "娱乐", "问答", "图片", "科技", "汽车", "体育", "财经", "军事", "国际", "段子", "趣图", "美女", "健康", "正能量", "特卖", "房产"};
    private List<Fragment> list;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = View.inflate(getActivity(), R.layout.fragment_home, null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout_title);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        initData();
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getActivity().getSupportFragmentManager(),getActivity(),title,list);

        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


    }

    //初始化数据
    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            TitleFragment fragment = new TitleFragment();
            list.add(fragment);
        }
    }
}
