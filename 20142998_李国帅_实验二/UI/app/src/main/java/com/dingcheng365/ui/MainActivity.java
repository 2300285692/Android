package com.dingcheng365.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        TextView textView = (TextView)findViewById(R.id.textView01);
        Button button = (Button)findViewById(R.id.button01);
    }
}
