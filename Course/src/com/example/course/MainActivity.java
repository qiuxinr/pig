package com.example.course;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private EditText login_username;
	private EditText login_password;
	private Button user_login_button;
	private Button user_register_button;
	public  String username;
	public  String userpassword;
	private SQLiteDatabase db1;
	public Sqlite db;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_wllcome);
		initWidget();
		db = new Sqlite(MainActivity.this);
		
		
	}
	
	private void initWidget() {
		// TODO Auto-generated method stub
		login_username=(EditText)findViewById(R.id.login_username);
		login_password=(EditText)findViewById(R.id.login_password);
		 username=login_username.getText().toString();
		userpassword=login_password.getText().toString();
		user_login_button=(Button)findViewById(R.id.user_login_button);
		user_register_button=(Button)findViewById(R.id.user_register_button);
		user_login_button.setOnClickListener(this);
		user_register_button.setOnClickListener(this);
		login_username.setOnFocusChangeListener(new OnFocusChangeListener()
		{

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(!hasFocus){
					String username=login_username.getText().toString().trim();
					if(username.length()<4){
						Toast.makeText(  MainActivity.this, "用户名不能小于4个字符",3000);
					}
				}
			}
			
		});
		login_password.setOnFocusChangeListener(new OnFocusChangeListener()
		{

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(!hasFocus){
					String password=login_password.getText().toString().trim();
					if(password.length()<4){
						Toast.makeText( MainActivity.this, "密码不能小于4个字符", 3000).show();
					}
				}
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wllcome, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.user_login_button:
			if(checkEdit())
			{	
				
				login(username,userpassword);
			} 
			
			break;
		case R.id.user_register_button:
			Intent intent2=new Intent( MainActivity.this,RegisteredActivity.class);
			startActivity(intent2);
			
			break;
		}
	}


	private boolean checkEdit(){
		if(login_username.getText().toString().trim().equals("")){
			Toast.makeText( MainActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
		}else if(login_password.getText().toString().trim().equals("")){
			Toast.makeText( MainActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
		}else{
			return true;
		}
		return false;
	}
	public void login1() {
		db1=db.getReadableDatabase();  
		String where=db.C_NAME+"=?";
		String[]  whereValues ={username};
		Cursor cursor =db1.query(db.TABLE_NAME,null,where,whereValues,null,null,null);
		
	}
	
	public void login(String username1,String password1){  
        db1=db.getReadableDatabase();  
        String sql="select * from login where username=? and password=?";  
        Cursor cursor=db1.rawQuery(sql, new String[]{username1,password1});         
        if(cursor.moveToFirst()==true){  
        	Toast.makeText(MainActivity.this,"登陆成功！",3000).show();
			Intent intent=new Intent( MainActivity.this,LoginActivity.class);
			startActivity(intent);
            cursor.close();  
            db1.close();
           
        }  
        Toast.makeText(MainActivity.this,"帐号或密码错误",3000).show();
    }  
	
}
