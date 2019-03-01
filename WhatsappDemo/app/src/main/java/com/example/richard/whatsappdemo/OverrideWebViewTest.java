package com.example.richard.whatsappdemo;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OverrideWebViewTest extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String request) {
        view.loadUrl(request);
        return true;
    }
}
