package com.moringaschool.e_temberere.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.e_temberere.R;

import butterknife.BindView;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.createUserButton) Button newUserButton;
    @BindView(R.id.nameEditText) Button newUserName;
    @BindView(R.id.emailEditText) EditText newUserEmail;
    @BindView(R.id.passwordEditText) EditText newUsewPassword;
    @BindView(R.id.confirmPasswordEditText) EditText passConfirmation;
    @BindView(R.id.loginTextView) TextView backToLogin;

    private FirebaseAuth 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
}
