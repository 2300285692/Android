package com.dingcheng365.ui03;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

    }
        public void buttton_onClick(View v) {
            Toast.makeText(v.getContext(), "You have clicked a button!",Toast.LENGTH_LONG).show();
        }
}
