package com.yanzengen.newtitle_yanzengen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * name:闫增恩
 * Data: 2017/2/17
 * 备注
 */

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_webview);

        WebView wv = (WebView) findViewById(R.id.wView);

        Intent intent = getIntent();

        String viewUrl = intent.getStringExtra("webViewUrl");

        WebSettings ws = wv.getSettings();

        ws.setJavaScriptCanOpenWindowsAutomatically(true);
        ws.setJavaScriptEnabled(true);

        wv.setWebViewClient(new WebViewClient());

        wv.loadUrl(viewUrl);


        if (viewUrl != null) {
            wv.loadUrl(viewUrl);
        } else {
            Toast.makeText(this, "网页加载错误", Toast.LENGTH_LONG).show();
        }

    }
}
