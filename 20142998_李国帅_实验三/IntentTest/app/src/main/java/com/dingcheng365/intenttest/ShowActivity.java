package com.dingcheng365.intenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout);
        TextView tv_name;
        tv_name=(TextView)findViewById(R.id.tv_s_name);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        String name=b.getString("name");
        tv_name.setText(name);
    }
}
