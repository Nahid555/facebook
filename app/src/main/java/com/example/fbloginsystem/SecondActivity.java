package com.example.fbloginsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_second);
        webView=findViewById(R.id.webViewId);
        webView.loadUrl("https://m.facebook.com/");
       webView.setWebViewClient(new WebViewClient());

    }
    @Override
    protected void onStart() {
        super.onStart();
        Shared shared=new Shared(getApplicationContext());
        shared.firstTime();
    }
}
