package com.moringaschool.e_temberere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CategoriesActivity extends AppCompatActivity {
    @BindView(R.id.categories_title) TextView cTitle;
    @BindView(R.id.categoriesList) ListView cList;
    public static final String TAG = CategoriesActivity.class.getSimpleName();

    private String[] categories = new String[]{"Parks", "Museums", "Lakes", "Others places(Hotels, Cultural shops,...)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        CategoriesAdapter adapter = new CategoriesAdapter(this,  categories);
        cList.setAdapter(adapter);
        cList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
