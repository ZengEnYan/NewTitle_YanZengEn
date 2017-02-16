package com.yanzengen.newtitle_yanzengen.application;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * name:闫增恩
 * Data: 2017/2/15
 * 备注
 */

public class XutilsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(480,480)
                .threadPriority(4)//设置线程优先级
                .threadPoolSize(2)//设置线程池大小
                .memoryCacheSize(2*1024*1024)//设置内存缓存区大小
                .diskCacheSize(20*1024*1024)//设置磁盘缓存区大小

                .build();
        ImageLoader.getInstance().init(configuration);

    }
}
