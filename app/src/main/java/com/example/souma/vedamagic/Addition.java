package com.example.souma.vedamagic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Addition extends AppCompatActivity {

   ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11;
    TextView tv;
    int flag=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        img1=(ImageView)findViewById(R.id.addition1);
        img2=(ImageView)findViewById(R.id.addition2);
        img3=(ImageView)findViewById(R.id.addition3);
        img4=(ImageView)findViewById(R.id.addition4);
        img5=(ImageView)findViewById(R.id.addition5);
        img6=(ImageView)findViewById(R.id.addition6);
        img7=(ImageView)findViewById(R.id.addition7);
        img8=(ImageView)findViewById(R.id.addition8);
        img9=(ImageView)findViewById(R.id.addition9);
        img10=(ImageView)findViewById(R.id.addition10);
        img11=(ImageView)findViewById(R.id.addition11);
        tv=(TextView)findViewById(R.id.carrytext);
        final Animation an1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.addition_anim);
        final Animation an2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.addition_anim);
        final Animation an3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.addition_anim);
        final Animation an4= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.addition_anim);
        final Animation an5= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.addition_anim);
        final Animation an6= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.addition_anim);
        final Animation an7= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.addition_anim);
        final Animation an8= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.addition_anim);
        final Animation an9= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.addition_anim);
        final Animation an10= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.addition_anim);
        an1.setDuration(3000);
        an2.setDuration(3000);
        an3.setDuration(3000);
        an4.setDuration(3000);
        an5.setDuration(3000);
        an6.setDuration(3000);
        an7.setDuration(3000);
        an8.setDuration(3000);
        an9.setDuration(3000);
        an10.setDuration(3000);

       img1.setAnimation(an1);
        an1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                img2.setAnimation(an2);
                img1.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                img3.setAnimation(an3);
              img2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                img4.setAnimation(an4);
             img3.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an4.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
               img4.setVisibility(View.VISIBLE);
               img5.setAnimation(an5);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an5.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                img5.setVisibility(View.VISIBLE);
                img6.setAnimation(an6);
                Toast.makeText(getApplicationContext(),"Add 3 and 7",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an6.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                img8.setAnimation(an8);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an8.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
             img8.setVisibility(View.VISIBLE);
                tv.setAnimation(an10);
                img10.setAnimation(an10);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an10.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
              img10.setVisibility(View.VISIBLE);
                tv.setVisibility(View.VISIBLE);
                img7.setAnimation(an7);
                Toast.makeText(getApplicationContext(),"Add 4 and 2 and add the previous carry 1",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an7.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                img9.setAnimation(an9);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an9.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                img9.setVisibility(View.VISIBLE);
                img11.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"The final answer is shown with the red arrow",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
