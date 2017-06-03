package com.example.souma.vedamagic;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.*;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
DataBaseHelper db;
    EditText email,password,fname,lname;
    Pattern p;
    Matcher m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        db=new DataBaseHelper(this);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        fname=(EditText)findViewById(R.id.firstname);
        lname=(EditText)findViewById(R.id.lastname);
    }
   public void signup(View v)
   {
       final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
       String user=email.getText().toString();
       String pass=password.getText().toString();
       String f=fname.getText().toString();
       String l=lname.getText().toString();
       p=Pattern.compile(EMAIL_PATTERN);
       m=p.matcher(user);
       boolean set=m.matches();
       boolean re=false;
       if(!user.equals("")&&!pass.equals("")&&!f.equals("")&&!l.equals("")) {
           re = db.insert(user, pass, f, l);
           if (re)
           {
               Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
               startActivity(new Intent(this, LoginActivity.class));
           }
       }
       else if(!user.equals(""))
       {
           if(!set)
            email.setError("Not a valid email");
       }
       else
       {
           email.setError("Fields mandatory");
           password.setError("Fields mandatory");
           fname.setError("Fields mandatory");
           lname.setError("Fields mandatory");
       }
   }
}
