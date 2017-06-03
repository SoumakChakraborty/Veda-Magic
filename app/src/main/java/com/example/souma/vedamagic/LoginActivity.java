package com.example.souma.vedamagic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText ed1,ed2;
    private Button b1;
    DataBaseHelper db;
    SharedPreferences s;
    SharedPreferences.Editor ed;
    private int c;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        db=new DataBaseHelper(this);
  }
  public void show(View v) {
      int flag=0;
      ed1 = (EditText) findViewById(R.id.user);
      ed2 = (EditText) findViewById(R.id.pass);
      Cursor c = db.executeQueries();
      Intent i = new Intent(this, Menu.class);
      String user = ed1.getText().toString();
      String pass = ed2.getText().toString();
      s = getSharedPreferences("userdata", Context.MODE_PRIVATE);
      ed = s.edit();
      if(!user.equals("")&&!pass.equals("")) {
          while (c.moveToNext()) {
              String u = c.getString(0);
              String p = c.getString(3);
              if (user.equals(u)) {
                  if (pass.equals(p)) {

                      flag= 1;
                      break;
                  }
              }
          }
          if(flag==1)
          {
              ed.putString("username",user);
              ed.putString("password",pass);
              ed.commit();
              i.putExtra("username",user);
              startActivity(i);
          }
          else
          {
              Snackbar snb=Snackbar.make(findViewById(R.id.myrelative),R.string.error,Snackbar.LENGTH_SHORT);
              snb.show();
                      }
      }
      else
      {
          ed1.setError("Fields mandatory");
          ed2.setError("Fields mandatory");
      }
  }
  public void forgot(View v)
  {
      Intent i=new Intent(this,Forgot_password.class);
      startActivity(i);
  }

    @Override
    public void onBackPressed() {
       ActivityCompat.finishAffinity(LoginActivity.this);
        super.onBackPressed();
    }
}
