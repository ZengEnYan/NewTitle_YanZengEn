package com.yanzengen.newtitle_yanzengen.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/2/11.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    Context context;
    String[] title;
    List<Fragment> list;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context, String[] title, List<Fragment> list) {
        super(fm);
        this.context = context;
        this.title = title;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
