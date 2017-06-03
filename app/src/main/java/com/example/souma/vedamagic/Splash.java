package com.example.souma.vedamagic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    SharedPreferences s;
    private static  String def="none";
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView t=(ImageView)findViewById(R.id.show_label);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        s=getSharedPreferences("userdata", Context.MODE_PRIVATE);
        final String username=s.getString("username","");
        final String pass=s.getString("password","");
        Animation an= AnimationUtils.loadAnimation(Splash.this,R.anim.myanimation);
        t.setAnimation(an);
        super.onResume();
        new CountDownTimer(5000,1000)
        {
            public void onFinish()
            {
              if(!username.equals("")&&!pass.equals("")) {
                  Intent i = new Intent(Splash.this, Menu.class);
                  i.putExtra("username",username);
                  startActivity(i);
              }
              else
              {
                  Intent i = new Intent(Splash.this, Imageswipe.class);
                  startActivity(i);
              }
            }
            public void onTick(long millisUntilFinished)
            {

            }
        }.start();

    }

}
