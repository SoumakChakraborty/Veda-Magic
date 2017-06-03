package com.example.souma.vedamagic;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.GridLayoutAnimationController;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {


    String[] text={"Addition","Subtraction","Multiplication","Division"};
    Integer[] imageid={R.drawable.addition,R.drawable.subtraction,R.drawable.multiplication,R.drawable.division};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_menu);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        MenuView adapter = new MenuView(MenuActivity.this, text, imageid);
        gridView.setAdapter(adapter);
        //Animation grid_alpha_animation = new AlphaAnimation(0.0f,1.0f);
        //grid_alpha_animation.setDuration(2000);
        //GridLayoutAnimationController gridview_animation = new GridLayoutAnimationController(grid_alpha_animation,1f,2f);
        //gridview_animation.setOrder(2);
        //gridview_animation.setDirectionPriority(GridLayoutAnimationController.DIRECTION_LEFT_TO_RIGHT);
        //gridview_animation.willOverlap();
        //gridView.setLayoutAnimation(gridview_animation);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final ActivityOptions activityOptions = ActivityOptions.makeScaleUpAnimation(view, 0, 0, view.getWidth(), view.getHeight());
                final Intent intent = new Intent(getApplicationContext(), Addition_Cardview.class);
                final Intent intent2 = new Intent(getApplicationContext(), Subtraction_Cardview.class);
                final Intent intent3 = new Intent(getApplicationContext(), Multiplication_Cardview.class);
                final Intent intent4 = new Intent(getApplicationContext(), Division_Cardview.class);
                switch (position) {
                    case 0:
                        ViewPropertyAnimator animator = view.animate().alpha(0.7f).setDuration(300).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                              startActivity(intent,activityOptions.toBundle());
                            }
                        });
                        animator.start();
                        break;
                    case 1:
                        ViewPropertyAnimator animator3 = view.animate().alpha(0.7f).setDuration(300).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(intent2,activityOptions.toBundle());
                            }
                        });
                        animator3.start();

                        startActivity(intent2, activityOptions.toBundle());
                        break;
                    case 2:
                        ViewPropertyAnimator animator2 = view.animate().alpha(0.7f).setDuration(300).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(intent3,activityOptions.toBundle());
                            }
                        });
                        animator2.start();
                        break;
                    case 3:
                        final ViewPropertyAnimator animator4 = view.animate().alpha(0.7f).setDuration(300).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(intent4,activityOptions.toBundle());
                            }
                        });
                        animator4.start();
                        break;
                }

            }
        });

    }
}
