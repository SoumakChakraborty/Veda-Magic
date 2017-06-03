package com.example.souma.vedamagic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by soura on 3/8/2017.
 */

public class MenuView extends BaseAdapter {
    private String[] text;
    private Integer[] images;
    Context mcontext;
    MenuView(Context mcontext, String[] text, Integer[] imageids)
    {
        this.mcontext=mcontext;
        this.text=text;
        this.images=imageids;
    }
    @Override
    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
       if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = new View(mcontext);
            grid=inflater.inflate(R.layout.mix_view,null);
            TextView textView=(TextView)grid.findViewById(R.id.adapterstring);
            ImageView imageView=(ImageView)grid.findViewById(R.id.adapterimage);

            //textView=(TextView)grid.findViewById(R.id.adapterstring);
            //imageView=(ImageView)grid.findViewById(R.id.adapterimage);
            //imageView.setLayoutParams(new GridView.LayoutParams(90,90));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
           // imageView.setImageResource(images[position]);
          //  textView.setText(text[position]);
        //}
        //else
          //  grid=(View)convertView;
            grid.setClipToOutline(true);
        imageView.setImageResource(images[position]);
        textView.setText(text[position]);
        return grid;
    }
    else
        grid = (View) convertView;
        return  grid;
}}
