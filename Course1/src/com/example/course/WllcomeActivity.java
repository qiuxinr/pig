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

import com.example.course.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class WllcomeActivity extends Activity implements OnClickListener {
private EditText login_username;
private EditText login_password;
private Button user_login_button;
private Button user_register_button;

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	StrictMode.setThreadPolicy(policy);
	setContentView(R.layout.activity_wllcome);
	initWidget();

}
	private void initWidget()
	{
		login_username=(EditText)findViewById(R.id.login_username);
		login_password=(EditText)findViewById(R.id.login_password);
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
						Toast.makeText( WllcomeActivity.this, "�û�������С��4���ַ�", Toast.LENGTH_SHORT);
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
						Toast.makeText( WllcomeActivity.this, "���벻��С��4���ַ�", Toast.LENGTH_SHORT);
					}
				}
			}
			
		});
	}
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.user_login_button:
			if(checkEdit())
			{
				login();
			}
			
			break;
		case R.id.user_register_button:
			Intent intent2=new Intent( WllcomeActivity.this,LoginActivity.class);
			startActivity(intent2);
			break;
		}
	}
	
	private boolean checkEdit(){
		if(login_username.getText().toString().trim().equals("")){
			Toast.makeText(WllcomeActivity.this, "�û�������Ϊ��", Toast.LENGTH_SHORT).show();
		}else if(login_password.getText().toString().trim().equals("")){
			Toast.makeText(WllcomeActivity.this, "���벻��Ϊ��", Toast.LENGTH_SHORT).show();
		}else{
			return true;
		}
		return false;
	}
	
	private void login(){
		String httpUrl="http://192.168.1.102:8080/web-test/login.jsp";
		HttpPost httpRequest=new HttpPost(httpUrl);
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username",login_username.getText().toString().trim()));
		params.add(new BasicNameValuePair("password",login_password.getText().toString().trim()));
		HttpEntity httpentity = null;
		try {
			httpentity = new UrlEncodedFormEntity(params,"utf8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpRequest.setEntity(httpentity);
		HttpClient httpclient=new DefaultHttpClient();
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpclient.execute(httpRequest);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(httpResponse.getStatusLine().getStatusCode()==200)
		{
			String strResult = null;
			try {
				strResult = EntityUtils.toString(httpResponse.getEntity());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Toast.makeText(WllcomeActivity.this, strResult, Toast.LENGTH_SHORT).show();
			Intent intent=new Intent(WllcomeActivity.this,IndexActivity.class);
			startActivity(intent);
		}
		else
		{
			Toast.makeText(WllcomeActivity.this, "��¼ʧ�ܣ�", Toast.LENGTH_SHORT).show();
		}
		
	}
}
