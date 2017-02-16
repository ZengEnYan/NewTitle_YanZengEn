package com.yanzengen.newtitle_yanzengen.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yanzengen.newtitle_yanzengen.R;
import com.yanzengen.newtitle_yanzengen.adapter.HomeNewsAdapter;
import com.yanzengen.newtitle_yanzengen.bean.NewsTitleBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2017/2/11.
 */

public class TitleFragment extends Fragment implements PullToRefreshListView.OnRefreshListener2{

    private View view;
    private String type;
    private int currentPager=20;
    private NewsTitleBean newsTitleBean;
    private PullToRefreshListView pullListView;
    private HomeNewsAdapter homeNewsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_title,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle arguments = getArguments();
        if(arguments!=null){
            type = arguments.getString("type");
        }

        //初始化view
        initView();
        //初始化数据
        initData();

        londDataFromServer(false);

    }

    private void initView() {

        pullListView = (PullToRefreshListView) view.findViewById(R.id.pullListView);
        pullListView.setMode(PullToRefreshBase.Mode.BOTH);

    }

    private void initData() {

        homeNewsAdapter = new HomeNewsAdapter(getActivity());

    }
    private void londDataFromServer(final boolean isNeedClear) {

        String path = "http://c.m.163.com/nc/article/headline/"+type+"/0-"+currentPager+".html";

        x.http().get(new RequestParams(path), new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();

                newsTitleBean = gson.fromJson(result, NewsTitleBean.class);

                homeNewsAdapter.addData(newsTitleBean,isNeedClear);

                homeNewsAdapter.notifyDataSetChanged();

                pullListView.onRefreshComplete();

                //http://c.m.163.com/nc/article/headline/T1348647909107/0-40.html
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
    // 下拉刷新的方法
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {

        currentPager=20;

        londDataFromServer(true);

    }
    //上拉加载的方法
    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        currentPager+=20;

        londDataFromServer(false);

    }
}
