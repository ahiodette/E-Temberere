package com.moringaschool.e_temberere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoriesActivity extends AppCompatActivity {

    @BindView(R.id.categoryList) ListView list;
    @BindView(R.id.place) EditText place;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progress) ProgressBar progress;

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

//        CategoriesAdapter adapter = new CategoriesAdapter(this, details, pictures);
//        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent places = new Intent(CategoriesActivity.this, ParksActivity.class);
                startActivity(places);
            }
        });

        Intent intent = getIntent();
        String city = intent.getStringExtra("city");


        YelpApi client = YelpClient.getClient();

        Call<ApiClass> call = client.getSites(city, "travelling");

        call.enqueue(new Callback<ApiClass>() {
            @Override
            public void onResponse(Call<ApiClass> call, Response<ApiClass> feedback) {
                if (feedback.isSuccessful()) {
                    List<Business> restaurantsList = feedback.body().getBusinesses();
                    String[] restaurants = new String[restaurantsList.size()];
                    String[] categories = new String[restaurantsList.size()];

                    for (int i = 0; i < restaurants.length; i++){
                        restaurants[i] = restaurantsList.get(i).getName();
                    }

                    for (int i = 0; i < categories.length; i++) {
                        Category category = restaurantsList.get(i).getCategories().get(0);
                        categories[i] = category.getTitle();
                    }

                    CategoriesAdapter adapter = new CategoriesAdapter(CategoriesActivity.this, details, pictures);
                    list.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ApiClass> call, Throwable t) {

            }

        });

    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showSites() {
        list.setVisibility(View.VISIBLE);
        place.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progress.setVisibility(View.GONE);
    }

}
