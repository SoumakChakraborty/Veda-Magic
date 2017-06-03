package com.example.souma.vedamagic;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question4 extends AppCompatActivity {

    boolean get;
    int c;
    Button b;
    AlertDialog.Builder al;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

    }
    public void check_answer(View view)
    {
        get=((RadioButton)view).isChecked();
        b=(Button)findViewById(R.id.submit1);
        switch (view.getId())
        {
            case R.id.q8:
                if(get) {
                    c=1;
                }
                break;
            case R.id.q9:
                if(get) {
                    c=2;
                }
                break;
            case R.id.q10:
                if(get) {
                    c=3;
                }
                break;
            case R.id.q11:
                if(get) {
                    c=4;
                }
                break;
        }
        al=new AlertDialog.Builder(this);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(c==4)
                {
                    al.setMessage("Correct");
                    al.setTitle("Result");
                    al.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    al.show();
                }
                else
                {
                    al.setMessage("Incorrect");
                    al.setTitle("Result");
                    al.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    al.show();
                }
            }
        });
    }
}
