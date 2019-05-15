package com.example.bloodbankapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web, container, false);

        WebView webView = view.findViewById(R.id.webview);
        //  webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

       // webView.loadUrl();

        return view;
    }


}
