package com.moringaschool.e_temberere.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moringaschool.e_temberere.R;
import com.moringaschool.e_temberere.models.ApiClass;
import com.moringaschool.e_temberere.models.Business;
import com.moringaschool.e_temberere.models.Category;
import com.moringaschool.e_temberere.network.YelpApi;
import com.moringaschool.e_temberere.network.YelpClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoriesActivity extends AppCompatActivity {

    @BindView(R.id.categoryList) ListView list;

    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progress) ProgressBar progress;

//    int[] pictures={
//            R.drawable.park,
//            R.drawable.muse,
//            R.drawable.kivu,
//            R.drawable.caves,
//            R.drawable.genocide,
//            R.drawable.round
//    };
//     String[] details = {
//             "Parks and forests",
//             "Museums",
//             "Lakes",
//             "Caves",
//             "Genocide memorials",
//             "Others places(Hotels, Cultural shops,...)"
//     };


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
                hideProgressBar();
                if (feedback.isSuccessful()) {
                    List<Business> sitesList = feedback.body().getBusinesses();
                    String[] sites = new String[sitesList.size()];
                    String[] categories = new String[sitesList.size()];

                    for (int i = 0; i < sites.length; i++) {
                        sites[i] = sitesList.get(i).getName();
                    }

                    for (int i = 0; i < categories.length; i++) {
                        Category category = sitesList.get(i).getCategories().get(0);
                        categories[i] = category.getTitle();
                    }

                    CategoriesAdapter adapter = new CategoriesAdapter(CategoriesActivity.this,android.R.layout.simple_list_item_1, sites, categories);
                    list.setAdapter(adapter);

                    showSites();
                }
                else {
                    showUnsuccessfulMessage();

                }
            }

            @Override
            public void onFailure(Call<ApiClass> call, Throwable t) {
//                Log.e(TAG, "onFailure:",t);

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

    }

    private void hideProgressBar() {
        progress.setVisibility(View.GONE);
    }

}
