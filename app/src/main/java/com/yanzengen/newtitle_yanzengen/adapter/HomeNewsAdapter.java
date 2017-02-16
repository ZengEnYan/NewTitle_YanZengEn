package com.yanzengen.newtitle_yanzengen.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.yanzengen.newtitle_yanzengen.bean.NewsTitleBean;

/**
 * name:闫增恩
 * Data: 2017/2/15
 * 备注
 */

public class HomeNewsAdapter extends BaseAdapter {

    Context context;
    public HomeNewsAdapter(Context context) {

        this.context = context;

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public void addData(NewsTitleBean newsTitleBean, boolean isNeedClear) {

    }
}
