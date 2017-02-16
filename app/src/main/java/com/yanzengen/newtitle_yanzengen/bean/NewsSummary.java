package com.yanzengen.newtitle_yanzengen.bean;

import java.util.List;

/**
 * name:闫增恩
 * Data: 2017/2/15
 * 备注
 */

public class NewsSummary {

    public String postid;
    public boolean hasCover;
    public int hasHead;
    public int replyCount;
    public int hasImg;
    public String digest;
    public boolean hasIcon;
    public String docid;
    public String title;
    public int order;
    public int priority;
    public String lmodify;
    public String boardid;
    public String photosetID;
    public int imgsum;
    public String topic_background;
    public String template;
    public int votecount;
    public String skipID;
    public String alias;
    public String skipType;
    public String cid;
    public int hasAD;
    public String source;
    public String ename;
    public String tname;
    public String imgsrc;
    public String ptime;
    public List<AdsBean> ads;
    public List<ImgextraBean> imgextra;
    public String url_3w;

    @Override
    public String toString() {
        return "NewsSummary{" +
                "ads=" + ads +
                ", postid='" + postid + '\'' +
                ", hasCover=" + hasCover +
                ", hasHead=" + hasHead +
                ", replyCount=" + replyCount +
                ", hasImg=" + hasImg +
                ", digest='" + digest + '\'' +
                ", hasIcon=" + hasIcon +
                ", docid='" + docid + '\'' +
                ", title='" + title + '\'' +
                ", order=" + order +
                ", priority=" + priority +
                ", lmodify='" + lmodify + '\'' +
                ", boardid='" + boardid + '\'' +
                ", photosetID='" + photosetID + '\'' +
                ", imgsum=" + imgsum +
                ", topic_background='" + topic_background + '\'' +
                ", template='" + template + '\'' +
                ", votecount=" + votecount +
                ", skipID='" + skipID + '\'' +
                ", alias='" + alias + '\'' +
                ", skipType='" + skipType + '\'' +
                ", cid='" + cid + '\'' +
                ", hasAD=" + hasAD +
                ", source='" + source + '\'' +
                ", ename='" + ename + '\'' +
                ", tname='" + tname + '\'' +
                ", imgsrc='" + imgsrc + '\'' +
                ", ptime='" + ptime + '\'' +
                ", imgextra=" + imgextra + ", url_3w=" + url_3w +
                '}';
    }

    public static class AdsBean {
        public String title;
        public String tag;
        public String imgsrc;
        public String subtitle;
        public String url;

        @Override
        public String toString() {
            return "AdsBean{" +
                    "imgsrc='" + imgsrc + '\'' +
                    ", title='" + title + '\'' +
                    ", tag='" + tag + '\'' +
                    ", subtitle='" + subtitle + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public static class ImgextraBean {
        public String imgsrc;

        @Override
        public String toString() {
            return "ImgextraBean{" +
                    "imgsrc='" + imgsrc + '\'' +
                    '}';
        }
    }
}
