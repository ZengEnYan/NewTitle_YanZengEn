package com.yanzengen.newtitle_yanzengen.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yanzengen.newtitle_yanzengen.R;
import com.yanzengen.newtitle_yanzengen.adapter.VideoAdapter;
import com.yanzengen.newtitle_yanzengen.bean.VideoBean;
import com.yanzengen.newtitle_yanzengen.http.CallbackNewsData;
import com.yanzengen.newtitle_yanzengen.http.HttpUtils;

import java.util.ArrayList;

public class VideoTitleFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2,CallbackNewsData<VideoBean>{

    private View view;
    private PullToRefreshListView pullListViewVideo;
    private String type;
    private int pageSize = 10;
    private String url;
    private boolean isClear = false;
    private VideoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = View.inflate(getActivity(), R.layout.fragment_video_title,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle arguments = getArguments();

        if(arguments!=null){
            type = arguments.getString("type");
        }
        url = "http://c.3g.163.com/nc/video/list/"+type+"/n/"+pageSize+"-10.html";
        initView();
        initData();

    }

    private void initView() {
        pullListViewVideo = (PullToRefreshListView) view.findViewById(R.id.pullListViewVideo);
        pullListViewVideo.setMode(PullToRefreshBase.Mode.BOTH);
        pullListViewVideo.setOnRefreshListener(this);

    }

    private void initData() {

        adapter = new VideoAdapter(getActivity());
        pullListViewVideo.setAdapter(adapter);
        HttpUtils.loadDataFromServer(url, VideoBean.class,this);

    }

    //刷新方法
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {

        pageSize=10;
        isClear=true;
        HttpUtils.loadDataFromServer(url, VideoBean.class,this);
    }

    //加载方法
    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        pageSize=10;
        isClear=false;
        HttpUtils.loadDataFromServer(url, VideoBean.class,this);
    }

    @Override
    public void success(ArrayList videoBeans) {
        adapter.addData(videoBeans,isClear);
        adapter.notifyDataSetChanged();
        pullListViewVideo.onRefreshComplete();
    }
}
