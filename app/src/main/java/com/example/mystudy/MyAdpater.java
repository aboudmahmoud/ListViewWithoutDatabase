package com.example.mystudy;

import android.content.Context;
import android.util.AndroidException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
// extend BaseAdapter
public class MyAdpater extends ArrayAdapter {
    private Context context;
    private  ArrayList<String> data;
private int resource;
    public  MyAdpater(Context context,int resource,ArrayList<String> names){
       super(context,resource,names);
        this.context=context;
        data=names;
        this.resource=resource;

    }
    @Override
    public int getCount() {
        return data.size();
    }

    public void AddItem(String item){
        data.add(item);
    }
    public void setItem(int postion , String item)
    {
        data.set(postion,item);
    }
    public void setItemUSEING(String postion , String item)
    {
        data.set(data.indexOf(postion),item);
    }
    public String getdata(int postion)
    {
        System.out.println(data.get(postion));
        return data.get(postion);
    }

    @Override
    public Object getItem(int postion) {
        return null;
    }

    @Override
    public long getItemId(int postion) {
        return 0;
    }

    @Override
    public View getView(int postion, View view, ViewGroup viewGroup) {
        View vi=view;
        if (vi==null)
        {
         vi=   LayoutInflater.from(context).inflate(resource,null,false);
        }
        TextView textView= vi.findViewById(android.R.id.text1);
        String name=data.get(postion);
        textView.setText(name);

        return vi;
    }
}
