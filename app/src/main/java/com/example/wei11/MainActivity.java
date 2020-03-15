package com.example.wei11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private MyDbHelper myhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myhelper=new MyDbHelper(this,"iii",null,2020031501);
        db=myhelper.getReadableDatabase();

    }

    public void update(View view){

    }

    public void delete(View view){
        db.delete("cust","id=?and cname=?",new String[]{"1","永強"});
    }
    public void insert(View view){
        db.execSQL("INSERT INTO cust(cname,tel,birthday) VALUES ('永強','000','1991-01-01')");



    }

    public void query(View view){
        Cursor c=db.query("cust",null,
                null,null,
                null,null,null);//跟SQL語法裡 select 欄位 from 表單 where ...意義相同
        while(c.moveToNext()) {//指標能下移?
            String id=c.getString(0);//想要撈什麼樣的資料不用配合在表格內的真實型別，此處我想拿字串
            String idc=c.getString(c.getColumnIndex("id"));//改良，因為程式碼只寫0，閱讀性不佳
            String cname=c.getString(1);
            String tel=c.getString(2);
            String birthday=c.getString(3);

            Log.v("wei",id+":"+cname+":"+tel+":"+birthday);
        }
    }

}
