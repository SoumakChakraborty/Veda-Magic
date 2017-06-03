package com.example.souma.vedamagic;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.LightingColorFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Menu extends AppCompatActivity
{
 private static int c=0;
  private DrawerLayout dl;
    private ActionBarDrawerToggle tog;
    Toolbar tl;
    NavigationView nv;
    String username;
    TextView tv;
    SharedPreferences s;
    SharedPreferences.Editor ed;
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        setContentView(R.layout.activity_menu);
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
        nv=(NavigationView)findViewById(R.id.navlist);
        s=getSharedPreferences("userdata", Context.MODE_PRIVATE);
        ed=s.edit();
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getOrder() == 2) {
                    ConnectivityManager c = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo n = c.getActiveNetworkInfo();
                    if (n != null) {
                        if (n.isAvailable()) {
                            Intent in = new Intent(getApplicationContext(), Feedback.class);
                            startActivity(in);
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Not connected", Toast.LENGTH_SHORT).show();
                }

                else if (item.getOrder() == 3) {
                            Intent in = new Intent(getApplicationContext(), About.class);
                            startActivity(in);
                                        }

                else if(item.getOrder()==4)
                {
                    ed.clear();
                    ed.apply();
                    Intent in=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(in);
                }
                else if(item.getOrder()==1)
                {
                    Intent in=new Intent(getApplicationContext(),My_account.class);
                    in.putExtra("username",username);
                    startActivity(in);
                }
                else if(item.getOrder()==5)
                {
                    ConnectivityManager c=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo n=c.getActiveNetworkInfo();
                    if(n!=null)
                    {
                        if(n.isAvailable()) {
                            Intent i = new Intent(Menu.this, Rating.class);
                            startActivity(i);
                        }
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Not connected",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        tl=(Toolbar)findViewById(R.id.mytoolbar);
        setSupportActionBar(tl);
        dl=(DrawerLayout)findViewById(R.id.mydrawer);
        tog=new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        dl.addDrawerListener(tog);
        tog.syncState();
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        catch (Exception e)
        {

        }
        Button b=(Button)findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ConnectivityManager c=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo n=c.getActiveNetworkInfo();
                if(n!=null)
                {
                  if(n.isAvailable()) {
                      Intent i = new Intent(Menu.this, Videos.class);
                      startActivity(i);
                  }
                }
                else
                   Toast.makeText(getApplicationContext(),"Not connected",Toast.LENGTH_SHORT).show();
            }
        });

        Button b2=(Button)findViewById(R.id.button1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(in);
            }
        });
        Button ebooks=(Button)findViewById(R.id.button4);
        ebooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager c=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo n=c.getActiveNetworkInfo();
                if(n!=null)
                {
                    if(n.isAvailable()) {
                        Intent i = new Intent(Menu.this, Multiplication.class);
                        startActivity(i);
                    }
                }
                else
                    Toast.makeText(getApplicationContext(),"Not connected",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(tog.onOptionsItemSelected(item))
        {
            tv=(TextView)findViewById(R.id.username);
            tv.setText(username);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void topicChooser(View v)
    {
        Intent i=new Intent(this,Topic.class);
        startActivity(i);
    }
    public void onBackPressed()
    {
      c++;
        if(c==1) {
            Toast.makeText(this, "Please click back button again to exit!!", Toast.LENGTH_LONG).show();
        }
        else {
            ActivityCompat.finishAffinity(Menu.this);
        }
    }
    public void giveTest(View v)
    {
        Intent i=new Intent(getApplicationContext(),Expandable.class);
        startActivity(i);
    }
}
