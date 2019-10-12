package com.moringaschool.e_temberere;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CategoriesAdapter extends BaseAdapter {
    private Context print;
    private String[] categs;

    public CategoriesAdapter(Context print, String[] categs) {
        this.print = print;
        this.categs = categs;
    }

    @Override
    public int getCount() {
        return categs.length;
    }

    @Override
    public Object getItem(int position) {
        String category = categs[position];
        return String.format(category);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
