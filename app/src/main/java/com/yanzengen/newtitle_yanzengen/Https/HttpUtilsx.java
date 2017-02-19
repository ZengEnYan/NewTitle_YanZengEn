package com.yanzengen.newtitle_yanzengen.Https;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * name:闫增恩
 * Data: 2017/2/17
 * 备注
 */

public class HttpUtilsx {

    public static void LoadData(String url,CallBackData callbackdata){
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

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

    public interface CallBackData<T>{
        void success(T t) ;
    }
}
