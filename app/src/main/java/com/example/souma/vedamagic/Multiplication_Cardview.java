package com.example.souma.vedamagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Multiplication_Cardview extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication__cardview);
    }
    public void card_click(View view)
    {
        switch (view.getId())
        {
            case R.id.mul1:
                Intent i=new Intent(Multiplication_Cardview.this,MultiplyBy5.class);
                startActivity(i);
                break;
            case R.id.mul2:
                Intent i1=new Intent(Multiplication_Cardview.this,Multiply11.class);
                startActivity(i1);
                break;
            case R.id.mul3:
                Intent i2=new Intent(Multiplication_Cardview.this,Multiply_2Digit.class);
                startActivity(i2);
        }
    }
}
