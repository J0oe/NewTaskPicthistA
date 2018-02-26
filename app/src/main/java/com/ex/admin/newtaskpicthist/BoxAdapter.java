package com.ex.admin.newtaskpicthist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 24.02.2018.
 */

public class BoxAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Product> objects;

    BoxAdapter(Context context, ArrayList<Product> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }
        Product p = getProduct(position);
        if (p.status.equals("1")) {
            ((LinearLayout) view.findViewById(R.id.idLinerColor)).setBackgroundResource(R.color.colorGreen);
        }
        if (p.status.equals("2")) {
            ((LinearLayout) view.findViewById(R.id.idLinerColor)).setBackgroundResource(R.color.colorRed);
        }
        if (p.status.equals("3")) {
            ((LinearLayout) view.findViewById(R.id.idLinerColor)).setBackgroundResource(R.color.coloGrey);
        }
        ((TextView) view.findViewById(R.id.idTimeImage)).setText(p.time);
        ((TextView) view.findViewById(R.id.idUrlImage)).setText(p.url);

        return view;
    }

    Product getProduct(int position) {
        return ((Product) getItem(position));
    }

}
