package com.moringaschool.e_temberere.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.e_temberere.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.createUserButton) Button newUserButton;
    @BindView(R.id.nameEditText) Button newUserName;
    @BindView(R.id.emailEditText) EditText newUserEmail;
    @BindView(R.id.passwordEditText) EditText newUserPassword;
    @BindView(R.id.confirmPasswordEditText) EditText passConfirmation;
    @BindView(R.id.loginTextView) TextView backToLogin;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private ProgressDialog progressDialog;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        backToLogin.setOnClickListener(this);
        newUserButton.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
        createAuthStateListener();
        createAuthProgressDialog();
    }

    public void createAuthProgressDialog(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Authenticating with Firebase...");
        progressDialog.setCancelable(true);
    }

    @Override
    public void onClick(View view){
        if(view==backToLogin){
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if (view == newUserButton){
            createNewUser();
        }
    }

    public void createNewUser(){
        final String userName = newUserName.getText().toString();
        final String email = newUserEmail.getText().toString();
        String password = newUserPassword.getText().toString();
        String confirm = passConfirmation.getText().toString().trim();
    }
}
