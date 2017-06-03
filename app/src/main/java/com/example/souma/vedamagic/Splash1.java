package com.example.souma.vedamagic;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Splash1 extends AppCompatActivity {

    SharedPreferences s;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);
      //  setupWindowTransitions();
        final ImageView imageView=(ImageView)findViewById(R.id.imageview1);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splashanimation);
        animation.setDuration(1500);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        s=getSharedPreferences("userdata", Context.MODE_PRIVATE);
        final String username=s.getString("username","");
        final String pass=s.getString("password","");

        //final Animation animation1=AnimationUtils.loadAnimation(this,R.anim.alpha_animation);
        //animation.setDuration(1500);
        final Animation alphaanimation = new AlphaAnimation(0.0f,1.0f);
        alphaanimation.setDuration(1500);
        alphaanimation.setFillAfter(true);
        animation.setFillAfter(true); animation.setFillEnabled(true);
        final RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relative);
        relativeLayout.setVisibility(View.VISIBLE);
        animation.setAnimationListener(new Animation.AnimationListener() {
            private Context splash=getBaseContext();
            @Override
            public void onAnimationStart(Animation animation) {
                relativeLayout.startAnimation(alphaanimation);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
               /// Intent intent = new Intent(splash,MenuActivity.class);
               // View image = (View)findViewById(R.id.imageview);
                ActivityOptions activityOptions= ActivityOptions.makeScaleUpAnimation(imageView,(int)imageView.getX(),(int)imageView.getY(),imageView.getWidth(),imageView.getHeight());
                if(!username.equals("")&&!pass.equals("")) {
                    Intent i = new Intent(Splash1.this, MenuActivity.class);
                    i.putExtra("username",username);
                   // Intent intent = new Intent(splash,MenuActivity.class);
                    // View image = (View)findViewById(R.id.imageview);
                  //  ActivityOptions activityOptions= ActivityOptions.makeScaleUpAnimation(imageView,(int)imageView.getX(),(int)imageView.getY(),imageView.getWidth(),imageView.getHeight());
                    startActivity(i,activityOptions.toBundle());
                }
                else
                {
                    Intent i = new Intent(Splash1.this, LoginActivity.class);

                    startActivity(i,activityOptions.toBundle());
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(animation);
    }
   /* private void setupWindowTransitions()
    {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setExitTransition(new Explode());
    } */

}
