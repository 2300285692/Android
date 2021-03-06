package com.dingcheng365.book;

import android.content.Intent;
import android.database.Cursor;
import android.icu.text.IDNA;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.HashMap;

public class ClassificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classification_layout);
        //实例DBHelper
        final DB db=new DB(this);
        //获得Cuosor
        Cursor c=db.queryClassification();
        int count= c.getCount();
        //列表项数组
        String[] from={"classname"};
        //列表项id
        int[] to={R.id.cf_tv_classname};
        //列表视图
        final ListView listView=(ListView) findViewById(R.id.cf_list);
        //适配器
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.classification_layout,c,from,to,0);//this,R.layout.display_layout,c,from,to
        //为列表添加适配器
        listView.setAdapter(adapter);
        //对话框
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //为listView添加监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                String mytitle = null;
                String mycontent = null;

                switch(arg0.getId())
                {
                    case R.id.cf_list:
                        ListView templist = (ListView) arg0;
                        View mView = templist.getChildAt(arg2);
                       TextView mytextview = (TextView) mView.findViewById(R.id.cf_tv_classname);
                        mytitle = mytextview.getText().toString();
                }
                Intent intent=new Intent(ClassificationActivity.this,ClassnameEditActivity.class);
                intent.putExtra("classname",mytitle);
                startActivity(intent);
            }
        });
        //关闭数据库
        db.close();
    }
}
