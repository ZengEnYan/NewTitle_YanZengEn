package com.yanzengen.newtitle_yanzengen.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.yanzengen.newtitle_yanzengen.R;
import com.yanzengen.newtitle_yanzengen.bean.VideoBean;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * name:闫增恩
 * Data: 2017/2/20
 * 备注
 */

public class VideoAdapter extends BaseAdapter {

    private ArrayList<VideoBean> beenList = new ArrayList<>();
    Context context;

    public VideoAdapter(Context context) {
        this.context = context;
    }
  public void addData(ArrayList<VideoBean> beenLists, boolean isClear){

      if(beenLists!=null){
          if(isClear){
              beenList.clear();

          }beenList.addAll(beenLists);
      }

  }
    @Override
    public int getCount() {
        return beenList.size();
    }

    @Override
    public Object getItem(int position) {
        return beenList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            holder = new ViewHolder();
            convertView=View.inflate(context, R.layout.video_item,null);
            holder.playerVideo = (JCVideoPlayer) convertView.findViewById(R.id.playVideoss);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.playerVideo.setUp(beenList.get(position).getMp4_url(),JCVideoPlayer.SCREEN_LAYOUT_LIST,beenList.get(position).getTitle());
//        ImageLoader.getInstance().displayImage(beenList.get(position).getCover(),holder.playerVideo.);

        return convertView;
    }

    static class ViewHolder{

        JCVideoPlayer playerVideo;

    }

}
