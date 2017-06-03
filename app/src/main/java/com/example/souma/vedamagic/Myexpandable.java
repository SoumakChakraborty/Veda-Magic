package com.example.souma.vedamagic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class Myexpandable extends BaseExpandableListAdapter
{
    Context c;
    List<String> l;
    Map<String,List<String>> m;
    ImageView img;
    public Myexpandable(Context c, List<String> l, Map<String, List<String>> m,ImageView img) {
        this.c = c;
        this.l = l;
        this.m = m;
        this.img=img;
    }

    public int getGroupCount() {
        return l.size();
    }

    @Override
    public int getChildrenCount(int i) {

        return m.get(l.get(i)).size();
    }

    @Override
    public Object getGroup(int i)
    {
        return l.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {


        return m.get(l.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {


        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String s=(String)getGroup(i);
        if(view==null)
        {
            LayoutInflater lin=(LayoutInflater)c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
            view=lin.inflate(R.layout.layout_parent,null);
        }
        TextView txt=(TextView)view.findViewById(R.id.expparent);
        img=(ImageView)view.findViewById(R.id.set_topic);
        if(i==0)
            img.setImageResource(R.drawable.multi);
        else if(i==1)
            img.setImageResource(R.drawable.add);
        else if(i==2)
            img.setImageResource(R.drawable.sub);
        else if(i==3)
            img.setImageResource(R.drawable.div);
        txt.setText(s);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup)
    {

        String s=(String)getChild(i,i1);
        if(view==null)
        {
            LayoutInflater lin=(LayoutInflater)c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
            view=lin.inflate(R.layout.layout_child,null);
        }
        TextView txt=(TextView)view.findViewById(R.id.exp_child);
        txt.setText(s);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
