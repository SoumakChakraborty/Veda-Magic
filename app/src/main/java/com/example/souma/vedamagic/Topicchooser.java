package com.example.souma.vedamagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Topicchooser extends AppCompatActivity {

    CardView v1,v2,v3,v4,v5;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topicchooser);
        v1=(CardView)findViewById(R.id.topic1);
        v2=(CardView)findViewById(R.id.topic2);
        v3=(CardView)findViewById(R.id.topic3);
        v4=(CardView)findViewById(R.id.topic4);
        v5=(CardView)findViewById(R.id.topic5);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Topicchooser.this,MultiplyBy5.class);
                startActivity(i);
            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Topicchooser.this,Multiply11.class);
                startActivity(i);
            }
        });
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Topicchooser.this,Addition.class);
                startActivity(i);
            }
        });
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Topicchooser.this,SubstractFromPowerOf10.class);
                startActivity(i);
            }
        });
        v5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Topicchooser.this,Division.class);
                startActivity(i);
            }
        });
    }
}
