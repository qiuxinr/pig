package com.example.course;
import  android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.*;
public class Welcome  extends Activity{
	protected void  onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.welcome);
		new Handler(new Handler.Callback(){
			public boolean handleMessage(Message msg) {
				startActivity(new Intent(getApplicationContext(),MainActivity.class));
				finish();
				return false;
			}
			
			
		}).sendEmptyMessageDelayed(0,2000);
		
		
	}

}
