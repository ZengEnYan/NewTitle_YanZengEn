package com.yanzengen.newtitle_yanzengen.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yanzengen.newtitle_yanzengen.R;
import com.yanzengen.newtitle_yanzengen.activity.HomeActivity;
import com.yanzengen.newtitle_yanzengen.activity.SystemSeting;

public class NoLoginFragment extends Fragment implements View.OnClickListener{

    private View view;
    private RelativeLayout relativeLayout;
    private LinearLayout ll_night;
    private TextView night_name;
    private ImageView night_;
    private boolean mode;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = View.inflate(getActivity(), R.layout.fragment_no_login,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sp = getActivity().getSharedPreferences("flaging", Context.MODE_PRIVATE);

        edit = sp.edit();

        edit.putBoolean("mode",true);

        //初始化view
        initView();
        initData();
    }

    private void initView() {

        //夜间模式里的ID
        night_name = (TextView) view.findViewById(R.id.night_name);
        night_ = (ImageView) view.findViewById(R.id.night_);
        ll_night = (LinearLayout) view.findViewById(R.id.ll_night);

        mode = sp.getBoolean("mode",true);
        if(mode==true){
            night_.setImageResource(R.drawable.nighticon_profile);
            night_name.setText("夜间");
        }else {
            night_.setImageResource(R.drawable.dayicon_profile);
            night_name.setText("日间");
        }
        relativeLayout = (RelativeLayout) view.findViewById(R.id.systemSet);
        relativeLayout.setOnClickListener(this);
        ll_night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mode==true){
                    edit.putBoolean("mode",false).commit();
                }else {
                    edit.putBoolean("mode",true).commit();
                }

                int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                ((HomeActivity)getActivity()).getDelegate().setLocalNightMode(currentNightMode ==Configuration.UI_MODE_NIGHT_NO? AppCompatDelegate.MODE_NIGHT_YES :
                        AppCompatDelegate.MODE_NIGHT_NO);
                // 同样需要调用recreate方法使之生效
                getActivity().recreate();

            }
        });
    }

    private void initData() {
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.systemSet:
                Intent intent = new Intent(getActivity(), SystemSeting.class);
                startActivity(intent);
                break;
        }

    }
}
