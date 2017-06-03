package com.example.souma.vedamagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Subtraction_Cardview extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction__cardview);
    }
    public void card_click1(View view)
    {
                Intent i=new Intent(Subtraction_Cardview.this,SubstractFromPowerOf10.class);
                startActivity(i);

    }

}
