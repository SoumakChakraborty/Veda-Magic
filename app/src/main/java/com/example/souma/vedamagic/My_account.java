package com.example.souma.vedamagic;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class My_account extends AppCompatActivity {
    String username,fname,lname,pass;
    DataBaseHelper db;
    TextView tv1,tv2,tv3,tv4;
    Toolbar tb;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        Intent in=getIntent();
        username=in.getStringExtra("username");
        Log.i("user",username);
        db=new DataBaseHelper(this);
        Cursor c=db.executeQueries();
        tb=(Toolbar)findViewById(R.id.mytoolbar);
        setSupportActionBar(tb);
        while(c.moveToNext())
        {
            if(c.getString(0).equals(username))
            {
                fname=c.getString(1);
                lname=c.getString(2);
                pass=c.getString(3);
                break;
            }
        }
        tv1=(TextView)findViewById(R.id.email_show);
        tv2=(TextView)findViewById(R.id.firstname_show);
        tv3=(TextView)findViewById(R.id.lastname_show);
        tv4=(TextView)findViewById(R.id.password_show);
        tv1.setText("Username:"+username);
        tv2.setText("First Name:"+fname);
        tv3.setText("Last Name:"+lname);
        tv4.setText("Password:"+pass);
    }
    public void change(View v)
    {
        Intent i=new Intent(this,Change_pass.class);
        i.putExtra("username",username);
        startActivity(i);
    }
}
