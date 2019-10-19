package com.moringaschool.e_temberere.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CategoriesAdapter extends ArrayAdapter {
    private Context print;
    private String[] details;
    private String[] pictures;

    public CategoriesAdapter( Context print, int resource,String[] details, String[] pictures) {
        super(print,resource);
        this.print = print;
        this.details = details;
        this.pictures = pictures;
    }


    //    public CategoriesAdapter(Context print, String[] details, String[] pictures) {
//        this.print = print;
//        this.details = details;
//        this.pictures = pictures;
//    }



    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) print
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        View view = inflater.inflate(R.layout.customlayout, null);
//        ImageView image = (ImageView) view.findViewById(R.id.sitePicture);
//        TextView name = (TextView) view.findViewById(R.id.siteName);
//
//        image.setImageResource(pictures[position]);
//        name.setText(details[position]);
//        return view;
//    }
}