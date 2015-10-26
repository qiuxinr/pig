package com.example.course;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public  class Sqlite extends SQLiteOpenHelper   {
	
	private final static String DATABASE_NAME ="suer.db"; 
	private final static int DATABASE_VERSION=1;
	
	private final String name="androidDBStorageSqlite";
	public final static String TABLE_NAME ="login";
	public final static String C_NAME="username";
	public final static String C_PASSWORD="password";
	public final static String C_ID="id";
	private SQLiteDatabase db=null;
	
	public Sqlite(Context context){
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
		
		
	}
//    public void openorCreateDatabase(SQLiteDatabase db) {
//		String sql="CREATE TABLE "+TABLE_NAME+"("+C_ID+"  INTEGER PRIMARY KEY AUTOINCREMENT,"+C_NAME+" VARCHAR(50)  ,"+ C_PASSWORD+" VARCHAR(50))";
//		db.execSQL(sql);
//		
//		
//    }
	
	
   
   
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		String sql="CREATE TABLE "+TABLE_NAME+"("+C_ID+"  INTEGER PRIMARY KEY AUTOINCREMENT, "+C_NAME+" VARCHAR(50)  , "+ C_PASSWORD+" VARCHAR(50))";
		arg0.execSQL (sql);
		
	}
	
	//public void insert(String name,String password) {
	/*	db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(C_NAME,name);
		cv.put(C_PASSWORD,password);
		db.insert(TABLE_NAME,null,cv);*/
	//}
	
	public Cursor Select() {
		db = this.getWritableDatabase();
		Cursor cursor=db.query(TABLE_NAME,null,null,null,null,null,null);
		return cursor;
	}
	public boolean login1(String username,String password){  
        db=this.getReadableDatabase();  
        String sql="select * from "+TABLE_NAME+" where "+C_NAME+" =? and "+C_PASSWORD+"=?";  
        Cursor cursor=db.rawQuery(sql, new String[]{username,password});         
        if(cursor.moveToFirst()==true){  
            cursor.close();  
            return true;  
        }  
        return false;  
    }  
	
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
//		String sql = "drop table if exists " + TABLE_NAME;
//		arg0.execSQL(sql);
//		onCreate(arg0);
		
	}
}
