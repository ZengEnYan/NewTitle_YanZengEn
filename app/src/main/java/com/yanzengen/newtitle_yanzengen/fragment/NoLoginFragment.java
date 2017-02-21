package com.yanzengen.newtitle_yanzengen.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.yanzengen.newtitle_yanzengen.R;
import com.yanzengen.newtitle_yanzengen.activity.SystemSeting;

public class NoLoginFragment extends Fragment implements View.OnClickListener{

    private View view;
    private RelativeLayout relativeLayout;

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
        relativeLayout = (RelativeLayout) view.findViewById(R.id.systemSet);
        relativeLayout.setOnClickListener(this);
    }

    private void initData() {
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.systemSet:
                Intent intent = new Intent(getActivity(), SystemSeting.class);
                startActivity(intent);
        }

    }
}
