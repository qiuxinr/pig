package com.example.course;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;



	import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;



	import com.example.course.R;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.course.Sqlite;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

	public class RegisteredActivity  extends Activity  {
		public Sqlite db;
		private EditText register_username;
		private EditText register_passwd;
		private EditText reregister_passwd;
		private Button register_submit;
		private SQLiteDatabase db1;
		
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
			
				setContentView(R.layout.activity_main);
				db = new Sqlite(this);
				
				register_username=(EditText)findViewById(R.id.register_username);
				register_passwd=(EditText)findViewById(R.id.register_passwd);
				final String usern=register_username.getText().toString();
			    final String userp=register_passwd.getText().toString();
				reregister_passwd=(EditText)findViewById(R.id.reregister_passwd);
				register_submit=(Button)findViewById(R.id.register_submit);
				register_username.setOnFocusChangeListener(new OnFocusChangeListener()
				{

					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						// TODO Auto-generated method stub
						if(!hasFocus){
							if(register_username.getText().toString().trim().length()<4){
								Toast.makeText(RegisteredActivity.this, "用户名不能小于4个字符", Toast.LENGTH_SHORT).show();
							}
						}
					}
					
				});
				register_passwd.setOnFocusChangeListener(new OnFocusChangeListener()
				{

					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						// TODO Auto-generated method stub
						if(!hasFocus){
							if(register_passwd.getText().toString().trim().length()<6){
								Toast.makeText(RegisteredActivity.this, "密码不能小于8个字符", Toast.LENGTH_SHORT).show();
							}
						}
					}
					
				});
				reregister_passwd.setOnFocusChangeListener(new OnFocusChangeListener()
				{

					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						// TODO Auto-generated method stub
						if(!hasFocus){
							if(!reregister_passwd.getText().toString().trim().equals(register_passwd.getText().toString().trim())){
								Toast.makeText(RegisteredActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show(); 
							}
						}
					}
					
				});		
				register_submit.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				
				if(!checkEdit()){
					return;
				}else {
					db1 = db.getWritableDatabase();
					ContentValues cv = new ContentValues();
					ContentValues cv1 = new ContentValues();
					cv.put(db.C_NAME,usern);
					cv1.put(db.C_PASSWORD,userp);
					db1.insert(db.TABLE_NAME,null,cv);
					db1.insert(db.TABLE_NAME,null,cv1);
					db1.close();
					Toast.makeText(RegisteredActivity.this, "恭喜你，注册成功", 3000).show();
					Intent intent2=new Intent( RegisteredActivity.this,MainActivity.class);
					startActivity(intent2);
				}}});
				
			}
			private boolean checkEdit(){
				if(register_username.getText().toString().trim().equals("")){
					Toast.makeText(RegisteredActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
				}else if(register_passwd.getText().toString().trim().equals("")){
					Toast.makeText(RegisteredActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
				}else if(!register_passwd.getText().toString().trim().equals(reregister_passwd.getText().toString().trim())){
					Toast.makeText(RegisteredActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
				}else{
					return true;
				}
				return false;
			}
			
			
		}

	 

