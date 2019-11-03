package com.moringaschool.e_temberere.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.moringaschool.e_temberere.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.welcomeButton) Button welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);


        welcome.setOnClickListener(this);
        Animation shake = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        welcome.startAnimation(shake);
    }

    @Override
    public void onClick(View v) {
        if (v==welcome){

            Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
            startActivity(intent);

        }
    }
}
