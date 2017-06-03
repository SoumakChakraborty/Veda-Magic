package com.example.souma.vedamagic;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class About extends AppCompatActivity {

    SeekBar sb;
    TextView v;
    Button b;
    int c=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        sb=(SeekBar)findViewById(R.id.my_seekbar);
        b=(Button)findViewById(R.id.show_seek);
        show();
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                 int val=progress;
                val*=.45;
                v.setTextSize(val);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               if(c==0)
               {
                   c=1;
                   sb.setVisibility(View.VISIBLE);
                   b.setText("HIDE");
               }
               else if(c==1)
               {
                   c=0;
                   sb.setVisibility(View.INVISIBLE);
                   b.setText("SHOW");
               }
            }
        });
    }
    public void show() {
        int c;
        v = (TextView) findViewById(R.id.textView4);
        AssetManager asm = getAssets();
        InputStream is;
        try {

            is=asm.open("About.txt");
            v.setMovementMethod(new ScrollingMovementMethod());
            byte b[]=new byte[is.available()];
            is.read(b);
            v.setText(new String(b));
            is.close();
        }
        catch (Exception e) {

        }
    }
}
