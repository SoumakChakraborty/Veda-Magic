package com.example.souma.vedamagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Division_Cardview extends AppCompatActivity {

    CardView v1,v2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division__cardview);
    }
    public void card_click3(View view)
    {
        Intent i=new Intent(Division_Cardview.this,Division.class);
        startActivity(i);

    }
}
