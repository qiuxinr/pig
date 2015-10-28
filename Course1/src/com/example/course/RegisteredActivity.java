package com.example.course;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;



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
	import android.app.Activity;
	import android.os.Bundle;
	import android.os.StrictMode;
	import android.view.View;
	import android.view.View.OnClickListener;
	import android.view.View.OnFocusChangeListener;
	import android.widget.Button;
	import android.widget.EditText;
	import android.widget.Toast;

	public class RegisteredActivity  {
	 
	private EditText register_username;
	private EditText register_passwd;
	private EditText reregister_passwd;
	private Button register_submit;
		
		public RegisteredActivity() {
			
		
			register_username=(EditText)findViewById(R.id.register_username);
			register_passwd=(EditText)findViewById(R.id.register_passwd);
			reregister_passwd=(EditText)findViewById(R.id.reregister_passwd);
			
			register_username.setOnFocusChangeListener(new OnFocusChangeListener()
			{

				@Override
				public void onFocusChange(View v, boolean hasFocus) {
					// TODO Auto-generated method stub
					if(!hasFocus){
						if(register_username.getText().toString().trim().length()<4){
							Toast.makeText(RegisteredActivity.this, "�û�������С��4���ַ�", Toast.LENGTH_SHORT).show();
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
							Toast.makeText(Context, "���벻��С��8���ַ�", 3000).show();
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
							Toast.makeText(RegisteredActivity.this, "�����������벻һ��", Toast.LENGTH_SHORT).show(); 
						}
					}
				}
				
			});
			register_submit.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					
					if(!checkEdit()){
						return;
					}
					// TODO Auto-generated method stub
					String httpUrl="http://192.168.1.100:8080/web-test/register.jsp";
					HttpPost httpRequest=new HttpPost(httpUrl);
					List<NameValuePair> params=new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("username",register_username.getText().toString().trim()));
					params.add(new BasicNameValuePair("password",register_passwd.getText().toString().trim()));
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
						Toast.makeText(RegisteredActivity.this, strResult, Toast.LENGTH_SHORT).show();
					}
					else
					{
						Toast.makeText(RegisteredActivity.this, "�������", Toast.LENGTH_SHORT).show();
					}
					
				}
				
			});
		}
	private EditText findViewById(int registerUsername) {
			// TODO Auto-generated method stub
			return null;
		}
	
		private boolean checkEdit(){
			if(register_username.getText().toString().trim().equals("")){
				Toast.makeText(RegisteredActivity.this, "�û�������Ϊ��", Toast.LENGTH_SHORT).show();
			}else if(register_passwd.getText().toString().trim().equals("")){
				Toast.makeText(RegisteredActivity.this, "���벻��Ϊ��", Toast.LENGTH_SHORT).show();
			}else if(!register_passwd.getText().toString().trim().equals(reregister_passwd.getText().toString().trim())){
				Toast.makeText(RegisteredActivity.this, "�����������벻һ��", Toast.LENGTH_SHORT).show();
			}else{
				return true;
			}
			return false;
		}
		
	}

	 

