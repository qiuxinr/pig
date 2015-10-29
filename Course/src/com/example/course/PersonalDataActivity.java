package com.example.course;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class PersonalDataActivity extends Activity {
     Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_data);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar1);
		
		button1= (Button) this.findViewById(R.id.back1);
		button1.setOnClickListener(new OnClickListener(){                
	         @Override 
	         public void onClick(View v) { 
	 
	        Intent intent = new Intent(PersonalDataActivity.this, CustomTabActivity2.class); 
	        startActivity(intent); 
	        } 
	        }); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.personal_data, menu);
		return true;
	}

}
