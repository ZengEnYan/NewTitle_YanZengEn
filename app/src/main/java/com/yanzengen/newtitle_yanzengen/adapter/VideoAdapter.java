package com.yanzengen.newtitle_yanzengen.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.yanzengen.newtitle_yanzengen.R;
import com.yanzengen.newtitle_yanzengen.bean.VideoBean;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * name:闫增恩
 * Data: 2017/2/20
 * 备注
 */

public class VideoAdapter extends BaseAdapter {

    private ArrayList<VideoBean> beenList = new ArrayList<>();
    Context context;
    private DisplayImageOptions options;

    public VideoAdapter(Context context) {
        this.context = context;

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisk(true)
                .showImageOnLoading(R.drawable.weixin_allshare_normal)
                .showImageForEmptyUri(R.drawable.weixin_allshare_normal)// 请求的资源不存在时显示的图片
                .showImageOnFail(R.drawable.weixin_allshare_normal)// 加载出错时显示的图片

                .bitmapConfig(Bitmap.Config.RGB_565)// 比默认的速度快效率高
		.displayer(new RoundedBitmapDisplayer(500))// 给图片设置圆角 int值 表示圆角的半径大小 值越大 越圆
                .build();

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
            holder.playerVideo = (JCVideoPlayerStandard) convertView.findViewById(R.id.playVideoss);
            holder.topicName = (TextView) convertView.findViewById(R.id.topicName);
            holder.topicImg = (ImageView) convertView.findViewById(R.id.topicImg);
            holder.ping = (TextView) convertView.findViewById(R.id.ping);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.playerVideo.setUp(beenList.get(position).getMp4_url(),JCVideoPlayer.SCREEN_LAYOUT_LIST,beenList.get(position).getTitle());
        ImageLoader.getInstance().displayImage(beenList.get(position).getCover(),holder.playerVideo.thumbImageView);

        holder.topicName.setText(beenList.get(position).getTopicName());
        ImageLoader.getInstance().displayImage(beenList.get(position).getTopicImg(),holder.topicImg,options);

        holder.ping.setText(beenList.get(position).getLength()+"");

        return convertView;
    }

    static class ViewHolder{

        JCVideoPlayerStandard playerVideo;
        ImageView topicImg;
        TextView topicName;
        TextView ping;

    }

}
