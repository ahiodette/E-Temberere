package com.moringaschool.e_temberere;

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

    LayoutInflater inflater;


    public CategoriesAdapter( Context print, int resource, String[] details) {
        super(print, resource);
        this.print = print;
        this.details = details;
    }

    @Override
    public int getCount() {
        return details.length;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        String place = details[position];

        return String.format("%s",place);
    }
}
