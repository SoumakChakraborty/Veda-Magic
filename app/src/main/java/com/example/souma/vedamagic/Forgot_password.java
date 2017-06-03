package com.example.souma.vedamagic;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Forgot_password extends AppCompatActivity {

    DataBaseHelper db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        db=new DataBaseHelper(this);
    }
    public void forgotpasss(View v)
    {
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String pass="";
        EditText ed=(EditText)findViewById(R.id.forgot_pass);
        Cursor c=db.executeQueries();
        String user=ed.getText().toString();
        Pattern p= Pattern.compile(EMAIL_PATTERN);
        Matcher m=p.matcher(user);
        boolean b=m.matches();
        if(!user.equals("")&&b) {
            Intent i=new Intent(this,Resetpass.class);
            i.putExtra("username",user);
            startActivity(i);

        }
        else if(user.equals(""))
        {
            ed.setError("Field mandatory");
        }
        else if(!user.equals("")&&!b)
        {
            ed.setError("Not a valid email");
        }
    }
}
