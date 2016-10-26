package com.example.newsha.ait725_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by newsha on 10/16/16.
 */

public class SignUp extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick(View v) {

        if (v.getId() == R.id.bsignupbutton)
        {
            EditText name = (EditText)findViewById(R.id.TFname);
            EditText uname = (EditText)findViewById(R.id.TFuname);
            EditText email = (EditText)findViewById(R.id.TFemail);
            EditText pass1 = (EditText)findViewById(R.id.TFpass1);
            EditText pass2 = (EditText)findViewById(R.id.TFpass2);

            String namestr = name.getText().toString();
            String unamestr = uname.getText().toString();
            String emailstr = email.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str))
            {

                //popup error msg
                Toast pass = Toast.makeText(SignUp.this, "Passwords do not match!", Toast.LENGTH_SHORT);
                pass.show();

            }
            else
            {
                //insert the details in db
                Contact c = new Contact();
                c.setName(namestr);
                c.setUname(unamestr);
                c.setEmail(emailstr);
                c.setPass(pass1str);

                helper.insertContact(c);

                Intent i = new Intent(SignUp.this, Display.class);
                i.putExtra("Username", namestr);
                startActivity(i);
            }

        }
    }
}
