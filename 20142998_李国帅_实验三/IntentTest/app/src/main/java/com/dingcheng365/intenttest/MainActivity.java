package com.dingcheng365.intenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }
    public void add_onClick(View view)
    {
        TextView tv_name =(TextView) findViewById(R.id.tv_name);
        String str =tv_name.getText().toString();
        Bundle data=new Bundle();
        data.putString("name",str);
        Intent intent=new Intent(MainActivity.this,ShowActivity.class);
        intent.putExtra("name",str);
        startActivity(intent);
    }
}
