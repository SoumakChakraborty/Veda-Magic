package com.example.souma.vedamagic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Division extends AppCompatActivity {

    ImageView img[];
    TextView tv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
        img=new ImageView[19];
        img[1]=(ImageView)findViewById(R.id.div1);
        img[2]=(ImageView)findViewById(R.id.div2);
        img[3]=(ImageView)findViewById(R.id.div3);
        img[4]=(ImageView)findViewById(R.id.div4);
        img[5]=(ImageView)findViewById(R.id.div5);
        img[6]=(ImageView)findViewById(R.id.div6);
        img[7]=(ImageView)findViewById(R.id.div7);
        img[8]=(ImageView)findViewById(R.id.div8);
        img[9]=(ImageView)findViewById(R.id.div9);
        img[10]=(ImageView)findViewById(R.id.div10);
        img[11]=(ImageView)findViewById(R.id.div11);
        img[12]=(ImageView)findViewById(R.id.div12);
        img[13]=(ImageView)findViewById(R.id.div13);
        img[14]=(ImageView)findViewById(R.id.div14);
        img[15]=(ImageView)findViewById(R.id.div15);
        img[16]=(ImageView)findViewById(R.id.div16);
        img[17]=(ImageView)findViewById(R.id.div17);
        img[18]=(ImageView)findViewById(R.id.div18);
        tv=(TextView)findViewById(R.id.divtext);
        set();
    }
    public void set()
    {
        Animation an= AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        an.setDuration(3000);
        for(int i=1;i<=5;i++)
            img[i].setAnimation(an);
        final Animation an1=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        final Animation an2=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        final Animation an3=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        final Animation an4=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        final Animation an5=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        final Animation an6=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        final Animation an7=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        final Animation an8=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        final Animation an9=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        final Animation an10=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        final Animation an11=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        final Animation an12=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
        final Animation an13=AnimationUtils.loadAnimation(this,R.anim.addition_anim);
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
        an11.setDuration(3000);
        an12.setDuration(3000);
        an13.setDuration(3000);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                img[6].setAnimation(an1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
             img[6].setVisibility(View.VISIBLE);
                img[7].setAnimation(an2);
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
                img[7].setVisibility(View.VISIBLE);
                img[8].setAnimation(an3);
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
            public void onAnimationEnd(Animation animation) {
                img[8].setVisibility(View.VISIBLE);
                img[10].setAnimation(an4);
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
            public void onAnimationEnd(Animation animation) {
                img[10].setVisibility(View.VISIBLE);
                img[12].setAnimation(an5);
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
            public void onAnimationEnd(Animation animation) {
              img[12].setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"First Divide 6 by 4",Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Now we get the quotient as 1 and we write below as shown",Toast.LENGTH_SHORT).show();
                img[13].setAnimation(an6);
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
            public void onAnimationEnd(Animation animation) {
                img[13].setVisibility(View.VISIBLE);
                img[14].setAnimation(an7);
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
            public void onAnimationEnd(Animation animation) {
             img[14].setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"Now we get the remainder 2 and we write up as shown",Toast.LENGTH_SHORT).show();
                img[8].setVisibility(View.INVISIBLE);
                img[9].setAnimation(an8);
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
             img[9].setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"Now we take 27 and divide by 4",Toast.LENGTH_SHORT).show();
                img[9].setVisibility(View.INVISIBLE);
                img[10].setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),"Now we get the remainder 6 and write below as shown",Toast.LENGTH_SHORT).show();
                img[15].setAnimation(an9);
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
            img[15].setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(),"Now we get the remainder 3 and we write up as shown",Toast.LENGTH_SHORT).show();
             img[11].setAnimation(an10);
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
              img[11].setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"Now we take 31 and divide by 4",Toast.LENGTH_SHORT).show();
                img[11].setVisibility(View.INVISIBLE);
                img[12].setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),"Now we get the quotient as 7 and write as shown below",Toast.LENGTH_SHORT).show();
                img[16].setAnimation(an11);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an11.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
              img[16].setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"Now we get the final remainder 3 and write as shown",Toast.LENGTH_SHORT).show();
                tv.setAnimation(an12);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an12.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
             tv.setVisibility(View.VISIBLE);
                img[17].setAnimation(an13);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an13.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                img[17].setVisibility(View.VISIBLE);
                img[18].setVisibility(View.VISIBLE);
               Toast.makeText(getApplicationContext(),"The answer is shown by the red arrow",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
