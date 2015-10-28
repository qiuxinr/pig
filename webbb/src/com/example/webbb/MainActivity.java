package com.example.webbb;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		WebView wv=(WebView) findViewById(R.id.webView1);	
		wv.getSettings().setSupportZoom(true);
		wv.getSettings().setBuiltInZoomControls(true);
		wv.loadUrl("http://yd.sina.cn/media.d.html?vt=4&pos=42&media=awzuney3978837");
		wv.setWebViewClient(new WebViewClient());						
	}	
}