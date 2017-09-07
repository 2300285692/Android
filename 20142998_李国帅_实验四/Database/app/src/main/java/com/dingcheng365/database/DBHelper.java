package com.dingcheng365.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "stu.db";
    private static final String TBL_NAME = "stuTbl";
    //创建表的语句
    private static final String
            CREATE_TBL = "create table stuTbl( _id integer primary key,name text ,hobby text)";
    //SQLiteDatabase实例
    private SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DB_NAME, null,2);
        Log.d("StudentMis","调用DB构造函数");
    }

    //创建表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TBL);
        Log.d("StudentMis","调用DB.onCreate()");
    }

    //插入方法
    public void insert(ContentValues values) {
        //获得SQLiteDataBase实例
        SQLiteDatabase db = getWritableDatabase();
        //插入
        db.insert(TBL_NAME, null, values);
        db.close();
        System.out.printf("数据库插入操作");
    }

    //查询方法
    public Cursor query() {
        System.out.printf("数据库查询方法");
        //获得SQLiteDataBase实例
        SQLiteDatabase db = getWritableDatabase();
        //查询获得Cursor
        Cursor cursor = db.query(TBL_NAME, null, null, null, null, null, null);
        return cursor;
    }

    //删除方法
    public void del(int id)
    {
        System.out.printf("数据库删除方法");
        if(db==null)
        {
            //获得SQLiteDateBase实例
            SQLiteDatabase db=getWritableDatabase();
            //删除
            db.delete(TBL_NAME,"_id=?", new String[]{String.valueOf(id)});
        }
    }
    //关闭数据库
    public void close()
    {
        System.out.printf("数据库删除方法");
        if(db!=null)
        {
            db.close();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
