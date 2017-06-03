package com.example.souma.vedamagic;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Change_pass extends AppCompatActivity {

    EditText e1, e2;
    String username;
    DataBaseHelper db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        Intent in = getIntent();
        username = in.getStringExtra("username");
        db = new DataBaseHelper(this);
        e1 = (EditText) findViewById(R.id.oldpassword);
        e2 = (EditText) findViewById(R.id.newpassword);
    }

    public void changepasss(View v) {
       String c1=e1.getText().toString();
        String c2=e2.getText().toString();
        if (c1.equals(c2)&&!c1.equals("")&&!c2.equals("")) {
            boolean b = db.updateQuery(username, e1.getText().toString());
            if (b) {
                Toast.makeText(getApplicationContext(), "Changed successfully", Toast.LENGTH_LONG).show();
                Intent i=new Intent(this,Menu.class);
                i.putExtra("username",username);
                startActivity(i);
            }
        }
        else if(!c1.equals(c2)&&!c1.equals("")&&!c2.equals(""))
        {
            e1.setError("Passwords donot match");
            e2.setError("Passwords donot match");
        }
        else
        {
            e1.setError("Fields mandatory");
            e2.setError("Fields mandatory");
        }
    }
}
