package com.plexer0.nitter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LinkActivity extends Activity {

    // Initialise WebView
    private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        wv1 = (WebView) findViewById(R.id.webView);
        wv1.setWebViewClient(new MyBrowser()
        {
            // Rewrite standard Twitter URLs to Nitter
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                int len = url.length();
                if(url.contains("mobile.twitter.com"))
                {
                    url = url.replace("mobile.twitter.com", "nitter.net");
                    // Toast.makeText(LinkActivity.this, "URL changed: "+url, Toast.LENGTH_LONG).show(); (Used for debugging)
                }
                // Toast.makeText(LinkActivity.this, "URL static: "+url, Toast.LENGTH_LONG).show(); (Used for debugging)
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true); // <== Set JavaScript setting here.
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.setBackgroundColor(0xF4444444);
        if (savedInstanceState == null)
        {
            wv1.loadUrl(String.valueOf(getIntent().getData())); // Leave as is to fetch URL intent.
        }
    }

    // Prevent WebView from being destroyed when the device orientation changes
    @Override
    protected void onSaveInstanceState(Bundle outState )
    {
        super.onSaveInstanceState(outState);
        wv1.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        wv1.restoreState(savedInstanceState);
    }

    // Go backwards in WebView rather than exiting the app
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
