package com.example.souma.vedamagic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class Rating extends AppCompatActivity {

    Button b;
    RatingBar r;
    float val;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        b=(Button)findViewById(R.id.Send);
        r=(RatingBar)findViewById(R.id.ratingBar);
    }
    public void send(View v)
    {
        r.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                val=ratingBar.getRating();
            }
        });
        Intent i=new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL,new String[]{"vedamagic123@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT,"Rating");
        i.putExtra(Intent.EXTRA_TEXT,"Rating:"+val);
        startActivity(Intent.createChooser(i,"Rating"));
    }
}
