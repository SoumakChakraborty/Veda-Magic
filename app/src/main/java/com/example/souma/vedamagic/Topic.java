package com.example.souma.vedamagic;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;
public class Topic extends AppCompatActivity {
        List<String> l;
    Map<String,List<String>> m;
    ExpandableListView exp;
    ExpandableListAdapter el;
    ImageView img;
    TextView tv;
    int cid,pid;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        addItems();
        exp=(ExpandableListView)findViewById(R.id.myex);
        el=new Myexpandable(this,l,m,img);
        Animation an= AnimationUtils.loadAnimation(this,R.anim.myanim1);
        exp.setAnimation(an);
        exp.setAdapter(el);
        exp.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                pid=(int)id;
                parent.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                        cid=(int)id;
                        if(pid==0)
                        {
                            if(cid==0) {
                                Intent i = new Intent(Topic.this, MultiplyBy5.class);
                                startActivity(i);
                            }
                            else if(cid==1)
                            {
                                Intent i = new Intent(Topic.this, Multiply11.class);
                                startActivity(i);
                            }
                        }
                        else if(pid==1)
                        {
                            if(cid==0) {
                                Intent i = new Intent(Topic.this, Addition.class);
                                startActivity(i);
                            }
                        }
                        else if(pid==2)
                        {
                            if(cid==0) {
                                Intent i = new Intent(Topic.this, SubstractFromPowerOf10.class);
                                startActivity(i);
                            }
                        }
                        else if(pid==3)
                        {
                            if(cid==0) {
                                Intent i = new Intent(Topic.this, Multiply_2Digit.class);
                                startActivity(i);
                            }
                        }
                        return false;
                    }
                });
                return false;
            }
        });
    }
    public void addItems()
    {
        l=new ArrayList<>();
        m=new HashMap<>();
        List<String> l1=new ArrayList<>();
        List<String> l2=new ArrayList<>();
        List<String > l3=new ArrayList<>();
        List<String> l4=new ArrayList<>();
        l.add("Multiplication");
        l.add("Addition");
        l.add("Subtraction");
        l.add("Division");
        l1.add("Multiply by 5");
        l1.add("Multiply by 10");
        l2.add("Addition of two 2 digit numbers");
        l3.add("Subtraction of two numbers");
        l4.add("Division of two numbers");
        m.put(l.get(0),l1);
        m.put(l.get(1),l2);
        m.put(l.get(2),l3);
        m.put(l.get(3),l4);
    }
}
