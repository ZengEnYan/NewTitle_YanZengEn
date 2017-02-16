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
import com.yanzengen.newtitle_yanzengen.adapter.VideoFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends Fragment {

    private View view;
    private TabLayout tableLayout_video;
    private ViewPager viewPager_video;
    private String[] title = {"推荐", "热点", "阳光宽带",  "社会", "娱乐", "科技", "汽车", "体育", "财经", "军事", "旅游", "CBA", "笑话", "正能量","电影"};
    private List<Fragment> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = View.inflate(getActivity(), R.layout.fragment_video,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initData();
        VideoFragmentPagerAdapter pagerAdapter = new VideoFragmentPagerAdapter(getActivity().getSupportFragmentManager(),getActivity(),list,title);

        viewPager_video.setAdapter(pagerAdapter);

        tableLayout_video.setupWithViewPager(viewPager_video);

        tableLayout_video.setTabMode(TabLayout.MODE_SCROLLABLE);


    }

    private void initView() {

        tableLayout_video = (TabLayout) view.findViewById(R.id.tabLayout_video);

        viewPager_video = (ViewPager) view.findViewById(R.id.viewPager_video);

    }

    private void initData() {

        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            VideoTitleFragment fragment = new VideoTitleFragment();

            //fragment利用Bundle传值
            Bundle bundle = new Bundle();
            bundle.putString("type",title[i]);
            fragment.setArguments(bundle);

            list.add(fragment);
        }

    }
}
