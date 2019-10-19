package com.moringaschool.e_temberere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;


public class CategoriesActivity extends AppCompatActivity {

    @BindView(R.id.categoryList) ListView list;
    @BindView(R.id.place) SearchView searchView;

    int[] pictures={
            R.drawable.park,
            R.drawable.muse,
            R.drawable.kivu,
            R.drawable.caves,
            R.drawable.genocide,
            R.drawable.round
    };
     String[] details = {
             "Parks and forests",
             "Museums",
             "Lakes",
             "Caves",
             "Genocide memorials",
             "Others places(Hotels, Cultural shops,...)"
     };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        CategoriesAdapter adapter = new CategoriesAdapter(this, details, pictures);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent places = new Intent(CategoriesActivity.this, ParksActivity.class);
                startActivity(places);
            }
        });

        Intent intent = getIntent();


        YelpApi client = YelpClient.getClient();

//        Call<ApiClass> call = client.getSites(place, "travelling");

    }
}
