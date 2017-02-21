package com.yanzengen.newtitle_yanzengen.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yanzengen.newtitle_yanzengen.R;
import com.yanzengen.newtitle_yanzengen.activity.SystemSeting;

public class NoLoginFragment extends Fragment implements View.OnClickListener{

    private View view;
    private RelativeLayout relativeLayout;
    private LinearLayout ll_night;
    private TextView night_name;
    private ImageView night_;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = View.inflate(getActivity(), R.layout.fragment_no_login,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化view
        initView();
        initData();
    }

    private void initView() {

        //夜间模式里的ID
        night_name = (TextView) view.findViewById(R.id.night_name);
        night_ = (ImageView) view.findViewById(R.id.night_);
        ll_night = (LinearLayout) view.findViewById(R.id.ll_night);

        relativeLayout = (RelativeLayout) view.findViewById(R.id.systemSet);
        relativeLayout.setOnClickListener(this);
        ll_night.setOnClickListener(this);
    }

    private void initData() {
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.systemSet:
                Intent intent = new Intent(getActivity(), SystemSeting.class);
                startActivity(intent);

            case R.id.ll_night:
                night_.setImageResource(R.drawable.dayicon_profile);
                night_name.setText("日间");

        }

    }
}
