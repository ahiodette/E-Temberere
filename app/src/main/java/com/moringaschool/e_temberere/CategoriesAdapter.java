package com.moringaschool.e_temberere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CategoriesAdapter extends BaseAdapter {
    Context print;
    String[] details;
    int pictures[];
    LayoutInflater inflater;

    public CategoriesAdapter(Context print, String[] details, int[] pictures) {
        this.print = print;
        this.details = details;
        this.pictures = pictures;

    }


    @Override
    public int getCount() {
        return 0;
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_categories,null);

        return null;
    }


}
