package com.example.course;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class ApplicationTaskActivity extends Activity {
     Button back1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_application_task);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
		
		back1=(Button) this.findViewById(R.id.back); 
		back1.setOnClickListener(new OnClickListener(){                
	         @Override 
	         public void onClick(View v) { 
	 
	        Intent intent = new Intent(ApplicationTaskActivity.this, CustomTabActivity2.class); 
	        startActivity(intent); 
	        } 
	        }); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.application_task, menu);
		return true;
	}

}
