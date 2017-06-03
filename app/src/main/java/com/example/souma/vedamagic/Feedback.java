package com.example.souma.vedamagic;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.AsyncListUtil;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import android.view.View.OnClickListener;
public class Feedback extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
    }
    public void Send(View view)
    {
        EditText ed=(EditText)findViewById(R.id.feed);
        Intent in=new Intent(Intent.ACTION_SENDTO);
        in.setData(Uri.parse("mailto:"));
        in.putExtra(Intent.EXTRA_EMAIL,new String[]{"vedamagic123@gmail.com"});
        in.putExtra(Intent.EXTRA_SUBJECT,"Feedback");
        in.putExtra(Intent.EXTRA_TEXT,ed.getText().toString());
        startActivity(Intent.createChooser(in,"Email"));
    }

}
