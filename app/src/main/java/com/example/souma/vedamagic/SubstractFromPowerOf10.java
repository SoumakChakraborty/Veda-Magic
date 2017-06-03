package com.example.souma.vedamagic;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SubstractFromPowerOf10 extends AppCompatActivity {

    ImageView six, nine, one, five, first_nine, second_nine, third_nine, three, eight, zero, five_ans, ten;
    RelativeLayout viewholder;
    float number_height;
    int number,res,first_digit,second_digit,third_digit,fourth_digit;
    int width, height, nine_height,current_media = 0;;
    TextView dash, dash_2, reference;
    boolean already_added = false;
    SubstractFromPowerOf10 object = this;
    MediaPlayer[] sounds = new MediaPlayer[3];
    Toolbar toolbar;
    boolean neutral_pressed=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substract_from_power_of10);
        viewholder = (RelativeLayout) findViewById(R.id.mylayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ap = getSupportActionBar();
        ap.setDisplayHomeAsUpEnabled(true);
        reference = (TextView) findViewById(R.id.reference);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
        getTheNumbers();
    }
        private void getTheNumbers()
        {
        final View input = LayoutInflater.from(this).inflate(R.layout.input_taker_2,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder = builder.setView(input).setTitle("Enter Number:").setMessage("Enter a 4-digit number").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //do {
                EditText second_num_text = (EditText) input.findViewById(R.id.number2);
                number = Integer.parseInt(second_num_text.getText().toString());
                EditText result = (EditText) input.findViewById(R.id.result);
                res = Integer.parseInt(result.getText().toString());
                //  }
                if(getDigit(number)==4) {
                    if (10000-number != res) {
                        Toast.makeText(getBaseContext(), "Please perform correctly", Toast.LENGTH_SHORT).show();
                        getTheNumbers();
                    }
                    else {
                        introduce_the_question();
                    }
                }
                else {
                    Toast.makeText(getBaseContext(), "Please input 4 digit number", Toast.LENGTH_SHORT).show();
                    getTheNumbers();
                }

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        }).setNeutralButton("Default Example", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                neutral_pressed =true;
                number=6195;
                introduce_the_question();
            }
        }).setCancelable(false);
        AlertDialog dialog1 = builder.create();
        dialog1.show();
        //       }
        //   });
    }

    private void introduce_the_question() {
        //six.setX((width-4*six.getWidth())/2);
        sounds[current_media] = MediaPlayer.create(getApplicationContext(),R.raw.tenthousand_minus_something);
        sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
        sounds[current_media++].start();
        final TextView question = new TextView(this);
        question.setText("What is 10000-"+number+"?");
        question.setTextSize(25);
        question.setTextColor(getResources().getColor(R.color.colorPrimary));
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);
        question.setLayoutParams(lp);
        viewholder.addView(question);
                question.animate().x(0).y(0).scaleX(0.5f).scaleY(0.5f).setDuration(2000).setStartDelay(2000).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        introduce_first_num();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();

    }
    private void introduce_first_num() {
        if (neutral_pressed) {
            first_digit = 6;
            second_digit = 1;
            third_digit = 9;
            fourth_digit = 5;
        } else {
            fourth_digit = number % 10;
            number /= 10;
            third_digit = number % 10;
            number /= 10;
            second_digit = number % 10;
            number /= 10;
            first_digit = number % 10;
        }
        six = getView(first_digit);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        six.setId(6);
        six.setLayoutParams(lp);

        one = getView(second_digit);
        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp2.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        lp2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        one.setId(1);
        one.setLayoutParams(lp2);

        nine = getView(third_digit);
        RelativeLayout.LayoutParams lp3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp3.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lp3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        nine.setId(9);
        nine.setLayoutParams(lp3);

        five = getView(fourth_digit);
        RelativeLayout.LayoutParams lp4 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp4.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lp4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        five.setId(5);
        five.setLayoutParams(lp4);

        Log.i("First:",String.valueOf(first_digit));
        Log.i("Second:",String.valueOf(second_digit));
        Log.i("Third:",String.valueOf(third_digit));
        Log.i("Fourth:",String.valueOf(fourth_digit));

        ImageView[] numbers = new ImageView[]{six, one, nine, five};
        for (ImageView digit : numbers)
                viewholder.addView(digit);
        five.post(new Runnable() {
            @Override
            public void run() {
                animate_the_number();
            }
        });

    }
    private void animate_the_number() {

        if (six != null) {
            ObjectAnimator.ofFloat(six, "translationX", (width / 2) - one.getWidth() - six.getWidth()).setDuration(1000).start();
            ObjectAnimator.ofFloat(six, "translationY", reference.getY() - six.getY()).setDuration(1000).start();
        }

        if (one != null) {
            ObjectAnimator.ofFloat(one, "translationX", -(width / 2)).setDuration(1000).start();
            ObjectAnimator.ofFloat(one, "translationY", reference.getY() - one.getY()).setDuration(1000).start();
        }
        if (nine != null) {
            ObjectAnimator.ofFloat(nine, "translationX", width / 2).setDuration(1000).start();
            ObjectAnimator.ofFloat(nine, "translationY", reference.getY() - nine.getY()).setDuration(1000).start();
        }

        ObjectAnimator five_anim=null;
        if (five != null) {
            ObjectAnimator.ofFloat(five, "translationX", -((width / 2) - nine.getWidth() - five.getWidth())).setDuration(1000).start();
             five_anim = ObjectAnimator.ofFloat(five, "translationY", reference.getY() - five.getY()).setDuration(1000);
        }
        five_anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                shift_the_numbers(width, height);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        five_anim.start();
    }

    private void shift_the_numbers(final int width, final int height) {
        nine_height=six.getHeight()*2;
        six.animate().yBy(nine_height).setDuration(700).setInterpolator(new AccelerateInterpolator()).start();
        one.animate().yBy(nine_height).setDuration(700).setInterpolator(new AccelerateInterpolator()).start();
        nine.animate().yBy(nine_height).setDuration(700).setInterpolator(new AccelerateInterpolator()).start();
        five.animate().yBy(nine_height).setDuration(700).setInterpolator(new AccelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.subtract_from_nine_except_rmd);
                sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                sounds[current_media].start();
                if(sounds[current_media-1]!=null) {
                    sounds[current_media - 1].release();
                    sounds[current_media - 1] = null;
                }
                    current_media++;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                seperate_num(width, height);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }

    private void seperate_num(final int width, final int height) {
        six.animate().xBy(-six.getX()).setDuration(1000).setStartDelay(1000).setInterpolator(new DecelerateInterpolator()).start();
        one.animate().xBy(six.getWidth() - one.getX()).setDuration(1000).setStartDelay(1300).setInterpolator(new DecelerateInterpolator()).start();
        nine.animate().xBy((six.getWidth() + one.getWidth()) - nine.getX()).setDuration(1000).setStartDelay(1600).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                introduce_nines(width, height);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).setInterpolator(new DecelerateInterpolator()).start();
    }

    private void introduce_nines(int width, int hieght) {
        LayoutTransition layouttransition = new LayoutTransition();
        viewholder.setLayoutTransition(layouttransition);

        Toast toast= new Toast(this);
        View view = getLayoutInflater().inflate(R.layout.toastlayout,(ViewGroup)findViewById(R.id.toast_layout_container));
        TextView text = (TextView) view.findViewById(R.id.toast_text);
        text.setText("Subtract each digit from 9 except last");
        toast.setGravity(Gravity.CENTER,0,30);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

        first_nine = new ImageView(this);
        first_nine.setImageResource(R.drawable.nine);
        first_nine.setId(91);
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        Log.i("new X of six:", String.valueOf(six.getX()));

        layoutparams.setMargins(0, six.getHeight() * 2, 0, six.getHeight());
        viewholder.addView(first_nine, layoutparams);

        second_nine = new ImageView(this);
        second_nine.setImageResource(R.drawable.nine);
        second_nine.setId(92);
        viewholder.addView(second_nine, layoutparams);

        second_nine.animate().translationXBy(one.getX() - six.getX()).setDuration(1000).setStartDelay(300).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                third_nine = new ImageView(getApplicationContext());
                third_nine.setImageResource(R.drawable.nine);
                third_nine.setId(93);
                RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                layoutparams.setMargins((int) (one.getX() - six.getX()), six.getHeight() * 2, 0, six.getHeight());
                viewholder.addView(third_nine, layoutparams);
                third_nine.animate().translationXBy(nine.getX() - one.getX()).setDuration(1000).setStartDelay(300).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        introduce_ten();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }

    private void introduce_ten() {
        Toast toast= new Toast(this);
        View view = getLayoutInflater().inflate(R.layout.toastlayout,(ViewGroup)findViewById(R.id.toast_layout_container));
        TextView text = (TextView) view.findViewById(R.id.toast_text);
        text.setText("Subtract last digit from 10");
        toast.setGravity(Gravity.CENTER,-20,0);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

        ten = new ImageView(getApplicationContext());
        ten.setImageResource(R.drawable.ten);
        ten.setId(10);
        RelativeLayout.LayoutParams layoutparams2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutparams2.setMargins((int) five.getX(), six.getHeight() * 2, 0, six.getHeight());
        viewholder.addView(ten, layoutparams2);
        introduce_dashes();
    }

    private void introduce_dashes() {
        if (!already_added) {

            dash = new TextView(this);
            dash.setText("________________________________________");
            dash.setId(123);
            dash.setTextSize(10f);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0,(int)six.getY()+2*six.getHeight(),0,0);
            dash.setScaleX(0.001f);
            viewholder.addView(dash, lp);
            already_added = true;
            dash.animate().scaleX(2.0f).setStartDelay(300).setDuration(1000).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    introduce_second_dash();
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
            }).start();
        }
    }

    private void introduce_second_dash() {
        dash_2 = new TextView(this);
        dash_2.setText("______________");
        dash_2.setId(456);
        dash_2.setTextSize(10f);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_2.setMargins((int) (five.getX()), (int)six.getY()+six.getHeight()*2, 0, 0);
        dash_2.setScaleX(0.001f);
        viewholder.addView(dash_2, lp_2);
        dash_2.animate().scaleX(2.0f).setStartDelay(300).setDuration(1000).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                introduce_answer();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }

    private void introduce_answer() {
        three = getView(9-first_digit);
        RelativeLayout.LayoutParams lp_3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_3.addRule(RelativeLayout.BELOW, 123);
        lp_3.addRule(RelativeLayout.ALIGN_LEFT, 91);
        three.setLayoutParams(lp_3);
        three.setScaleX(5);
        three.setScaleY(5);
        three.setVisibility(View.INVISIBLE);
        viewholder.addView(three);
        three.setVisibility(View.VISIBLE);
        ObjectAnimator.ofFloat(three, "scaleX", 1f).setDuration(800).start();
        ObjectAnimator anim = ObjectAnimator.ofFloat(three, "scaleY", 1f).setDuration(800);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                introduce_eight();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        anim.start();
    }

    private void introduce_eight() {
        eight = getView(9-second_digit);
        RelativeLayout.LayoutParams lp_4 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_4.addRule(RelativeLayout.BELOW, 123);
        lp_4.addRule(RelativeLayout.ALIGN_LEFT, 93);
        eight.setLayoutParams(lp_4);
        eight.setScaleX(5);
        eight.setScaleY(5);
        eight.setVisibility(View.INVISIBLE);
        viewholder.addView(eight);
        eight.setId(8);
        eight.setVisibility(View.VISIBLE);
        ObjectAnimator.ofFloat(eight, "scaleX", 1f).setDuration(800).start();
        ObjectAnimator anim = ObjectAnimator.ofFloat(eight, "scaleY", 1f).setDuration(800);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                introduce_zero();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        anim.start();
    }

    private void introduce_zero() {
        zero = getView(9-third_digit);
        //zero.setImageResource(R.drawable.zero);
        RelativeLayout.LayoutParams lp_5 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_5.addRule(RelativeLayout.BELOW, 123);
        lp_5.addRule(RelativeLayout.RIGHT_OF, 8);
        lp_5.setMargins((int) (third_nine.getX() - second_nine.getX() - eight.getWidth()), 0, 0, 0);
        //lp_3.setMargins(0,six.getHeight()*5,0,0);
        zero.setLayoutParams(lp_5);
        zero.setScaleX(5);
        zero.setScaleY(5);
        zero.setVisibility(View.INVISIBLE);
        viewholder.addView(zero);
        zero.setVisibility(View.VISIBLE);
        ObjectAnimator.ofFloat(zero, "scaleX", 1f).setDuration(800).start();
        ObjectAnimator anim = ObjectAnimator.ofFloat(zero, "scaleY", 1f).setDuration(800);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                introduce_five();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        anim.start();
    }

    private void introduce_five() {
        five_ans = getView(10-fourth_digit);
        RelativeLayout.LayoutParams lp_6 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_6.addRule(RelativeLayout.BELOW, 456);
        lp_6.addRule(RelativeLayout.ALIGN_LEFT, 10);
        five_ans.setLayoutParams(lp_6);
        five_ans.setScaleX(5);
        five_ans.setScaleY(5);
        five_ans.setVisibility(View.INVISIBLE);
        viewholder.addView(five_ans);
        five_ans.setVisibility(View.VISIBLE);
        five_ans.animate().scaleX(1).scaleY(1).setDuration(800).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                pre_final_animation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }

    private void pre_final_animation() {
        three.animate().translationXBy((width / 2) - three.getX() - eight.getWidth() - three.getWidth()).translationYBy((height / 2) - three.getY()).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(500).start();
        eight.animate().translationXBy((width / 2) - eight.getX() - eight.getWidth()).translationYBy((height / 2) - eight.getY()).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(500).start();
        zero.animate().translationXBy((width / 2) - zero.getX()).translationYBy((height / 2) - zero.getY()).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(500).start();
        five_ans.animate().translationXBy((width / 2) - five_ans.getX() + zero.getWidth()).translationYBy((height / 2) - five_ans.getY()).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(500).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.you_got_answer);
                sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                sounds[current_media].start();
                if(sounds[current_media-1]!=null) {
                    sounds[current_media - 1].release();
                    sounds[current_media - 1] = null;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                final_aniamtion();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }

    private void final_aniamtion() {

        Toast toast= new Toast(this);
        View view = getLayoutInflater().inflate(R.layout.toastlayout,(ViewGroup)findViewById(R.id.toast_layout_container));
        TextView text = (TextView) view.findViewById(R.id.toast_text);
        text.setText("Here is you answer!");
        toast.setGravity(Gravity.BOTTOM,-10,-10);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

        five_ans.animate().setListener(null);
        three.animate().scaleX(2).scaleY(2).setDuration(1000).setInterpolator(new OvershootInterpolator()).start();
        eight.animate().scaleX(2).scaleY(2).setDuration(1000).setInterpolator(new OvershootInterpolator()).start();
        zero.animate().scaleX(2).scaleY(2).setDuration(1000).setInterpolator(new OvershootInterpolator()).start();
        five_ans.animate().scaleX(2).scaleY(2).setDuration(1000).setInterpolator(new OvershootInterpolator()).start();
        Toast.makeText(getApplicationContext(), "Thats all!", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onStop() {
        super.onStop();
        if(sounds[current_media]!=null) {
            if (sounds[current_media].isPlaying()) {
                sounds[current_media].release();
                sounds[current_media] = null;
            }
        }
        if(sounds[current_media-1]!=null)
        {
            if(sounds[current_media-1].isPlaying())
            {
                sounds[current_media-1].release();
                sounds[current_media-1] = null;
            }
        }
        //this.finish();
    }
    private int getDigit(int num)
    {
        int digit=0;
        while(num!=0)
        {
            num/=10;
            digit++;
        }
        return digit;
    }
    private ImageView getView(int num)
    {
        ImageView imageView=null;
        switch(num)
        {
            case 1: imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.one);
                break;
            case 2: imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.two);
                break;
            case 3: imageView= new ImageView(this);
                imageView.setImageResource(R.drawable.three);
                break;
            case 4: imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.four);
                break;
            case 5: imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.five);
                break;
            case 6: imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.six);
                break;
            case 7: imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.seven);
                break;
            case 8: imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.eight);
                break;
            case 9: imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.nine);
                break;
            case 0: imageView= new ImageView(this);
                imageView.setImageResource(R.drawable.zero);
                break;
            default: Log.i("Something went wrong","Image not created");
                imageView=null;
        }
        return imageView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Log.i("Current_media:",String.valueOf(current_media));
        if(sounds[current_media-1].isPlaying()) {
            sounds[current_media - 1].stop();
            sounds[current_media - 1].release();
            sounds[current_media - 1] = null;
        }
        Intent intent = new Intent(this,MenuActivity.class);
        super.onBackPressed();
    }
}
