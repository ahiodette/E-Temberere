package com.moringaschool.e_temberere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.shaka) Button search;
    @BindView(R.id.ahantu) EditText hehe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==search){
            String cocation = hehe.getText().toString();
            Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);

            startActivity(intent);
        }
    }
}
