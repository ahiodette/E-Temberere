package com.moringaschool.e_temberere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.shaka) Button search;
    @BindView(R.id.place) EditText location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = location.getText().toString();
                Toast.makeText(MainActivity.this,"Welcome to thousands hills country", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);

                startActivity(intent);

            }
        });

    }

}