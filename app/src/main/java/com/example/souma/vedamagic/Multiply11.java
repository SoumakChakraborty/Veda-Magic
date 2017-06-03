package com.example.souma.vedamagic;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Multiply11 extends AppCompatActivity {

    public ImageView six, two, three, two_2, six_2, three_2, nine, five, six_3, two_3;
    TextView horizontal_line;
    Context context;
    AnimatorSet first_num_animator, second_num_animator, shifter;
    MediaPlayer[] sounds = new MediaPlayer[4];
    Toolbar tb;
    int current_media=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiply11);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        //initializing the textview which shows the problem at first
        TextView textView = (TextView) findViewById(R.id.initial_text);
        tb=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        //initializing the digits and horizontal line
        six = (ImageView) findViewById(R.id.six);
        two = (ImageView) findViewById(R.id.two);
        three = (ImageView) findViewById(R.id.three);
        six_2 = (ImageView) findViewById(R.id.six_2);
        two_2 = (ImageView) findViewById(R.id.two_2);
        three_2 = (ImageView) findViewById(R.id.three_2);
        six_3 = (ImageView) findViewById(R.id.six_3);
        nine = (ImageView) findViewById(R.id.nine);
        five = (ImageView) findViewById(R.id.five);
        two_3 = (ImageView) findViewById(R.id.two_3);
        horizontal_line = (TextView) findViewById(R.id.horizontal_line);
        //Loading the textmove animation which plays at beginning
        Animation initial_text_move = AnimationUtils.loadAnimation(this, R.anim.scale_and_translate);
        initial_text_move.setDuration(1000);
        sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.two_thirty_six_time_eleven);
        sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
        sounds[current_media++].start();
        //setting a listener to start the first number animation on end of this animation
        initial_text_move.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                introduce_first_num();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //starting the animation
        textView.startAnimation(initial_text_move);
        //six.setVisibility(View.VISIBLE);
        //six.startAnimation(number_comes_in);

    }

    public void introduce_first_num() {
        //Initializing the animations for individual digits
        AnimatorSet animatorSet1 = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.first_num_first_dig);
        AnimatorSet animatorSet2 = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.first_num_second_dig);
        AnimatorSet animatorSet3 = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.first_num_third_dig);
        //setting the targets for the animations
        animatorSet1.setTarget(two);
        animatorSet2.setTarget(three);
        animatorSet3.setTarget(six);
        //changing visibility to visible
        two.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        six.setVisibility(View.VISIBLE);
        //creating the animatorSet which plays the digit animations together
        first_num_animator = new AnimatorSet();
        first_num_animator.play(animatorSet1).with(animatorSet2);
        first_num_animator.play(animatorSet2).with(animatorSet3);
        first_num_animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Toast copy_num_toast = new Toast(getBaseContext());
                View toast_view=getLayoutInflater().inflate(R.layout.toastlayout,(ViewGroup)findViewById(R.id.toast_layout_container));
                TextView toast_text = (TextView) toast_view.findViewById(R.id.toast_text);
                toast_text.setText("Step 1: Write down the number..");
                copy_num_toast.setDuration(Toast.LENGTH_SHORT);
                copy_num_toast.setGravity(Gravity.CENTER,0,0);
                copy_num_toast.setView(toast_view);
                copy_num_toast.show();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
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
        //introduce_second_num(first_num_animator);
    }

    public void introduce_second_num() {
        sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.copy_shift_add);
        sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
        sounds[current_media++].start();
        second_num_animator = new AnimatorSet();
        AnimatorSet animatorSet4 = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.second_num_first_dig);
        AnimatorSet animatorSet5 = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.second_num_first_dig);
        AnimatorSet animatorSet6 = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.second_num_first_dig);

        // two_2.setVisibility(View.VISIBLE);
        //three_2.setVisibility(View.VISIBLE);
        // six_2.setVisibility(View.VISIBLE);
        //second_num_animator.setStartDelay(3000);
        animatorSet4.setTarget(two_2);
        animatorSet5.setTarget(three_2);
        animatorSet6.setTarget(six_2);
        //second_num_animator.play(animatorSet4).after(first_num_animator);
        second_num_animator.play(animatorSet4).with(animatorSet5);
        second_num_animator.play(animatorSet5).with(animatorSet6);

        second_num_animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Toast copy_num_toast = new Toast(getBaseContext());
                View toast_view=getLayoutInflater().inflate(R.layout.toastlayout,(ViewGroup)findViewById(R.id.toast_layout_container));
                TextView toast_text = (TextView) toast_view.findViewById(R.id.toast_text);
                toast_text.setText("Step 2: Copy the number below..");
                copy_num_toast.setDuration(Toast.LENGTH_SHORT);
                copy_num_toast.setGravity(Gravity.BOTTOM,-20,0);
                copy_num_toast.setView(toast_view);
                copy_num_toast.show();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                shift_second_num();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        //starting second number animation
        second_num_animator.start();
    }

    public void shift_second_num() {
        AnimatorSet second_num_shift_1 = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.second_num_shifter);
        AnimatorSet second_num_shift_2 = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.second_num_shifter);
        AnimatorSet second_num_shift_3 = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.second_num_shifter);
        second_num_shift_1.setTarget(two_2);
        second_num_shift_2.setTarget(three_2);
        second_num_shift_3.setTarget(six_2);
        shifter = new AnimatorSet();
        //shifter.play(second_num_shift_1).after(second_num_animator);
        shifter.play(second_num_shift_1).with(second_num_shift_2);
        shifter.play(second_num_shift_2).with(second_num_shift_3);
        shifter.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Toast copy_num_toast = new Toast(getBaseContext());
                View toast_view = getLayoutInflater().inflate(R.layout.toastlayout, (ViewGroup) findViewById(R.id.toast_layout_container));
                TextView toast_text = (TextView) toast_view.findViewById(R.id.toast_text);
                toast_text.setText("Step 3: Shift the number right..");
                copy_num_toast.setDuration(Toast.LENGTH_SHORT);
                copy_num_toast.setGravity(Gravity.RIGHT | Gravity.BOTTOM, -20, -20);
                copy_num_toast.setView(toast_view);
                copy_num_toast.show();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //starting horizontal line animation
                horizontal_line.animate().scaleX(1).setDuration(800).setInterpolator(new AccelerateInterpolator()).start();
                //showing the toast of shifting the number
                Toast copy_num_toast = new Toast(getBaseContext());
                View toast_view = getLayoutInflater().inflate(R.layout.toastlayout, (ViewGroup) findViewById(R.id.toast_layout_container));
                TextView toast_text = (TextView) toast_view.findViewById(R.id.toast_text);
                toast_text.setText("Step 4: Now Add the two number!!");
                copy_num_toast.setDuration(Toast.LENGTH_SHORT);
                copy_num_toast.setGravity(Gravity.BOTTOM, -10, 0);
                copy_num_toast.setView(toast_view);
                copy_num_toast.show();
                //calling the method which shows the adding animation
                add();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        shifter.start();
    }

    public void add() {
        six_3.animate().alpha(1).setDuration(2000).setStartDelay(1000).start();
        nine.animate().alpha(1).setStartDelay(3000).setDuration(2000).start();
        five.animate().alpha(1).setStartDelay(5000).setDuration(2000).start();
        two_3.animate().alpha(1).setStartDelay(7000).setDuration(2000).start();

        LinearLayout answer = (LinearLayout) findViewById(R.id.ans);
        Animator show_it= ObjectAnimator.ofFloat(answer,"alpha",1);
        show_it.setStartDelay(7500);
        show_it.setDuration(10);
        show_it.start();
        Animator show_result = ObjectAnimator.ofFloat(answer,"translationX",-60,0);
        show_result.setStartDelay(7500);
        show_result.setDuration(500);
        show_result.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.you_got_answer);
                sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                sounds[current_media].start();
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        show_result.start();
        //adder_animation1.setDuration(2000);
        // six_3.startAnimation(adder_animation1);
       /* adder_animation1.setStartOffset(2010);
        nine.startAnimation(adder_animation1);
        adder_animation1.setStartOffset(4020);
        five.startAnimation(adder_animation1);
        adder_animation1.setStartOffset(6030);
        two_3.startAnimation(adder_animation1); */
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
            Intent i=new Intent(getApplicationContext(),Multiply_2Digit.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
