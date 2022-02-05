package com.plexer0.nitter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LinkActivity extends Activity {

    private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        wv1 = (WebView) findViewById(R.id.webView);
        wv1.setWebViewClient(new MyBrowser());
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true); // <== Set JavaScript setting here.
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.canGoBack();
        wv1.loadUrl(String.valueOf(getIntent().getData())); // Leave as is to fetch URL intent.

    }

    @Override
    public void onBackPressed() {
        if(wv1!= null && wv1.canGoBack())
            wv1.goBack();
        else
            super.onBackPressed();
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            wv1.canGoBack();
            view.loadUrl(url);
            return true;
        }
    }
}