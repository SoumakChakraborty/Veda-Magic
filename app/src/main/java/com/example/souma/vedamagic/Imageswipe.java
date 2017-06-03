package com.example.souma.vedamagic;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Imageswipe extends AppCompatActivity {

    int images[];
    int forward=1,backward=4;
    ImageView img;
    Button b1,b2;
    TextView tv1,tv2,tv3,tv4;
    int c=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageswipe);
        images=new int[4];
        images[0]=R.drawable.veda1;
        images[1]=R.drawable.veda2;
        images[2]=R.drawable.veda3;
        images[3]=R.drawable.veda4;
        img=(ImageView)findViewById(R.id.imageswitcher);
        b1=(Button)findViewById(R.id.prev);
        b2=(Button)findViewById(R.id.next);
        tv1=(TextView)findViewById(R.id.pro1);
        tv2=(TextView)findViewById(R.id.pro2);
        tv3=(TextView)findViewById(R.id.pro3);
        tv4=(TextView)findViewById(R.id.pro4);
        swipe();
    }
    public void swipe()
    {

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            b1.setVisibility(View.VISIBLE);
                b2.setVisibility(View.INVISIBLE);
                if(backward>=0)
                {
                    img.setImageResource(images[--backward]);
                    if(backward==2)
                    {
                        tv1.setBackgroundColor(Color.WHITE);
                        tv2.setBackgroundColor(Color.WHITE);
                        tv3.setBackgroundColor(Color.BLACK);
                        tv4.setBackgroundColor(Color.WHITE);
                    }
                    else if(backward==1)
                    {
                        tv1.setBackgroundColor(Color.WHITE);
                        tv2.setBackgroundColor(Color.BLACK);
                        tv3.setBackgroundColor(Color.WHITE);
                        tv4.setBackgroundColor(Color.WHITE);
                    }
                    else if (backward==0)
                    {
                        tv1.setBackgroundColor(Color.BLACK);
                        tv2.setBackgroundColor(Color.WHITE);
                        tv3.setBackgroundColor(Color.WHITE);
                        tv4.setBackgroundColor(Color.WHITE);
                    }
                }
                if(backward==0)
                {
                    b2.setVisibility(View.VISIBLE);
                    b1.setVisibility(View.INVISIBLE);
                    backward=4;
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setVisibility(View.VISIBLE);
                b1.setVisibility(View.INVISIBLE);
                if(forward<4) {
                    img.setImageResource(images[forward++]);
                    if(forward==2)
                    {
                        tv1.setBackgroundColor(Color.WHITE);
                        tv2.setBackgroundColor(Color.BLACK);
                        tv3.setBackgroundColor(Color.WHITE);
                        tv4.setBackgroundColor(Color.WHITE);
                    }
                    else if (forward==3)
                    {
                        tv1.setBackgroundColor(Color.WHITE);
                        tv2.setBackgroundColor(Color.WHITE);
                        tv3.setBackgroundColor(Color.BLACK);
                        tv4.setBackgroundColor(Color.WHITE);
                    }
                }
                if(forward==4) {
                    tv1.setBackgroundColor(Color.WHITE);
                    tv2.setBackgroundColor(Color.WHITE);
                    tv3.setBackgroundColor(Color.WHITE);
                    tv4.setBackgroundColor(Color.BLACK);
                    b1.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.INVISIBLE);
                    forward=1;
                }
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        ActivityCompat.finishAffinity(Imageswipe.this);
        super.onBackPressed();
    }
    public void signUp(View v)
    {
        Intent i=new Intent(this,SignUp.class);
        startActivity(i);
    }
    public void signin(View v)
    {
        Intent i=new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}
