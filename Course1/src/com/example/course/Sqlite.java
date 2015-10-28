package com.example.course;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite extends SQLiteOpenHelper   {
	
	private SQLiteDatabase db; 
	private Context mContext;
	private final static String name="androidDBStorageSqlite";
	public final static String TABLE_NAME ="login";
	public final static String C_NAME="username";
	public final static String C_PASSWORD="password";
	public final static String C_ID="id";
	
	public Sqlite( Context context){
		super(context, name,null,1);
		/*SQLiteDatabase db = openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);  
      
        //´´½¨person±í  
        db.execSQL("CREATE TABLE person (_id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR, password VARCHAR)");  
        Person  person = new  Person();
        person.username="123456";
        person.password="123456";*/
		
	}
    public void openorCreateDatabase() {
		db=mContext.openOrCreateDatabase(name,mContext.MODE_PRIVATE,null);
		db.execSQL("CREATE TABLE "+TABLE_NAME+"(id INTEGER PRIMARY KEY AUTOINCREMENT,"+C_NAME+" VARCHAR(50) NOT NULL,"+ C_PASSWORD+" VARCHAR(50) NOT NULL)");
		ContentValues cv=new ContentValues();
		cv.put(C_NAME,"123456");
		cv.put(C_PASSWORD,"12345");
		db.insert(TABLE_NAME,null,cv);
		
    }
    public void CloseData(){
    	db.close();
		db=null;
    }
    
   
	private SQLiteDatabase openOrCreateDatabase(String string, int modePrivate,
			Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}
