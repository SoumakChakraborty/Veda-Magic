package com.example.souma.vedamagic;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Path;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class Multiply_2Digit extends AppCompatActivity {

    AlertDialog dialog;
    ImageView eight,eight_2,nine,six,minus_hundred_1,minus_hundred_2,equals_1,equals_2,two,one,four,four_2,four_3,eight_3,eight_4,arrow_1,arrow_2,doublearrow;
    TextView horizontal_line;
    int current_media=0,width,height;
    Toolbar tb;
    MediaPlayer[] sounds = new MediaPlayer[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_multiply_2_digit);
        tb=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width= displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
        eight = (ImageView) findViewById(R.id.eight);
        two = (ImageView) findViewById(R.id.two);
        eight_2 = (ImageView) findViewById(R.id.eight_2);
        nine = (ImageView) findViewById(R.id.nine);
        six = (ImageView) findViewById(R.id.six);
        minus_hundred_1 = (ImageView) findViewById(R.id.minus_hundred_1);
        minus_hundred_2 = (ImageView) findViewById(R.id.minus_hundred_2);
        equals_1 = (ImageView) findViewById(R.id.equals_1);
        equals_2 = (ImageView) findViewById(R.id.equals_2);
        one = (ImageView) findViewById(R.id.one);
        four = (ImageView) findViewById(R.id.four);
        four_2 = (ImageView) findViewById(R.id.four_2);
        four_3 = (ImageView) findViewById(R.id.four_3);
        eight_3 = (ImageView) findViewById(R.id.eight_3);
        eight_4 = (ImageView) findViewById(R.id.eight_4);
        arrow_1 = (ImageView) findViewById(R.id.arrow_1);
        arrow_2 = (ImageView) findViewById(R.id.arrow_2);
        horizontal_line = (TextView) findViewById(R.id.dash);
        doublearrow = (ImageView) findViewById(R.id.doublearrow);
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogue_View = inflater.inflate(R.layout.dialoguelayout,null);

        builder.setTitle("You need to know..").setView(dialogue_View)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.eighty_eight_time_ninety_six);
                        sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                        sounds[current_media++].start();
                        introduce_first_num();
                    }
                }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.eighty_eight_time_ninety_six);
                sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                sounds[current_media++].start();
                introduce_first_num();
            }
        });
        dialog = builder.create();
        dialog.show();
    }
    private void introduce_first_num()
    {
        AnimatorSet first_num_first_dig = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.first_num_first_dig);
        AnimatorSet first_num_second_dig = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.first_num_third_dig);
        first_num_first_dig.setTarget(eight);
        first_num_second_dig.setTarget(eight_2);
        AnimatorSet first_num_animator = new AnimatorSet();
        first_num_animator.playTogether(first_num_first_dig,first_num_second_dig);
        first_num_animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                eight.setScaleX(0.7f);
                eight_2.setScaleX(0.7f);
                nine.setVisibility(View.VISIBLE);
                six.setVisibility(View.VISIBLE);
                introduce_second_num();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        first_num_animator.start();
    }
    private void introduce_second_num()
    {
        AnimatorSet second_num_first_dig = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.lookup);
        AnimatorSet second_num_second_dig = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.lookup);
        second_num_first_dig.setTarget(nine);
        second_num_second_dig.setTarget(six);
        AnimatorSet second_num_animator = new AnimatorSet();
        second_num_animator.playTogether(second_num_first_dig,second_num_second_dig);
        second_num_animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                subtract_num1();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        second_num_animator.start();
    }
    private void subtract_num1()
    {
        DisplayMetrics displayMetrics= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int width = displayMetrics.widthPixels;
        final int height = displayMetrics.heightPixels;

        sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.subtract_from_closest_power_of_ten);
        sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
        sounds[current_media].start();
        sounds[current_media-1].release();
        sounds[current_media-1]=null;
        current_media++;

        minus_hundred_1.animate().alpha(1).translationXBy(-minus_hundred_1.getX()).setDuration(500).start();
        eight.animate().translationXBy((float)(minus_hundred_1.getWidth()*0.7-eight.getX())).setDuration(500).start();
        eight_2.animate().translationXBy((float)(minus_hundred_1.getWidth()*0.7-eight.getX())).setDuration(500).start();
        //equals_1.setX(width/2);
        equals_1.animate().alpha(1).setStartDelay(600).setDuration(500).withEndAction(new Runnable() {
            @Override
            public void run() {
                final int actualX= (int)one.getX();
                final int actualX_2 =(int)two.getX();
                one.setX(width);
                two.setX(width);
                one.setVisibility(View.VISIBLE);
                two.setVisibility(View.VISIBLE);
                ObjectAnimator introduce_one = ObjectAnimator.ofFloat(one,"X",width,actualX).setDuration(500);
                introduce_one.setInterpolator(new DecelerateInterpolator());
                introduce_one.setStartDelay(1200);
                introduce_one.start();

                ObjectAnimator introduce_two = ObjectAnimator.ofFloat(two,"X",width,actualX_2).setDuration(500);
                introduce_two.setInterpolator(new DecelerateInterpolator());
                introduce_two.setStartDelay(1500);
                //adding a listener to start doing the same operation with second number as done with first
                introduce_two.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        subtract_num2();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                introduce_two.start();
            }
        }).start();

    }
    private void subtract_num2()
    {
        DisplayMetrics displayMetrics= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int width = displayMetrics.widthPixels;
        final int height = displayMetrics.heightPixels;
        minus_hundred_2.animate().alpha(1).translationXBy(-minus_hundred_2.getX()).setDuration(500).start();
        nine.animate().translationXBy((float)(minus_hundred_2.getWidth()*0.7-nine.getX())).setDuration(500).start();
        six.animate().translationXBy((float)(minus_hundred_2.getWidth()*0.7-nine.getX())).setDuration(500).start();
        equals_2.setX(equals_1.getX());
        equals_2.animate().alpha(1).setStartDelay(600).setDuration(500).withEndAction(new Runnable() {
            @Override
            public void run() {
                final int actualX= (int)four.getX();
                four.setX(width);
                four.setVisibility(View.VISIBLE);
                ObjectAnimator introduce_four = ObjectAnimator.ofFloat(four,"X",width,actualX).setDuration(500);
                introduce_four.setInterpolator(new DecelerateInterpolator());
                introduce_four.setStartDelay(1200);
                introduce_four.start();
                //adding a listener to start doing the same operation with second number as done with first
                introduce_four.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        multiply();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                introduce_four.start();
            }
        }).start();

    }
    private void multiply()
    {
        sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.multiply_after_subtraction);
        sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
        sounds[current_media].start();
        sounds[current_media-1].release();
        sounds[current_media-1]=null;
        current_media++;

        arrow_1.setVisibility(View.VISIBLE);
        arrow_2.setVisibility(View.VISIBLE);
        Path path = new Path();
        Path path_2 = new Path();
        path.moveTo(arrow_2.getX(),arrow_2.getY());
        path_2.moveTo(arrow_1.getX(),arrow_1.getY());
        path.lineTo(arrow_2.getX()+40,arrow_2.getY()-40);
        path_2.lineTo(arrow_1.getX()+40,arrow_1.getY()+40);
        ObjectAnimator arrow2_animator = ObjectAnimator.ofFloat(arrow_2,"X","Y",path).setDuration(400);
        arrow2_animator.setRepeatMode(ValueAnimator.REVERSE);
        arrow2_animator.setRepeatCount(2);
        arrow2_animator.start();
        ObjectAnimator arrow1_animator = ObjectAnimator.ofFloat(arrow_1,"X","Y",path_2).setDuration(400);
        arrow1_animator.setRepeatMode(ValueAnimator.REVERSE);
        arrow1_animator.setRepeatCount(2);
        arrow1_animator.start();
        horizontal_line.animate().scaleX(3).setDuration(1000).setInterpolator(new LinearInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                introduce_multiplied_nums();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }
    private void introduce_multiplied_nums()
    {
        //TextView textView = new TextView(getApplicationContext());
        //textView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT));
        //textView.setGravity(Gravity.RIGHT|Gravity.BOTTOM);
       // textView.setText("maya");
       // RelativeLayout viewholder = (RelativeLayout)findViewById(R.id.viewholder);
       // viewholder.addView(textView);
        eight_3.setScaleX(0.001f);
        eight_3.setScaleY(0.001f);
        four_2.setScaleX(0.001f);
        four_2.setScaleY(0.001f);
        eight_3.setVisibility(View.VISIBLE);
        four_2.setVisibility(View.VISIBLE);
        eight_3.animate().scaleX(1.0f).scaleY(1.0f).setDuration(500).start();
        four_2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(500).setStartDelay(200).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                arrow_1.setVisibility(View.GONE);
                arrow_2.setVisibility(View.GONE);
                //Animation answer_animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
                //answer_animation.setRepeatMode(Animation.REVERSE);
               // answer_animation.setRepeatCount(Animation.INFINITE);
               // eight_3.startAnimation(answer_animation);
               // four_2.startAnimation(answer_animation);
                subtract_part_2();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();

    }
    private void subtract_part_2()
    {
        /*RelativeLayout viewholder = (RelativeLayout)findViewById(R.id.viewholder);
        double_arrow = new ImageView(getApplicationContext());
        double_arrow.setImageResource(R.drawable.five);
        RelativeLayout.LayoutParams layoutParams= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        //double_arrow.setScaleType(ImageView.ScaleType.FIT_XY);
        layoutParams.addRule(RelativeLayout.BELOW,equals_1.getId());
        layoutParams.addRule(RelativeLayout.RIGHT_OF,eight_2.getId());
        viewholder.addView(double_arrow,layoutParams); */
        sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.subtract_diagonally);
        sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
        while(sounds[current_media-1].isPlaying());
            sounds[current_media-1].release();
            sounds[current_media-1]=null;
        sounds[current_media].start();
        current_media++;

        doublearrow.setRotation(20);
        doublearrow.setScaleY(1);
        doublearrow.setVisibility(View.VISIBLE);
        ObjectAnimator double_arrow_animator = ObjectAnimator.ofFloat(doublearrow,"scaleX",0.7f,1.5f).setDuration(500);
        double_arrow_animator.setInterpolator(new AccelerateInterpolator());
        double_arrow_animator.setRepeatMode(ValueAnimator.REVERSE);
        double_arrow_animator.setRepeatCount(3);
        double_arrow_animator.start();

        doublearrow.animate().rotation(-30).setStartDelay(2000).setDuration(500).start();

        ObjectAnimator double_arrow_animator_2 = ObjectAnimator.ofFloat(doublearrow,"scaleX",0.7f,1.0f).setDuration(500);
        double_arrow_animator_2.setInterpolator(new AccelerateInterpolator());
        double_arrow_animator_2.setRepeatMode(ValueAnimator.REVERSE);
        double_arrow_animator_2.setRepeatCount(3);
        double_arrow_animator_2.setStartDelay(2500);
        double_arrow_animator_2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                doublearrow.animate().scaleX(0.0f).scaleY(0.0f).setDuration(500).withEndAction(new Runnable() {
                    @Override
                    public void run() {

                    }
                }).start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        double_arrow_animator_2.start();

        four_3.animate().scaleX(1.0f).scaleY(1.0f).alpha(1).setDuration(500).setStartDelay(3500).start();
        eight_4.animate().scaleX(1.0f).scaleY(1.0f).alpha(1).setDuration(500).setStartDelay(3800).withEndAction(new Runnable() {
            @Override
            public void run() {
                last_animation();
            }
        }).start();

    }
    private void last_animation()
    {
        sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.you_got_answer);
        sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
        sounds[current_media].start();
        sounds[current_media-1].release();
        sounds[current_media-1]=null;
        eight_4.animate().setListener(null).translationXBy(width/2-four_2.getWidth()-eight_4.getWidth()-eight_4.getX()).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        four_3.animate().setListener(null).translationXBy(width/2-four_3.getWidth()-four_3.getX()).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        four_2.animate().setListener(null).translationXBy(width/2-four_2.getX()).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        eight_3.animate().setListener(null).translationXBy(width/2+four_2.getWidth()-eight_3.getX()).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator()).start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(sounds[current_media]!=null) {
            sounds[current_media].release();
            sounds[current_media] = null;
        }
    }
    public boolean onCreateOptionsMenu(android.view.Menu menu)
    {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==R.id.skip)
        {
            Intent i=new Intent(getApplicationContext(),MultiplyBy5.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
