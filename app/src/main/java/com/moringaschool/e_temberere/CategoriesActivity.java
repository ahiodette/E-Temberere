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

    ListView list;

     String[] details = {"Parks", "Museums", "Lakes", "Caves","Genocide memorials","Others places(Hotels, Cultural shops,...)"};
     int pictures[]={R.drawable.park,R.drawable.muse,R.drawable.kivu,R.drawable.caves,R.drawable.genocide,R.drawable.round};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        list = (ListView) findViewById(R.id.categoryList);
        CategoriesAdapter customAdapter = new CustomerAdapter()
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
//        CategoriesAdapter adapter = new CategoriesAdapter(this, categories);
//        cList.setAdapter(adapter);

    }
}
