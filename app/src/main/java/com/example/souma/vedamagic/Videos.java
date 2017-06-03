package com.example.souma.vedamagic;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Network;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.net.URL;

public class Videos extends AppCompatActivity {

    WebView vi;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        vi=(WebView)findViewById(R.id.web);
        vi.setHorizontalScrollBarEnabled(true);
        vi.setVerticalScrollBarEnabled(true);
        WebSettings w=vi.getSettings();
        w.setJavaScriptEnabled(true);
        w.setUseWideViewPort(true);
        w.setLoadWithOverviewMode(true);
        // w.setSupportZoom(true);
        // w.setBuiltInZoomControls(true);
        // w.setDisplayZoomControls(false);
        vi.setWebViewClient(new WebViewClient());
        vi.loadUrl("https://www.youtube.com/playlist?list=PLhuF3CfgKa3asaOMJQ_vO6rX6SBbjaqJm");
    }


}
