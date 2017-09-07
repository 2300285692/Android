package com.dingcheng365.database;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_name,et_like;
    private Button b_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        et_name=(EditText)findViewById(R.id.text_name);
        et_like=(EditText)findViewById(R.id.text_like);
        b_add=(Button)findViewById(R.id.bt_add);
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et_name.getText().toString();
                String like=et_like.getText().toString();
                ContentValues values=new ContentValues();
                //在values中添加内容
                values.put("name",name);
                values.put("hobby",like);
                //实例化数据库类
                DBHelper helper =new DBHelper(getApplicationContext());
                //插入数据
                helper.insert(values);
                //实例化Intent
                Intent intent=new Intent(MainActivity.this,DisplayActivity.class);
                startActivity(intent);
            }
        });
    }
}
