package com.example.souma.vedamagic;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MultiplyBy5 extends AppCompatActivity {

    ImageView four,eight,five,five_2,one,two,multiply,three,two_2,six,plus,five_3,three_3,eight_3,five_4,multiply_2,one_2,one_3,two_3,four_2,five_5,plus_2,two_6;
    TextView dummy,dash,sum_label,product_label,answer,dash_2,answer_2,sum_label_2,product_label_2;
    View divider,sum,product,sum_2,product_2;
    RelativeLayout main_content,drawer;
    DrawerLayout drawerLayout;
    int width,height,current_media=0,first_num,second_num,res,add,mul;
    ValueAnimator sign_animate;
    LayoutTransition lt;
    MediaPlayer mediaPlayer;
    Toolbar toolbar;
    MediaPlayer[] sounds=new MediaPlayer[9];
    boolean neutral_pressed=false;
    ActionBar ap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiply_by5);
        //Turn mext line on if u want ur status bar to overlap the toolbar
       // getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ap = getSupportActionBar();
        ap.setTitle("Ending with 5");
        ap.setSubtitle("*Even Sum*");
        ap.setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.mother);
        main_content = (RelativeLayout) drawerLayout.findViewById(R.id.holder);
        ImageView prof_pic = (ImageView)drawerLayout.findViewById(R.id.prof_pic);
        prof_pic.setClipToOutline(true);
        drawer= (RelativeLayout)drawerLayout.findViewById(R.id.drawer);
        dummy = (TextView)findViewById(R.id.dummy);
        divider=findViewById(R.id.divider);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width=displayMetrics.widthPixels;
        height=displayMetrics.heightPixels;
        getTheNumbers();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==R.id.skip)
        {
            Intent i=new Intent(getApplicationContext(),Multiply11.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
    private void getTheNumbers() {
        final View input = LayoutInflater.from(this).inflate(R.layout.input_taker,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder = builder.setView(input).setTitle("Enter Number:").setMessage("Enter two 2-digit numbers that ends with 5").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //do {
                    EditText first_num_text = (EditText) input.findViewById(R.id.number1);
                    first_num = Integer.parseInt(first_num_text.getText().toString());
                    EditText second_num_text = (EditText) input.findViewById(R.id.number2);
                    second_num = Integer.parseInt(second_num_text.getText().toString());
                    EditText result = (EditText) input.findViewById(R.id.result);
                    res = Integer.parseInt(result.getText().toString());
              //  }
                if((first_num%10==5) && (second_num%10==5) && (first_num>=15) && (first_num<=95) && (second_num<=95) && (second_num>=15)) {
                    if (first_num * second_num != res) {
                        Toast.makeText(getBaseContext(), "Please perform correctly", Toast.LENGTH_SHORT).show();
                        getTheNumbers();
                    }
                    else {
                        add= first_num/10 + second_num /10;
                        mul=(first_num/10)*(second_num/10);
                        if(add%2==0)
                        introduce_number();
                        else
                            second_part();
                    }
                }
                else {
                    Toast.makeText(getBaseContext(), "Wrong input,try again!", Toast.LENGTH_SHORT).show();
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
                introduce_number();
            }
        }).setCancelable(false);
        AlertDialog dialog1 = builder.create();
        dialog1.show();
    }
    private void introduce_number()
    {
        //adding 5 of 45
        //Log.i("called","introduce_number()");
        if(neutral_pressed)
        {
            first_num=45;
            second_num=85;
            add=12;
            mul=32;
        }
        five = new ImageView(this);
        five.setImageResource(R.drawable.five);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_TOP,dummy.getId());
        //lp.addRule(RelativeLayout.ALIGN_LEFT,dummy.getId());
        lp.setMargins(width/4,0,0,0);
        five.setLayoutParams(lp);
        five.setId(5);
        five.setScaleX(0.001f);
        five.setScaleY(0.001f);
        //main_content.addView(five);
        //adding 4 of 45
        int lmd_first_num = first_num/10;
        ImageView four = getView(lmd_first_num);

        four = getView(first_num/10);
        //four.setImageResource(R.drawable.four);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_2.addRule(RelativeLayout.ALIGN_TOP,5);
        //lp_2.addRule(RelativeLayout.LEFT_OF,5);
        Log.i("width of 4:",String.valueOf(four.getWidth()));
        lp_2.setMargins((int)(width/4)-65,0,0,0);
        four.setLayoutParams(lp_2);
        four.setId(4);
        four.setScaleY(0.001f);
        four.setScaleX(0.001f);
        //main_content.addView(four);
        //adding 8 of 85
        eight = getView(second_num/10);
        //eight.setImageResource(R.drawable.eight);
        RelativeLayout.LayoutParams lp_3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_3.addRule(RelativeLayout.BELOW,4);
        lp_3.addRule(RelativeLayout.ALIGN_LEFT,4);
        eight.setLayoutParams(lp_3);
        eight.setId(8);
        eight.setScaleY(0.001f);
        eight.setScaleX(0.001f);
        //main_content.addView(eight);
        //adding 5 of 85
        five_2 = new ImageView(this);
        five_2.setImageResource(R.drawable.five);
        RelativeLayout.LayoutParams lp_4 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_4.addRule(RelativeLayout.BELOW,5);
        lp_4.addRule(RelativeLayout.ALIGN_LEFT,5);
        lp_4.addRule(RelativeLayout.ALIGN_TOP,8);
        //lp.addRule(RelativeLayout.ALIGN_LEFT,dummy.getId());
        five_2.setLayoutParams(lp_4);
        five_2.setId(52);
        five_2.setScaleY(0.001f);
        five_2.setScaleX(0.001f);
        //main_content.addView(five_2);
        //adding views
        if(neutral_pressed) {
            sounds[current_media] = MediaPlayer.create(getApplicationContext(), R.raw.fortyfive_eightyfive);
            sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
            sounds[current_media++].start();
        }
        AnimatorSet anim1 = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.first_num_first_dig);
        anim1.setTarget(four);
        AnimatorSet anim2 = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.first_num_first_dig);
        anim2.setTarget(eight);
        AnimatorSet first_nums_animator = new AnimatorSet();
        first_nums_animator.setStartDelay(300);

        main_content.addView(five); main_content.addView(four); main_content.addView(eight); main_content.addView(five_2);

        first_nums_animator.playTogether(anim1,anim2);
        first_nums_animator.start();

        five.animate().scaleX(1).scaleY(1).setInterpolator(new OvershootInterpolator()).setDuration(2000).setStartDelay(300).start();
        five_2.animate().scaleX(1).scaleY(1).setInterpolator(new OvershootInterpolator()).setDuration(2000).setStartDelay(300).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                seperate_fives();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        }).start();
        //System.out.println("divider:"+divider.getX()+"five:"+five.getX());
    }
    private void seperate_fives()
    {
        //Toast.makeText(this,String.valueOf(five.getWidth()+"and"+five.getX()),Toast.LENGTH_SHORT).show();
        five.animate().x(width/2-five.getWidth()).setDuration(600).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                add_first_digits();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        }).start();
        five_2.animate().setListener(null).x(width/2-five_2.getWidth()).setDuration(600).setStartDelay(400).setInterpolator(new DecelerateInterpolator()).start();
    }
