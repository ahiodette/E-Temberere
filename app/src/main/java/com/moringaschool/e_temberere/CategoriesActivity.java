package com.moringaschool.e_temberere;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CategoriesActivity extends AppCompatActivity {

    private String[] categories = new String[]{"Parks", "Museums", "Lakes", "Others places(Hotels, Cultural shops,...)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }
}
