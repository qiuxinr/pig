package com.example.course;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BasicMainActivity extends Activity {
	  private final static String TAG = "Activity1";  
	  Button button3;
	  Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic_main);
		button3=(Button) this.findViewById(R.id.button3); 
		button1=(Button) this.findViewById(R.id.button1); 
		button3.setOnClickListener(new OnClickListener(){                
	         @Override 
	         public void onClick(View v) { 
	 
	        Intent intent = new Intent(BasicMainActivity.this, ApplicationTaskActivity.class); 
	        startActivity(intent); 
	        } 
	        }); 
		button1.setOnClickListener(new OnClickListener(){                
	        @Override 
	        public void onClick(View v) { 
	        	Intent intent=new Intent( BasicMainActivity.this,LoginActivity.class);
				startActivity(intent);
	        }});
		
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
		getMenuInflater().inflate(R.menu.basic_main, menu);
		return true;
	}
	
}
