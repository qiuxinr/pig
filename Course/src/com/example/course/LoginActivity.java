package com.example.course;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {
	 private Button buttontest;
	private WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seach);
		//buttontest=(Button)findViewById(R.id.rc_search_btn);
		 webView = (WebView) findViewById(R.id.word_web_view);
	     
		
	     webView.getSettings().setJavaScriptEnabled(true);
	     webView.setWebChromeClient(new WebChromeClient());
	        //����WebViewĬ��ʹ�õ�������ϵͳĬ�����������ҳ����Ϊ��ʹ��ҳ��WebView��
	         webView.loadUrl("http://m.kuaidi100.com"); 
	         webView.setWebViewClient(new WebViewClient() );
	    
	      
	       
	}
	
/*	buttontest.setOnClickListener(new OnClickListener(){
		public void onClick(View v) {
			Uri uri = Uri.parse("http://m.kuaidi100.com");  
			Intent it  = new Intent(Intent.ACTION_VIEW,uri);  
			startActivity(it);  
		}});*/
	/*public void serch() {
		 webView= (WebView)findViewById(R.id.word_web_view);
		 webView.loadUrl("http://m.kuaidi100.com");
		webView.setWebViewClient(new WebViewClient(){
			public boolean shou(WebView view,String url){
				view.loadUrl(url);
				return true;
			}
		});
	}*/
	private void init(){
        webView = (WebView) findViewById(R.id.word_web_view);
        //WebView����web��Դ
       webView.loadUrl("http://http://m.kuaidi100.com/all/");
        //����WebViewĬ��ʹ�õ�������ϵͳĬ�����������ҳ����Ϊ��ʹ��ҳ��WebView��
       webView.setWebViewClient(new WebViewClient(){
    	   public boolean shouldOverrideUrlLoading(WebView view, String url) {
               // TODO Auto-generated method stub
                  //����ֵ��true��ʱ�����ȥWebView�򿪣�Ϊfalse����ϵͳ�����������������
                view.loadUrl(url);
               return true;
           }
       }
       );
    }
	
	

}
