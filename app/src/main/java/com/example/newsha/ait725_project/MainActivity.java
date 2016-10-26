package com.example.newsha.ait725_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //an object of DatabaseHelper
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        // if login button is clicked
        if(v.getId() == R.id.loginbutton) {

            EditText a = (EditText)findViewById(R.id.TFuname);
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.TFpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);

            if (pass.equals(password))
            {
                Intent i = new Intent(MainActivity.this, Display.class);
                i.putExtra("Username", str);
                startActivity(i);
            }
            else
            {
                //popup error msg
                Toast temp = Toast.makeText(MainActivity.this, "Password and Username don't match", Toast.LENGTH_SHORT);
                temp.show();
            }
        }
        // is signup button is clicked
        if(v.getId() == R.id.Bsignup)
        {

            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        }
    }
}
