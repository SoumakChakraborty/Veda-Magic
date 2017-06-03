package com.example.souma.vedamagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Addition_Cardview extends AppCompatActivity {

    CardView v1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition__cardview);
    }
    public void card_click2(View view)
    {
        Intent i=new Intent(Addition_Cardview.this,Addition.class);
        startActivity(i);

    }
}
