package com.example.course;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.Window;

public class TalkActivity extends Activity {
	private final static String TAG = "Activity1";  
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		
		//requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_talk);
		//设置标题为某个layout
	 
	//	getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar1);
	
		 Log.i(TAG, "=============>onCreate"); 
    }  
  
    @Override  
    protected void onResume() {  
        super.onResume();     
         Log.i(TAG, "=============>onResume");  
    }  
      
    @Override  
    protected void onDestroy() {  
        super.onDestroy();    
         Log.i(TAG, "=============>onDestroy");  
    }         

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.talk, menu);
		return true;
	}

}