private void add_first_digits()
{
    dash = new TextView(this);
    dash.setText("________________________________________");
    dash.setId(123);
    dash.setTextSize(10f);
    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    lp.setMargins(0,five.getHeight()*3, 0, 0);
    dash.setScaleX(0.001f);
    main_content.addView(dash, lp);
    dash.animate().scaleX(0.5f).setStartDelay(300).setDuration(1000).start();
    //adding the addition sign
    multiply = new ImageView(this);
    multiply.setImageResource(R.drawable.multiply);
    RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(eight.getWidth(), eight.getHeight());
    lp_2.addRule(RelativeLayout.LEFT_OF,8);
    lp_2.addRule(RelativeLayout.ALIGN_TOP,8);
    multiply.setLayoutParams(lp_2);
    multiply.setScaleX(0.8f);
    multiply.setScaleY(0.8f);
    multiply.setRotation(45);
    main_content.addView(multiply);

    sign_animate = ValueAnimator.ofFloat(0.8f,0.6f);
    sign_animate.setDuration(300);
    sign_animate.setRepeatMode(ValueAnimator.REVERSE);
    sign_animate.setRepeatCount(5);
    sign_animate.setStartDelay(400);
    sign_animate.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            multiply.setScaleX(animation.getAnimatedFraction());
            multiply.setScaleY(animation.getAnimatedFraction());
        }
    });
    sign_animate.addListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
            sum_answer();
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            multiply.setScaleX(0.9f);
            multiply.setScaleY(0.9f);
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    });
    sign_animate.start();
}
private void sum_answer()
{
    int digit=getDigit(add);
    if(digit==2)
        one = getView(add / 10);
    else
        one = getView(add);
    //one.setImageResource(R.drawable.one);
    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    lp.addRule(RelativeLayout.BELOW,123);
    lp.addRule(RelativeLayout.ALIGN_LEFT,8);
    one.setLayoutParams(lp);
    one.setScaleX(5);
    one.setScaleY(5);
    one.setVisibility(View.INVISIBLE);
    main_content.addView(one);
    one.setId(1);
    one.setVisibility(View.VISIBLE);
    ObjectAnimator.ofFloat(one, "scaleX", 1f).setDuration(1000).start();

    sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.add_left_most_digits);
    sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
    sounds[current_media].start();
    if(neutral_pressed) {
        sounds[current_media - 1].release();
        sounds[current_media - 1] = null;
    }
    current_media++;

    ObjectAnimator anim = ObjectAnimator.ofFloat(one, "scaleY", 1f).setDuration(1000);
    anim.addListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {

            if(getDigit(add)==2)
                add_two();
            else
                is_even_or_odd();
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
private void add_two(){
    two = getView(add%10);
    //two.setImageResource(R.drawable.two);
    RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    lp_2.addRule(RelativeLayout.BELOW,123);
    lp_2.addRule(RelativeLayout.ALIGN_TOP,1);
    lp_2.addRule(RelativeLayout.RIGHT_OF,1);
    two.setLayoutParams(lp_2);
    two.setScaleX(5);
    two.setScaleY(5);
    //two.setVisibility(View.INVISIBLE);
    main_content.addView(two);
    two.setId(2);
    ObjectAnimator two_scaleX = ObjectAnimator.ofFloat(two, "scaleX", 1f).setDuration(1000);
    two_scaleX.start();
    ObjectAnimator two_scaleY = ObjectAnimator.ofFloat(two, "scaleY", 1f).setDuration(1000);
    two_scaleY.addListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

    }

        @Override
        public void onAnimationEnd(Animator animation) {
            is_even_or_odd();
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    });
    two_scaleY.start();
    }
    private void is_even_or_odd()
    {
        if(sign_animate.isRunning())
            sign_animate.end();
        Toast toast= new Toast(this);
        View view = getLayoutInflater().inflate(R.layout.toastlayout,(ViewGroup)findViewById(R.id.toast_layout_container));
        TextView text = (TextView) view.findViewById(R.id.toast_text);
        text.setText("EVEN ! So, 25 will be the last two digits of the answer!");
        toast.setGravity(Gravity.CENTER,-20,0);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();


        answer = new TextView(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(width/2,eight.getHeight());
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        //lp.setMargins(((width/2)-eight.getWidth()*4)/2,0,0,0);
        answer.setBackground(getResources().getDrawable(R.drawable.textbox));
        answer.setPadding(2,0,0,2);
        answer.setLayoutParams(lp);
        answer.setAlpha(0);
        answer.setId(200);
        answer.setTextColor(getResources().getColor(R.color.abc_primary_text_material_light));
        answer.setHint("ANSWER");
        answer.setTextSize(40);
        answer.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        main_content.addView(answer);

        TextView label = new TextView(this);
        label.setText("Answer:");
        label.setTextSize(20);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_2.addRule(RelativeLayout.ABOVE,200);
        lp_2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        label.setLayoutParams(lp_2);
        main_content.addView(label);

        answer.animate().alpha(1).setDuration(3000).setStartDelay(300).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.twenty_five_right_most_digit);
                sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                sounds[current_media].start();
                sounds[current_media-1].release();
                sounds[current_media-1]=null;
                current_media++;

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                answer.setText(getResources().getString(R.string.twentyfive));
                add_25();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }
    private void add_25()
    {
        sum = new View(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(five.getWidth()*2,five.getHeight());
        sum.setBackground(getResources().getDrawable(R.drawable.sum_product_box));
        sum.setId(100);
        lp.addRule(RelativeLayout.CENTER_VERTICAL);
        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        sum.setLayoutParams(lp);
        sum.setScaleX(0.01f);
        main_content.addView(sum);

        sum_label = new TextView(this);
        sum_label.setText("Sum:");
        sum_label.setTextSize(20);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_2.addRule(RelativeLayout.ABOVE,100);
        lp_2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        sum_label.setLayoutParams(lp_2);
        main_content.addView(sum_label);

        sum.animate().scaleX(1).setDuration(1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                one.bringToFront();
                if(two!=null)
                    two.bringToFront();
                one.animate().xBy(-one.getX()).y(sum.getY()).setDuration(1000).setInterpolator(new AnticipateInterpolator()).start();
                if(two!=null)
                    two.animate().xBy(-two.getX() + one.getWidth()).y(sum.getY()).setDuration(1000).setStartDelay(400).setInterpolator(new AnticipateInterpolator()).start();

            }
        }).start();

        multiply.animate().rotationBy(45).setStartDelay(2200).setDuration(1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                ValueAnimator val = ValueAnimator.ofFloat(0.9f,0.6f);
                val.setDuration(600);
                val.setRepeatCount(4);
                val.setRepeatMode(ValueAnimator.REVERSE);
                val.setInterpolator(new AccelerateDecelerateInterpolator());
                val.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        multiply.setScaleX(animation.getAnimatedFraction());
                        multiply.setScaleY(animation.getAnimatedFraction());
                    }
                });
                val.start();
                multiply_ans();
            }
        }).start();
    }
    private void multiply_ans()
    {
        if(getDigit(mul)==2)
            three = getView(mul/10);
        else
            three=getView(mul);
        //three.setImageResource(R.drawable.three);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW,123);
        lp.addRule(RelativeLayout.ALIGN_LEFT,8);
        three.setLayoutParams(lp);
        three.setScaleX(5);
        three.setScaleY(5);
        three.setVisibility(View.INVISIBLE);
        main_content.addView(three);
        three.setId(3);
        three.setVisibility(View.VISIBLE);
        ObjectAnimator.ofFloat(three, "scaleX", 1f).setDuration(1000).start();
        ObjectAnimator anim = ObjectAnimator.ofFloat(three, "scaleY", 1f).setDuration(1000);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.multiply_them);
                sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                sounds[current_media].start();
                sounds[current_media-1].release();
                sounds[current_media-1]=null;
                current_media++;

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(getDigit(mul)==2)
                introduce_two();
                else
                    place_product();
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
    private void introduce_two()
    {
        two_2 = getView(mul%10);
        //two_2.setImageResource(R.drawable.two);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_2.addRule(RelativeLayout.BELOW,123);
        lp_2.addRule(RelativeLayout.ALIGN_TOP,3);
        lp_2.addRule(RelativeLayout.RIGHT_OF,3);
        two_2.setLayoutParams(lp_2);
        two_2.setScaleX(5);
        two_2.setScaleY(5);
        //two.setVisibility(View.INVISIBLE);
        main_content.addView(two_2);
        two_2.setId(22);
        ObjectAnimator two_scaleX = ObjectAnimator.ofFloat(two_2, "scaleX", 1f).setDuration(1000);
        two_scaleX.start();
        ObjectAnimator two_scaleY = ObjectAnimator.ofFloat(two_2, "scaleY", 1f).setDuration(1000);
        two_scaleY.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                place_product();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        two_scaleY.start();
    }
    private void place_product()
    {
        product_label = new TextView(this);
        product_label.setText("Product:");
        product_label.setTextSize(20);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_2.addRule(RelativeLayout.BELOW,sum.getId());
        lp_2.addRule(RelativeLayout.LEFT_OF,divider.getId());
        product_label.setLayoutParams(lp_2);
        product_label.setId(400);
        main_content.addView(product_label);

        product = new View(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(five.getWidth()*2,five.getHeight());
        product.setBackground(getResources().getDrawable(R.drawable.sum_product_box));
        product.setId(300);
        lp.addRule(RelativeLayout.BELOW,400);
        lp.addRule(RelativeLayout.LEFT_OF,divider.getId());
        product.setLayoutParams(lp);
        product.setScaleX(0.01f);
        main_content.addView(product);
        product.animate().scaleX(1).setDuration(1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                three.bringToFront();
                if(two_2!=null)
                two_2.bringToFront();
                if(two_2!=null) {
                    two_2.animate().xBy(width / 2 - two_2.getX() - two_2.getWidth()).y(product.getY()).setDuration(1000).setInterpolator(new AnticipateInterpolator()).start();
                    three.animate().xBy(width / 2 - two_2.getWidth() - three.getWidth() - three.getX()).y(product.getY()).setDuration(1000).setStartDelay(400).setInterpolator(new AnticipateInterpolator()).start();
                }
                else
                    three.animate().xBy(width / 2 - three.getX() - three.getWidth()).y(product.getY()).setDuration(1000).setInterpolator(new AnticipateInterpolator()).start();
                shift_sum_and_product();
            }
        }).start();
    }
    private void shift_sum_and_product()
    {
        sum_label.setZ(sum.getZ()-1);
        sum_label.animate().translationYBy(sum_label.getHeight()).setDuration(1000).setStartDelay(1200).withEndAction(new Runnable() {
            @Override
            public void run() {
                sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.divide_sum_by_two);
                sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                sounds[current_media].start();
                sounds[current_media-1].release();
                sounds[current_media-1]=null;
                current_media++;

                sum_label.setText("Sum / 2:");
                sum_label.animate().yBy(-sum_label.getHeight()).setDuration(700).start();
                sumByTwo();
            }
        }).start();
    }
    private void sumByTwo()
    {
        final View hiding_view = new View(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(five.getWidth()*(3/2),sum.getHeight());
        lp.addRule(RelativeLayout.RIGHT_OF,sum.getId());
        lp.addRule(RelativeLayout.ALIGN_TOP,sum.getId());
        hiding_view.setLayoutParams(lp);
        hiding_view.setId(440);
        hiding_view.setBackgroundColor(Color.WHITE);
        main_content.addView(hiding_view);
        if(two!=null)
            two.animate().translationXBy(sum.getWidth()-two.getX()).setDuration(1000).setStartDelay(1200).start();
        one.animate().translationXBy(sum.getWidth()-one.getX()).setDuration(1000).setStartDelay(1400).withEndAction(new Runnable() {
            @Override
            public void run() {
                bring_six(hiding_view);



                /* six.animate().translationXBy(-sum.getWidth()/2).setDuration(1500).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.i("height/2:",String.valueOf(height/2));
                        Log.i("Hiding View's top:",String.valueOf(hiding_view.getY()));
                        Log.i("Six's Y:",String.valueOf(six.getY()));
                        Log.i("hiding view top:",String.valueOf(hiding_view.getTop()));
                        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams)six.getLayoutParams();
                        lp.leftMargin=sum.getWidth()/2;
                        //lp.rightMargin=width-(sum.getWidth()/2+eight.getWidth());
                        six.setLayoutParams(lp);
                        main_content.removeView(hiding_view);
                        move_to_add();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();
            }
        }).start();
    }
    private void move_to_add()
    {


        if(six!=null)
            six.animate().setListener(null).translationXBy(width/4-(sum.getX()+sum.getWidth()/2)).translationYBy(-eight_height/2).setStartDelay(1500).setDuration(1000).withEndAction(new Runnable() {
               @Override
               public void run() {
                   RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(sum_width/2,sum_height);
                   lp.setMargins(width/4,height/2-eight_height/2,width/4+eight.getWidth(),height/2-six.getHeight()+eight.getHeight()/2);
                   six.setLayoutParams(lp);
               }
           }).start();
      /*  {
            TranslateAnimation six_x = new TranslateAnimation(Animation.ABSOLUTE,six.getX(),Animation.ABSOLUTE,width/4-eight.getWidth()/2,Animation.ABSOLUTE,six.getY(),Animation.ABSOLUTE,six.getY()-eight.getHeight()/2);
            six_x.setDuration(1000);
            six_x.setStartOffset(1500);
            six_x.setFillAfter(true);
            six_x.setFillEnabled(true);
            six.startAnimation(six_x);
        }


    }
    private void add_the_final_ans()
    {
        ValueAnimator anim = ValueAnimator.ofFloat(1.0f,2.0f);
        anim.setDuration(400);
        anim.setRepeatCount(10);
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                plus.setScaleX(animation.getAnimatedFraction());
                plus.setScaleY(animation.getAnimatedFraction());
            }
        });
        anim.start();


    } */
}
private void bring_six(View hiding_view)
{
    six = getView(add/2);
    //six.setImageResource(R.drawable.six);
    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(eight.getWidth(), eight.getHeight());
    lp.addRule(RelativeLayout.ALIGN_LEFT, 440);
    lp.addRule(RelativeLayout.CENTER_VERTICAL);
    six.setLayoutParams(lp);
    //six.setZ((float)(hiding_view.getZ()-.1));
    six.setVisibility(View.INVISIBLE);
    main_content.addView(six);
    if(two!=null)
    main_content.removeView(two);
    if(one!=null)
    main_content.removeView(one);
    hiding_view.bringToFront();
    six.setVisibility(View.VISIBLE);
    animate_everything();
}
private void animate_everything()
{
    final int eight_height=five.getHeight();
    final int sum_width =sum.getWidth();
    final int sum_height=sum.getHeight();

    ObjectAnimator six_x = ObjectAnimator.ofFloat(six,"x",sum.getWidth(),sum.getWidth() / 2);
    six_x.setDuration(1500);
    six_x.setStartDelay(200);
    six_x.setInterpolator(new AccelerateDecelerateInterpolator());
    six_x.addListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            main_content.removeView(hiding_view);
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    });
    ObjectAnimator six_right = ObjectAnimator.ofFloat(six, "x",sum.getWidth()/2,width/4);
    six_right.setInterpolator(new AccelerateDecelerateInterpolator());
    six_right.setDuration(1000);
    AnimatorSet anim = new AnimatorSet();
    anim.playSequentially(six_x, six_right);

    if(sum!=null)
        sum.animate().translationX(width/4-sum.getWidth()/2).alpha(0f).setStartDelay(1500).setDuration(1000).start();
    anim.start();
    if(sum_label!=null)
        sum_label.animate().translationX(width/4-(sum.getX()+sum.getWidth()/2)).alpha(0f).setStartDelay(1500).setDuration(1000).start();
    if(product!=null)
        product.animate().translationXBy(width/4-(product.getX()+product.getWidth()/2)).translationYBy(eight_height/2).alpha(0f).setStartDelay(1500).setDuration(1000).start();
    if(three!=null)
        three.animate().translationXBy(width/4-(product.getX()+product.getWidth()/2)).translationYBy(eight_height/2).setStartDelay(1500).setDuration(1000).start();
    if(two_2!=null)
        two_2.animate().translationXBy(width/4-(product.getX()+product.getWidth()/2)).translationYBy(eight_height/2).setStartDelay(1500).setDuration(1000).start();
    if(product_label!=null)
        product_label.animate().translationXBy(width/4-(product.getX()+product.getWidth()/2)).translationYBy(eight_height/2).alpha(0f).setStartDelay(1500).setDuration(1000).withStartAction(new Runnable() {
            @Override
            public void run() {

                sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.add_sum_and_product);
                sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                sounds[current_media].start();
                sounds[current_media-1].release();
                sounds[current_media-1]=null;
                current_media++;

                plus = new ImageView(getApplicationContext());
                plus.setImageResource(R.drawable.plus);
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(width/4,(int)sum.getY()+sum.getHeight(),0,0);
                plus.setLayoutParams(lp);
                plus.setAlpha(0f);
                main_content.addView(plus);
                ObjectAnimator.ofFloat(plus,"alpha",1).setDuration(2000).start();
            }
        }).withEndAction(new Runnable() {
            @Override
            public void run() {
                main_content.removeView(sum);
                main_content.removeView(sum_label);
                main_content.removeView(product);
                main_content.removeView(product_label);
                bring_dash();
            }
        }).start();
}}).start();
}
private void bring_dash()
{
    dash.animate().setListener(null).translationYBy(three.getY()+three.getHeight()-dash.getY()).rotationBy(360).setDuration(800).setInterpolator(new OvershootInterpolator()).start();
    multiply.animate().alpha(0).setDuration(400).withEndAction(new Runnable() {
        @Override
        public void run() {
            main_content.removeView(multiply);
            bring_thirty_eight();
        }
    }).start();

}
private void bring_thirty_eight()
{
    final ImageView eight_2,three_2;
    Animator anim = AnimatorInflater.loadAnimator(this,R.animator.appear);
    lt = new LayoutTransition();
    lt.setAnimator(LayoutTransition.APPEARING,anim);
    main_content.setLayoutTransition(lt);

    int last_num=add/2+mul;

    eight_2 = getView(last_num%10);
    //eight_2.setImageResource(R.drawable.eight);
    RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(five.getWidth(),five.getHeight());
    lp_2.setMargins((int)six.getX(),(int)three.getY()+three.getHeight()+dash.getHeight(),0,0);
    eight_2.setLayoutParams(lp_2);
    eight_2.setId(82);
    eight_2.setScaleX(0f);
    eight_2.setScaleY(0f);
    main_content.addView(eight_2);

    if(getDigit(last_num)==2)
    {
        eight_2.post(new Runnable() {
            @Override
            public void run() {

            }
        });

        three_2 = getView(last_num / 10);
        //three_2.setImageResource(R.drawable.three);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(five.getWidth(), five.getHeight());
        lp.setMargins((int) six.getX()-five.getWidth(), (int) three.getY() + three.getHeight() + dash.getHeight(), 0, 0);
        three_2.setLayoutParams(lp);
        three_2.setId(32);
        three_2.setScaleX(0f);
        three_2.setScaleY(0f);
        main_content.addView(three_2);
    }
    else
        three_2=null;

    if(three_2!=null) {
        three_2.post(new Runnable() {
            @Override
            public void run() {
                three_2.animate().translationX(answer.getX() - three_2.getX()).translationYBy(answer.getY() - three_2.getY()).rotationXBy(360).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(600).setStartDelay(3000).start();
            }
        });
    }
    eight_2.post(new Runnable() {
        @Override
        public void run() {
            eight_2.animate().translationXBy(answer.getX()+three.getWidth()-eight_2.getX()).translationYBy(answer.getY()-eight_2.getY()).rotationXBy(360).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(600).setStartDelay(3000).withEndAction(new Runnable() {
                @Override
                public void run() {
                    answer.setText(String.valueOf(first_num*second_num));
                    if(three_2!=null)
                    main_content.removeView(three_2);
                    main_content.removeView(eight_2);

                }
            }).start();
            sounds[current_media] = MediaPlayer.create(getApplicationContext(), R.raw.append_before_25);
            sounds[current_media + 1] = MediaPlayer.create(getApplicationContext(), R.raw.you_got_answer);
            sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
            sounds[current_media].setNextMediaPlayer(sounds[current_media + 1]);
            sounds[current_media].start();
            sounds[current_media - 1].release();
            sounds[current_media - 1] = null;
            sounds[current_media+1].setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if(neutral_pressed)
                    {
                        first_num=35;
                        second_num=85;
                        add=11;
                        mul=24;
                        second_part();
                    }
            }
        });
    }});

    Toast toast= new Toast(this);
    View view = getLayoutInflater().inflate(R.layout.toastlayout,(ViewGroup)findViewById(R.id.toast_layout_container));
    TextView text = (TextView) view.findViewById(R.id.toast_text);
    text.setText(first_num+"+"+second_num+"="+first_num*second_num);
    toast.setGravity(Gravity.CENTER,-20,0);
    toast.setView(view);
    toast.setDuration(Toast.LENGTH_LONG);
    toast.show();
}

                                                         //STARTING SECOND PART !!

