package com.dingcheng365.database;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_layout);
        //实例DBHelper
        final DBHelper helper=new DBHelper(this);
        //获得Cuosor
        Cursor c=helper.query();
        int count= c.getCount();
        //列表项数组
        String[] from={"_id","name","hobby"};
        //列表项id
        int[] to={R.id.id,R.id.name,R.id.like};
        //列表视图
        ListView listView=(ListView) findViewById(R.id.listView1);
       //适配器
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.display_layout,c,from,to,0);//this,R.layout.display_layout,c,from,to
        //为列表添加适配器
        listView.setAdapter(adapter);
        //对话框
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //为listView添加监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final long temp=arg3;
                builder.setMessage("是否删除记录？").setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //删除数据
                        helper.del((int)temp);
                        //查询
                        Cursor c=helper.query();
                        String[] from={"_id","name","hobby"};
                        int[] to={R.id.id,R.id.name,R.id.like};
                        SimpleCursorAdapter adapter=new SimpleCursorAdapter(getApplicationContext(),R.layout.display_layout,c,from,to,0);
                        ListView listView=(ListView) findViewById(R.id.listView1);
                        listView.setAdapter(adapter);

                    }
                }).setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                //提示对话框
                AlertDialog alertDialog=builder.create();
                //显示对话框
                alertDialog.show();
            }
        });
        //关闭数据库
        helper.close();
    }
}
