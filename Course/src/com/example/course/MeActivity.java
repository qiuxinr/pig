package com.example.course;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MeActivity extends Activity {
	Button button1;
	private final static String TAG = "Activity1";  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_me);
		button1=(Button) this.findViewById(R.id.button1); 
		button1.setOnClickListener(new OnClickListener(){                
	         @Override 
	         public void onClick(View v) { 
	 
	        Intent intent = new Intent(MeActivity.this, PersonalDataActivity.class); 
	        startActivity(intent); 
	        } 
	        }); 
		//设置标题为某个layout
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
		getMenuInflater().inflate(R.menu.me, menu);
		return true;
	}

}
