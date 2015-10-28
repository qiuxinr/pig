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
 * @���淽ʽ��SQLite ���������ݿ⡢
 * @�ŵ㣺 ���Խ��Լ������ݴ洢���ļ�ϵͳ�������ݿ⵱�У� Ҳ���Խ��Լ������ݴ�
 * ����SQLite���ݿ⵱�У������Դ浽SD����
 * @ע��1�����ݿ����һ����Ϸ(һ��Ӧ��)��˵��˽�еģ�������һ����Ϸ���У�
 * ���ݿ������Ҳ��Ψһ�ġ�
 * @ע��2 apk�д��������ݿ��ⲿ�Ľ�����û��Ȩ��ȥ��/д��,
 * ������Ҫ�����ݿ��ļ�������sdcard�Ͽ��Խ����������.
 * @ע��3 ����ɾ��id��ǰ�����ݻ���ȫ��ɾ�����ݵ�ʱ��SQLite�����Զ�����
 * Ҳ����˵��������ݵ�ʱ���㲻ָ��id��ôSQLiteĬ�ϻ�����ԭ��id������һ��������
 * @ע��4 android �� ��SQLite �﷨��Сд�����У�Ҳ����˵�����ִ�Сд��
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
        myOpenHelper = new MySQLiteOpenHelper(this); //ʵ�������ݿ⸨����
    }

	@Override
	public void onClick(View v) {
		
		try {
		mysql = myOpenHelper.getWritableDatabase(); //ʵ�����ݿ�
		
		if(v == btn_addOne) {	//�������	
			// ---------------------- ��д���������---------

            // ContentValues ��ʵ����һ����ϣ��HashMap�� keyֵ���ֶ����ƣ�

            //Valueֵ���ֶε�ֵ��Ȼ�� ͨ�� ContentValues �� put �����Ϳ���

            //�����ݷŵ�ContentValues�У�Ȼ����뵽����ȥ!
			
			ContentValues cv = new ContentValues();
			cv.put(MySQLiteOpenHelper.TEXT, "�����µ�����");
			mysql.insert(MySQLiteOpenHelper.TABLE_NAME, null, cv);
			// inser() ��һ������ ��ʶ��Ҫ��������ı���

            // �ڶ������� :Ĭ�ϴ�null����

            // �������ǲ��������

            // ---------------------- SQL������--------------

            // String INSERT_DATA =

            // "INSERT INTO himi (id,text) values (1, 'ͨ��SQL������')";

            // db.execSQL(INSERT_DATA);
			tv.setText("������ݳɹ�������鿴���ݿ��ѯ");
			
		}else if(v == btn_deleteOne) { //ɾ������

            // ---------------------- ��д�����ɾ��
			
			mysql.delete(MySQLiteOpenHelper.TABLE_NAME, MySQLiteOpenHelper.ID+"=1", null);
			// ��һ������ ��Ҫ�����ı���

            // �ڶ�������Ϊ id+�������±� ����������Ǵ���null����ʾȫ��ɾ��

            // ����������Ĭ�ϴ�null����

            // ----------------------- SQL�����ɾ��

            // String DELETE_DATA = "DELETE FROM hbh WHERE id=1";

            // db.execSQL(DELETE_DATA);
			tv.setText("ɾ�����ݳɹ�");
		}else if(v == btn_check) {	//�������ݿ�
			//ͨ���α���б���
			Cursor cur = mysql.rawQuery("SELECT * FROM "+MySQLiteOpenHelper.TABLE_NAME, null);
			if(cur !=null) {
				String temp = "";
				int i=0;
				while(cur.moveToNext()) {
					temp += cur.getString(0);
					//�����0����ڵ�ǰӦ�������ǵ�id����
					temp += cur.getString(1);
					//�����1����ڵ�ǰӦ�������ǵ�text����
					
					i++;
					temp += " ";
					
					if(i%3 == 0) {
						temp += "/n";
					}
					tv.setText(temp);
				}
			}else if (v == btn_edit) {//�޸�����
				 // ------------------------�����ʽ���޸� -------------
				ContentValues cv = new ContentValues();
				cv.put(MySQLiteOpenHelper.TEXT, "�޸ĺ������");
				mysql.update(MySQLiteOpenHelper.TABLE_NAME, cv, "id "+ "=" + Integer.toString(3), null);
				 // ------------------------SQL������޸� -------------

                // String UPDATA_DATA =

                // "UPDATE himi SET text='ͨ��SQL������޸�����' WHERE id=1";

                // db.execSQL(UPDATA_DATA);
				tv.setText("�޸����ݳɹ�");
				
			}else if(v == btn_deleteTable) {
				
				mysql.execSQL("DROP TABLE hbh");
				tv.setText("ɾ����ɹ�������鿴���ݿ��ѯ");
			}else if(v == btn_newTable) {//�½���
				String TABLE_NAME = "himi";
				String ID = "id";
				String TEXT = "text";
				String str_sql2 = "CREATE TABLE "+ TABLE_NAME + "("+ID
						+" INTEGER PRIMARY KEY AUTOINCREMENT,"+TEXT
						+" text );";
				mysql.execSQL(str_sql2);
				tv.setText("�½���ɹ�������鿴���ݿ��ѯ");
				
			}
			
		}
		  // ɾ�����ݿ�:

        // this.deleteDatabase("himi.db");

    } catch (Exception e) {
        tv.setText("����ʧ�ܣ�");
    } finally {// ���try���쳣��ҲҪ�����ݿ���йر�

        mysql.close();
    }
}
}





