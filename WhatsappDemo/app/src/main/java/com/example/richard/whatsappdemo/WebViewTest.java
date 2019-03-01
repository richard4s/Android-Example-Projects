package com.example.richard.whatsappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebViewTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_test);

        EditText webTxt = (EditText) findViewById(R.id.webTxt);

        String dummyHtml = "<h1>Hello World!</h1>";

        Button mybtn = (Button) findViewById(R.id.webBtn);
        WebView webv = (WebView) findViewById(R.id.webView);
        webv.getSettings().setJavaScriptEnabled(true);

        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                webv.loadData(dummyHtml, "text/html", "utf-8");
                String myTxt = webTxt.getText().toString();
                webv.setWebViewClient(new OverrideWebViewTest());
                webv.loadUrl("https://" + myTxt);
                Toast.makeText(WebViewTest.this, "clicked", Toast.LENGTH_LONG).show();
            }
        });
    }
}