private void second_part()
{
    ap.setSubtitle("Odd Sum");
    current_media=0;
    if(neutral_pressed) {
        sounds[current_media] = MediaPlayer.create(getApplicationContext(), R.raw.thirtyfive_times_eightyfive);
        sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
        sounds[current_media++].start();
    }
    main_content.setLayoutTransition(null);
    five_3 = new ImageView(this);
    five_3.setImageResource(R.drawable.five);
    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    lp.addRule(RelativeLayout.ALIGN_TOP,dummy.getId());
    //lp.addRule(RelativeLayout.ALIGN_LEFT,dummy.getId());
    lp.setMargins((3*width)/4,0,0,0);
    five_3.setLayoutParams(lp);
    five_3.setId(53);
    five_3.setScaleX(0.001f);
    five_3.setScaleY(0.001f);
    //main_content.addView(five);
    //adding 4 of 45
    three_3 = getView(first_num/10);
    RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    lp_2.addRule(RelativeLayout.ALIGN_TOP,53);
    //lp_2.addRule(RelativeLayout.LEFT_OF,5);
    //Log.i("width of 4:",String.valueOf(four.getWidth()));
    lp_2.setMargins((int)(3*width)/4-65,0,0,0);
    three_3.setLayoutParams(lp_2);
    three_3.setId(33);
    three_3.setScaleY(0.001f);
    three_3.setScaleX(0.001f);
    //main_content.addView(four);
    //adding 8 of 85
    eight_3 = getView(second_num/10);
    //eight_3.setImageResource(R.drawable.eight);
    RelativeLayout.LayoutParams lp_3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    lp_3.addRule(RelativeLayout.BELOW,33);
    lp_3.addRule(RelativeLayout.ALIGN_LEFT,33);
    eight_3.setLayoutParams(lp_3);
    eight_3.setId(83);
    eight_3.setScaleY(0.001f);
    eight_3.setScaleX(0.001f);
    //main_content.addView(eight);
    //adding 5 of 85
    five_4 = new ImageView(this);
    five_4.setImageResource(R.drawable.five);
    RelativeLayout.LayoutParams lp_4 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    lp_4.addRule(RelativeLayout.BELOW,53);
    lp_4.addRule(RelativeLayout.ALIGN_LEFT,53);
    lp_4.addRule(RelativeLayout.ALIGN_TOP,83);
    //lp.addRule(RelativeLayout.ALIGN_LEFT,dummy.getId());
    five_4.setLayoutParams(lp_4);
    five_4.setId(54);
    five_4.setScaleY(0.001f);
    five_4.setScaleX(0.001f);
    //main_content.addView(five_2);
    //adding views

    AnimatorSet anim1 = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.first_num_first_dig);
    anim1.setTarget(three_3);
    AnimatorSet anim2 = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.first_num_first_dig);
    anim2.setTarget(eight_3);
    AnimatorSet first_nums_animator = new AnimatorSet();
    first_nums_animator.setStartDelay(300);

    main_content.addView(five_3); main_content.addView(three_3); main_content.addView(eight_3); main_content.addView(five_4);

    first_nums_animator.playTogether(anim1,anim2);
    first_nums_animator.start();

    five_3.animate().scaleX(1).scaleY(1).setInterpolator(new OvershootInterpolator()).setDuration(2000).setStartDelay(300).start();
    five_4.animate().scaleX(1).scaleY(1).setInterpolator(new OvershootInterpolator()).setDuration(2000).setStartDelay(300).setListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            seperate_fives_2();
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    }).start();
}
    private void seperate_fives_2()
    {
        //Toast.makeText(this,String.valueOf(five.getWidth()+"and"+five.getX()),Toast.LENGTH_SHORT).show();
        five_3.animate().x(width-five_3.getWidth()).setDuration(600).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                add_first_digits_2();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
        five_4.animate().setListener(null).x(width-five_3.getWidth()).setDuration(600).setStartDelay(400).setInterpolator(new DecelerateInterpolator()).start();
    }
    private void add_first_digits_2()
    {
        dash_2 = new TextView(this);
        dash_2.setText("________________________________________");
        dash_2.setId(456);
        dash_2.setTextSize(10f);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(width/2,five_3.getHeight()*3, 0, 0);
        dash_2.setScaleX(0.001f);
        main_content.addView(dash_2, lp);
        dash_2.animate().scaleX(0.5f).setStartDelay(300).setDuration(1000).start();
        //adding the addition sign
        multiply_2 = new ImageView(this);
        multiply_2.setImageResource(R.drawable.multiply);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(five_3.getWidth(), five_3.getHeight());
        lp_2.addRule(RelativeLayout.LEFT_OF,83);
        lp_2.addRule(RelativeLayout.ALIGN_TOP,83);
        multiply_2.setLayoutParams(lp_2);
        multiply_2.setScaleX(0.8f);
        multiply_2.setScaleY(0.8f);
        multiply_2.setRotation(45);
        main_content.addView(multiply_2);

        sign_animate = ValueAnimator.ofFloat(0.8f,0.6f);
        sign_animate.setDuration(300);
        sign_animate.setRepeatMode(ValueAnimator.REVERSE);
        sign_animate.setRepeatCount(5);
        sign_animate.setStartDelay(400);
        sign_animate.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                multiply_2.setScaleX(animation.getAnimatedFraction());
                multiply_2.setScaleY(animation.getAnimatedFraction());
            }
        });
        sign_animate.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                sum_answer_2();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                multiply_2.setScaleX(0.9f);
                multiply_2.setScaleY(0.9f);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        sign_animate.start();
    }
    private void sum_answer_2()
    {
        int digit = getDigit(add);
        if(digit==2)
            one_2=getView(add/10);
        else
            one_2=getView(add);
        //one_2 = new ImageView(this);
        //one_2.setImageResource(R.drawable.one);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW,456);
        lp.addRule(RelativeLayout.ALIGN_LEFT,83);
        one_2.setLayoutParams(lp);
        one_2.setScaleX(5);
        one_2.setScaleY(5);
        one_2.setVisibility(View.INVISIBLE);
        main_content.addView(one_2);
        one_2.setId(12);
        one_2.setVisibility(View.VISIBLE);
        ObjectAnimator.ofFloat(one_2, "scaleX", 1f).setDuration(1000).start();
        ObjectAnimator anim = ObjectAnimator.ofFloat(one_2, "scaleY", 1f).setDuration(1000);

        sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.add_left_most_digits);
        sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
        sounds[current_media].start();
        if(neutral_pressed) {
            sounds[current_media - 1].release();
            sounds[current_media - 1] = null;
        }
        current_media++;

        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(getDigit(add)==2)
                    add_second_one();
                else
                    is_even_or_odd_2();
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
    private void add_second_one(){
        one_3 = new ImageView(this);
        one_3.setImageResource(R.drawable.one);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_2.addRule(RelativeLayout.BELOW,456);
        lp_2.addRule(RelativeLayout.ALIGN_TOP,12);
        lp_2.addRule(RelativeLayout.RIGHT_OF,12);
        one_3.setLayoutParams(lp_2);
        one_3.setScaleX(5);
        one_3.setScaleY(5);
        //two.setVisibility(View.INVISIBLE);
        main_content.addView(one_3);
        one_3.setId(13);
        ObjectAnimator one_3_scaleX = ObjectAnimator.ofFloat(one_3, "scaleX", 1f).setDuration(1000);
        one_3_scaleX.start();
        ObjectAnimator one_3_scaleY = ObjectAnimator.ofFloat(one_3, "scaleY", 1f).setDuration(1000);
        one_3_scaleY.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                is_even_or_odd_2();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        one_3_scaleY.start();
    }
    private void is_even_or_odd_2()
    {
        if(sign_animate.isRunning())
            sign_animate.end();
        Toast toast= new Toast(this);
        View view = getLayoutInflater().inflate(R.layout.toastlayout,(ViewGroup)findViewById(R.id.toast_layout_container));
        TextView text = (TextView) view.findViewById(R.id.toast_text);
        text.setText("ODD ! So, 75 will be the last two digits of the answer!");
        toast.setGravity(Gravity.CENTER,-20,0);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
        //TextView answer = (TextView) main_content.findViewById(R.id.answer);
        //answer.setWidth(five.getWidth()*5);
        //answer.setHeight(five.getHeight()*(3/2));
        //answer.setLeft((width/2-five.getWidth()*5)/2);

        answer_2 = new TextView(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(width/2,five_3.getHeight());
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        lp.setMargins(width/2+((width/2)-five_3.getWidth()*4)/2,0,0,0);
        answer_2.setBackground(getResources().getDrawable(R.drawable.textbox));
        answer_2.setPadding(2,0,0,2);
        answer_2.setLayoutParams(lp);
        answer_2.setAlpha(0);
        answer_2.setId(201);
        answer_2.setTextColor(getResources().getColor(R.color.abc_primary_text_material_light));
        answer_2.setHint("ANSWER");
        answer_2.setTextSize(40);
        answer_2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        main_content.addView(answer_2);

        TextView label_2 = new TextView(this);
        label_2.setText("Answer:");
        label_2.setTextSize(20);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_2.addRule(RelativeLayout.ABOVE,201);
        lp_2.addRule(RelativeLayout.ALIGN_LEFT,201);
        label_2.setLayoutParams(lp_2);
        main_content.addView(label_2);

        answer_2.animate().alpha(1).setDuration(3000).setStartDelay(300).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.seventy_five_right_most_digits);
                sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                sounds[current_media].start();
                sounds[current_media-1].release();
                sounds[current_media-1]=null;
                current_media++;

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                answer_2.setText(getResources().getString(R.string.seventyfive));
                add_25_2();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }
    private void add_25_2()
    {
        sum_2 = new View(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(five_3.getWidth()*2,five_3.getHeight());
        sum_2.setBackground(getResources().getDrawable(R.drawable.sum_product_box));
        sum_2.setId(499);
        lp.addRule(RelativeLayout.CENTER_VERTICAL);
        lp.addRule(RelativeLayout.RIGHT_OF,R.id.divider);
        sum_2.setLayoutParams(lp);
        sum_2.setScaleX(0.01f);
        main_content.addView(sum_2);

        sum_label_2 = new TextView(this);
        sum_label_2.setText("Sum:");
        sum_label_2.setTextSize(20);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_2.addRule(RelativeLayout.ABOVE,499);
        lp_2.addRule(RelativeLayout.RIGHT_OF,R.id.divider);
        sum_label_2.setLayoutParams(lp_2);
        main_content.addView(sum_label_2);

        sum_2.animate().scaleX(1).setDuration(1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                one_2.bringToFront();
                if(one_3!=null)
                    one_3.bringToFront();
                one_2.animate().xBy(width/2-one_2.getX()).y(sum_2.getY()).setDuration(1000).setInterpolator(new AnticipateInterpolator()).start();
                if(one_3!=null)
                    one_3.animate().xBy(-one_3.getX()+one_2.getWidth()+width/2).y(sum_2.getY()).setDuration(1000).setStartDelay(400).setInterpolator(new AnticipateInterpolator()).start();
            }
        }).start();

        multiply_2.animate().rotationBy(45).setStartDelay(2200).setDuration(1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                ValueAnimator val = ValueAnimator.ofFloat(0.9f, 0.6f);
                val.setDuration(600);
                val.setRepeatCount(4);
                val.setRepeatMode(ValueAnimator.REVERSE);
                val.setInterpolator(new AccelerateDecelerateInterpolator());
                val.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        multiply_2.setScaleX(animation.getAnimatedFraction());
                        multiply_2.setScaleY(animation.getAnimatedFraction());
                    }
                });
                val.start();
                multiply_ans_2();
            }
        }).start();
    }
    private void multiply_ans_2()
    {
        if(getDigit(mul)==2)
            two_3=getView(mul/10);
        else
            two_3=getView(mul);
        //two_3 = new ImageView(this);
        //two_3.setImageResource(R.drawable.two);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW,456);
        lp.addRule(RelativeLayout.ALIGN_LEFT,83);
        two_3.setLayoutParams(lp);
        two_3.setScaleX(5);
        two_3.setScaleY(5);
        two_3.setVisibility(View.INVISIBLE);
        main_content.addView(two_3);
        two_3.setId(23);
        two_3.setVisibility(View.VISIBLE);
        ObjectAnimator.ofFloat(two_3, "scaleX", 1f).setDuration(1000).start();
        ObjectAnimator anim = ObjectAnimator.ofFloat(two_3, "scaleY", 1f).setDuration(1000);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.multiply_them);
                sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                sounds[current_media].start();
                sounds[current_media-1].release();
                sounds[current_media-1]=null;
                current_media++;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (getDigit(mul) == 2)
                    introduce_four();
                else
                    place_product_2();
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
    private void introduce_four()
    {
        four_2 = getView(mul%10);
        //four_2.setImageResource(R.drawable.four);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(five_3.getWidth(),five_3.getHeight());
        lp_2.addRule(RelativeLayout.BELOW,456);
        lp_2.addRule(RelativeLayout.ALIGN_TOP,23);
        lp_2.addRule(RelativeLayout.RIGHT_OF,23);
        four_2.setLayoutParams(lp_2);
        four_2.setScaleX(5);
        four_2.setScaleY(5);
        //two.setVisibility(View.INVISIBLE);
        main_content.addView(four_2);
        four_2.setId(42);
        ObjectAnimator four_2_scaleX = ObjectAnimator.ofFloat(four_2, "scaleX", 1f).setDuration(1000);
        four_2_scaleX.start();
        ObjectAnimator four_2_scaleY = ObjectAnimator.ofFloat(four_2, "scaleY", 1f).setDuration(1000);
        four_2_scaleY.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                place_product_2();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        four_2_scaleY.start();
    }
    private void place_product_2()
    {
        product_label_2 = new TextView(this);
        product_label_2.setText("Product:");
        product_label_2.setTextSize(20);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_2.addRule(RelativeLayout.BELOW,sum_2.getId());
        lp_2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        product_label_2.setLayoutParams(lp_2);
        product_label_2.setId(680);
        main_content.addView(product_label_2);

        product_2 = new View(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(five_3.getWidth()*2,five_3.getHeight());
        product_2.setBackground(getResources().getDrawable(R.drawable.sum_product_box));
        product_2.setId(729);
        lp.addRule(RelativeLayout.BELOW,680);
        lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        product_2.setLayoutParams(lp);
        product_2.setScaleX(0.01f);
        main_content.addView(product_2);
        product_2.animate().scaleX(1).setDuration(1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                two_3.bringToFront();
                if(four_2!=null)
                    four_2.bringToFront();
                if(four_2!=null) {
                    four_2.animate().xBy(width - four_2.getX() - four_2.getWidth()).y(product_2.getY()).setDuration(1000).setInterpolator(new AnticipateInterpolator()).start();
                    two_3.animate().xBy(width - four_2.getWidth() - two_3.getWidth() - two_3.getX()).y(product_2.getY()).setDuration(1000).setStartDelay(400).setInterpolator(new AnticipateInterpolator()).start();
                }
                else
                    two_3.animate().xBy(width - two_3.getX() - two_3.getWidth()).y(product_2.getY()).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator()).start();
                    shift_sum_and_product_2();
            }
        }).start();
    }
    private void shift_sum_and_product_2()
    {
        sum_label_2.setZ(sum_2.getZ()-1);
        sum_label_2.animate().translationYBy(sum_label_2.getHeight()).setDuration(1000).setStartDelay(1200).withEndAction(new Runnable() {
            @Override
            public void run() {
                sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.subtract_then_divide);
                sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                sounds[current_media].start();
                sounds[current_media-1].release();
                sounds[current_media-1]=null;
                current_media++;
                sum_label_2.setText("(Sum-1) / 2:");
                sum_label_2.animate().yBy(-sum_label_2.getHeight()).setDuration(700).start();
                sumByTwo_2();
            }
        }).start();
    }
    private void sumByTwo_2()
    {
        final View hiding_view_2 = new View(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(two_3.getWidth()*2,sum_2.getHeight());
        lp.addRule(RelativeLayout.RIGHT_OF,sum_2.getId());
        lp.addRule(RelativeLayout.ALIGN_TOP,sum_2.getId());
        hiding_view_2.setLayoutParams(lp);
        hiding_view_2.setId(450);
        hiding_view_2.setBackgroundColor(Color.WHITE);
        main_content.addView(hiding_view_2);

        if(one_3!=null)
            one_3.animate().translationXBy(sum_2.getX()+sum_2.getWidth()-one_3.getX()).setDuration(1000).setStartDelay(1200).start();
        one_2.animate().translationXBy(sum_2.getX()+sum_2.getWidth()-one_2.getX()).setDuration(1000).setStartDelay(1400).withEndAction(new Runnable() {
            @Override
            public void run() {
                bring_five(hiding_view_2);
            }
            private void bring_five(View hiding_view_2)
            {
                five_5 = getView((add-1)/2);
                //five_5.setImageResource(R.drawable.five);
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(five_3.getWidth(), five_3.getHeight());
                lp.addRule(RelativeLayout.ALIGN_LEFT, 450);
                lp.addRule(RelativeLayout.CENTER_VERTICAL);
                five_5.setLayoutParams(lp);
                //six.setZ((float)(hiding_view.getZ()-.1));
                five_5.setVisibility(View.INVISIBLE);
                main_content.addView(five_5);
                if(one_2!=null)
                    main_content.removeView(one_2);
                if(one_3!=null)
                    main_content.removeView(one_3);
                hiding_view_2.bringToFront();
                five_5.setVisibility(View.VISIBLE);
                animate_everything_2();
            }
            private void animate_everything_2()
            {
                final int eight_height=five_3.getHeight();
                final int sum_width =sum_2.getWidth();
                final int sum_height=sum_2.getHeight();

                ObjectAnimator five_5_x = ObjectAnimator.ofFloat(five_5,"x",width/2+sum_2.getWidth(),width/2+sum_2.getWidth() / 2);
                five_5_x.setDuration(1500);
                five_5_x.setStartDelay(200);
                five_5_x.setInterpolator(new AccelerateDecelerateInterpolator());
                five_5_x.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        main_content.removeView(hiding_view_2);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                ObjectAnimator five_5_right = ObjectAnimator.ofFloat(five_5, "x",width/2+sum_2.getWidth()/2,width/2+width/4);
                five_5_right.setInterpolator(new AccelerateDecelerateInterpolator());
                five_5_right.setDuration(1000);
                AnimatorSet anim_2 = new AnimatorSet();
                anim_2.playSequentially(five_5_x, five_5_right);

                if(sum_2!=null)
                    sum_2.animate().translationX(width/4-sum_2.getWidth()/2).alpha(0f).setStartDelay(1500).setDuration(1000).start();
                anim_2.start();
                if(sum_label_2!=null)
                    sum_label_2.animate().translationX(width/4-(sum_2.getX()+sum_2.getWidth()/2)).alpha(0f).setStartDelay(1500).setDuration(1000).start();
                if(product_2!=null)
                    product_2.animate().translationXBy(width/2+width/4-(product_2.getX()+product_2.getWidth()/2)).translationYBy(eight_height/2).alpha(0f).setStartDelay(1500).setDuration(1000).start();
                if(two_3!=null)
                    two_3.animate().translationXBy(width/2+width/4-(product_2.getX()+product_2.getWidth()/2)).translationYBy(eight_height/2).setStartDelay(1500).setDuration(1000).start();
                if(four_2!=null)
                    four_2.animate().translationXBy(width/2+width/4-(product_2.getX()+product_2.getWidth()/2)).translationYBy(eight_height/2).setStartDelay(1500).setDuration(1000).start();
                if(product_label_2!=null)
                    product_label_2.animate().translationXBy(width/2+width/4-(product_2.getX()+product_2.getWidth()/2)).translationYBy(eight_height/2).alpha(0f).setStartDelay(1500).setDuration(1000).withStartAction(new Runnable() {
                        @Override
                        public void run() {

                            sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.add_sum_and_product);
                            sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                            sounds[current_media].start();
                            sounds[current_media-1].release();
                            sounds[current_media-1]=null;
                            current_media++;

                            plus_2 = new ImageView(getApplicationContext());
                            plus_2.setImageResource(R.drawable.plus);
                            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
                            lp.setMargins(width/2+width/4,(int)sum_2.getY()+sum_2.getHeight(),0,0);
                            plus_2.setLayoutParams(lp);
                            plus_2.setAlpha(0f);
                            main_content.addView(plus_2);
                            ObjectAnimator.ofFloat(plus_2,"alpha",1).setDuration(2000).start();
                        }
                    }).withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            main_content.removeView(sum_2);
                            main_content.removeView(sum_label_2);
                            main_content.removeView(product_2);
                            main_content.removeView(product_label_2);
                            bring_dash_2();
                        }
                    }).start();
            }}).start();
    }
    private void bring_dash_2()
    {
        dash_2.animate().setListener(null).translationYBy(two_3.getY()+two_3.getHeight()-dash_2.getY()).rotationBy(360).setDuration(800).setInterpolator(new OvershootInterpolator()).start();
        multiply_2.animate().alpha(0).setDuration(400).withEndAction(new Runnable() {
            @Override
            public void run() {
                main_content.removeView(multiply_2);
                bring_twenty_nine();
            }
        }).start();

    }
    private void bring_twenty_nine()
    {
        final ImageView two_6,nine;
        Animator anim = AnimatorInflater.loadAnimator(this,R.animator.appear);
        lt = new LayoutTransition();
        lt.setAnimator(LayoutTransition.APPEARING,anim);
        main_content.setLayoutTransition(lt);
        main_content.setLayoutTransition(lt);

        int last_num = (add-1)/2 + mul;

        nine = getView(last_num % 10);
        //nine.setImageResource(R.drawable.nine);
        RelativeLayout.LayoutParams lp_2 = new RelativeLayout.LayoutParams(five_3.getWidth(),five_3.getHeight());
        lp_2.setMargins((int)five_5.getX(),(int)two_3.getY()+two_3.getHeight()+dash_2.getHeight(),0,0);
        nine.setLayoutParams(lp_2);
        nine.setId(9);
        nine.setScaleX(0f);
        nine.setScaleY(0f);
        main_content.addView(nine);

        if(getDigit(last_num)==2) {
            two_6 = getView(last_num / 10);
            // two_6.setImageResource(R.drawable.two);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(five_3.getWidth(), five_3.getHeight());
            lp.setMargins((int) five_5.getX() - five_3.getWidth(), (int) two_3.getY() + two_3.getHeight() + dash_2.getHeight(), 0, 0);
            two_6.setLayoutParams(lp);
            two_6.setId(26);
            two_6.setScaleX(0f);
            two_6.setScaleY(0f);
            main_content.addView(two_6);
        }
        else
            two_6=null;
        if(two_6!=null)
        {
            two_6.post(new Runnable() {
                @Override
                public void run() {
                    sounds[current_media]= MediaPlayer.create(getApplicationContext(),R.raw.append_before_75);
                    sounds[current_media+1]=MediaPlayer.create(getApplicationContext(),R.raw.you_got_answer);
                    sounds[current_media].setAudioStreamType(AudioManager.STREAM_MUSIC);
                    sounds[current_media].setNextMediaPlayer(sounds[current_media+1]);
                    sounds[current_media].start();
                    sounds[current_media-1].release();
                    sounds[current_media-1]=null;
                    two_6.animate().translationX(answer_2.getX()-two_6.getX()).translationYBy(answer_2.getY()-two_6.getY()).rotationXBy(360).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(600).setStartDelay(3000).start();
                }
            });
        }

        nine.post(new Runnable() {
            @Override
            public void run() {
                nine.animate().translationXBy(answer_2.getX()+nine.getWidth()-nine.getX()).translationYBy(answer_2.getY()-nine.getY()).rotationXBy(360).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(600).setStartDelay(3000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        answer_2.setText(String.valueOf(first_num*second_num));
                        main_content.removeView(two_6);
                        main_content.removeView(nine);
                    }
                }).start();
            }
        });
        Toast toast= new Toast(this);
        View view = getLayoutInflater().inflate(R.layout.toastlayout,(ViewGroup)findViewById(R.id.toast_layout_container));
        TextView text = (TextView) view.findViewById(R.id.toast_text);
        text.setText(first_num+"+"+second_num+"="+first_num*second_num);
        toast.setGravity(Gravity.CENTER,-20,0);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

