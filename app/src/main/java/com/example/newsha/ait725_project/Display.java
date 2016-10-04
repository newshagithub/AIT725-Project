package com.example.newsha.ait725_project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by newsha on 10/3/16.
 */

public class Display extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        String username = getIntent().getStringExtra("Username");
        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);
    }
}
