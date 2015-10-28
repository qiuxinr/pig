package com.gdcc.wsyy;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.PublicKey;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.gdcc.wsyy.data.Changer;
import com.gdcc.wsyy.data.utils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class service_main extends Fragment {
	
	
	EditText SearEdit;
	ImageView  SearchB;
	String bb;
	String yym;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
	 View view=inflater.inflate(R.layout.service_m_main, null);
		

   	    SearchB = (ImageView) view.findViewById(R.id.iv_search);
	    SearEdit=(EditText)view.findViewById(R.id.et_search);
	  
		  
		  
		  
		 SearchB.setOnClickListener(new OnClickListener()  
	        {  
	            @Override  
	            public void onClick(View v)  
	            {  
	            	
	           	 yym=SearEdit.getText().toString();
	            	
	            	
	          
	   
	   		    Changer changer=new Changer();
	   		  try {
	   		 bb=changer.Changerr(yym);
	   		
	   		
	   		
	   		  } catch (UnsupportedEncodingException e1) {
	   		
	   			e1.printStackTrace();
	   		   }
	   		  
	   		  
	   		  
	  
	   		  Toast.makeText(getActivity() ,bb, Toast.LENGTH_LONG).show();
	            	
					Thread th=new Thread(){

						@Override
						public void run() {

							String path="http://pc-201502130051:8080/wsyyweb//servlet/cxyy?yyname=经济";
						
							HttpClient hc=new DefaultHttpClient();
							
							
							HttpGet hg=new HttpGet(path);
							
						     try {
								HttpResponse hr=hc.execute(hg);
								if (hr.getStatusLine().getStatusCode()==200) {
									//取得实体
									HttpEntity he=hr.getEntity();
									//取得实体的输入流
								InputStream is=	he.getContent();
								
								String text=utils.getTextFromStream(is);
								//发送信息，让主线程更新UI	
								}
				
							} catch (ClientProtocolException e) {
							
								e.printStackTrace();
							} catch (IOException e) {
							
								e.printStackTrace();
							}
						
						}
						
					};
					th.start();
				
	      	
	            }  
	        });  
	            	
		
		
		
         return view;
	}
	
	  
	
	   
	
	
	

}
