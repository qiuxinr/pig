package com.example.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.hbh.MySQLiteOpenHelper;

/**
 * @保存方式：SQLite 轻量级数据库、
 * @优点： 可以将自己的数据存储到文件系统或者数据库当中， 也可以将自己的数据存
 * 储到SQLite数据库当中，还可以存到SD卡中
 * @注意1：数据库对于一个游戏(一个应用)来说是私有的，并且在一个游戏当中，
 * 数据库的名字也是唯一的。
 * @注意2 apk中创建的数据库外部的进程是没有权限去读/写的,
 * 我们需要把数据库文件创建到sdcard上可以解决类似问题.
 * @注意3 当你删除id靠前的数据或者全部删除数据的时候，SQLite不会自动排序，
 * 也就是说再添加数据的时候你不指定id那么SQLite默认还是在原有id最后添加一条新数据
 * @注意4 android 中 的SQLite 语法大小写不敏感，也就是说不区分大小写；
 *
 */
public class MainActivity extends Activity implements OnClickListener{

	private Button btn_addOne,btn_deleteOne,btn_check,
					btn_edit,btn_deleteTable,btn_newTable;
	private TextView tv;
	private MySQLiteOpenHelper myOpenHelper;
	private SQLiteDatabase mysql;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.tv_title);
        btn_addOne = (Button)findViewById(R.id.sql_addOne);
        btn_deleteOne = (Button)findViewById(R.id.sql_deleteOne);
        btn_check = (Button)findViewById(R.id.sql_check);
        btn_edit = (Button)findViewById(R.id.sql_edit);
        btn_deleteTable = (Button)findViewById(R.id.sql_deleteTable);
        btn_newTable = (Button)findViewById(R.id.sql_newTable);
        btn_addOne.setOnClickListener(this);
        btn_edit.setOnClickListener(this);
        btn_check.setOnClickListener(this);
        btn_deleteOne.setOnClickListener(this);
        btn_deleteTable.setOnClickListener(this);
        btn_newTable.setOnClickListener(this);
        myOpenHelper = new MySQLiteOpenHelper(this); //实例化数据库辅助器
    }

	@Override
	public void onClick(View v) {
		
		try {
		mysql = myOpenHelper.getWritableDatabase(); //实例数据库
		
		if(v == btn_addOne) {	//添加数据	
			// ---------------------- 读写句柄来插入---------

            // ContentValues 其实就是一个哈希表HashMap， key值是字段名称，

            //Value值是字段的值。然后 通过 ContentValues 的 put 方法就可以

            //把数据放到ContentValues中，然后插入到表中去!
			
			ContentValues cv = new ContentValues();
			cv.put(MySQLiteOpenHelper.TEXT, "测试新的数据");
			mysql.insert(MySQLiteOpenHelper.TABLE_NAME, null, cv);
			// inser() 第一个参数 标识需要插入操作的表名

            // 第二个参数 :默认传null即可

            // 第三个是插入的数据

            // ---------------------- SQL语句插入--------------

            // String INSERT_DATA =

            // "INSERT INTO himi (id,text) values (1, '通过SQL语句插入')";

            // db.execSQL(INSERT_DATA);
			tv.setText("添加数据成功，点击查看数据库查询");
			
		}else if(v == btn_deleteOne) { //删除数据

            // ---------------------- 读写句柄来删除
			
			mysql.delete(MySQLiteOpenHelper.TABLE_NAME, MySQLiteOpenHelper.ID+"=1", null);
			// 第一个参数 需要操作的表名

            // 第二个参数为 id+操作的下标 如果这里我们传入null，表示全部删除

            // 第三个参数默认传null即可

            // ----------------------- SQL语句来删除

            // String DELETE_DATA = "DELETE FROM hbh WHERE id=1";

            // db.execSQL(DELETE_DATA);
			tv.setText("删除数据成功");
		}else if(v == btn_check) {	//遍历数据库
			//通过游标进行遍历
			Cursor cur = mysql.rawQuery("SELECT * FROM "+MySQLiteOpenHelper.TABLE_NAME, null);
			if(cur !=null) {
				String temp = "";
				int i=0;
				while(cur.moveToNext()) {
					temp += cur.getString(0);
					//这里的0相对于当前应该是咱们的id列了
					temp += cur.getString(1);
					//这里的1相对于当前应该是咱们的text列了
					
					i++;
					temp += " ";
					
					if(i%3 == 0) {
						temp += "/n";
					}
					tv.setText(temp);
				}
			}else if (v == btn_edit) {//修改数据
				 // ------------------------句柄方式来修改 -------------
				ContentValues cv = new ContentValues();
				cv.put(MySQLiteOpenHelper.TEXT, "修改后的数据");
				mysql.update(MySQLiteOpenHelper.TABLE_NAME, cv, "id "+ "=" + Integer.toString(3), null);
				 // ------------------------SQL语句来修改 -------------

                // String UPDATA_DATA =

                // "UPDATE himi SET text='通过SQL语句来修改数据' WHERE id=1";

                // db.execSQL(UPDATA_DATA);
				tv.setText("修改数据成功");
				
			}else if(v == btn_deleteTable) {
				
				mysql.execSQL("DROP TABLE hbh");
				tv.setText("删除表成功！点击查看数据库查询");
			}else if(v == btn_newTable) {//新建表
				String TABLE_NAME = "himi";
				String ID = "id";
				String TEXT = "text";
				String str_sql2 = "CREATE TABLE "+ TABLE_NAME + "("+ID
						+" INTEGER PRIMARY KEY AUTOINCREMENT,"+TEXT
						+" text );";
				mysql.execSQL(str_sql2);
				tv.setText("新建表成功！点击查看数据库查询");
				
			}
			
		}
		  // 删除数据库:

        // this.deleteDatabase("himi.db");

    } catch (Exception e) {
        tv.setText("操作失败！");
    } finally {// 如果try中异常，也要对数据库进行关闭

        mysql.close();
    }
}
}





