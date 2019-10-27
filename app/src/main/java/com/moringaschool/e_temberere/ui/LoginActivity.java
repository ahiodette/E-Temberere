package com.moringaschool.e_temberere.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringaschool.e_temberere.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.loginButton) Button loginButton;
    @BindView(R.id.emailEditText) EditText loginEmail;
    @BindView(R.id.passwordEditText) EditText loginPassword;
    @BindView(R.id.signTextView) TextView createAccount;

    private FirebaseAuth authent;
    private FirebaseAuth.AuthStateListener authStateListener;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        createAccount.setOnClickListener(this);
        loginButton.setOnClickListener(this);

        authent=FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
        createAuthProgressDialog();
    }

    private void createAuthProgressDialog(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Authenticating with Firebase...");
        progressDialog.setCancelable(false);
    }

    @Override
    public void onClick(View view){
        if (view == createAccount){
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
            finish();
        }

        if (view == loginButton){
            loginWithPassword();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void loginWithPassword(){
        String email = loginEmail.getText().toString().trim();
        String password = loginPassword.getText().toString().trim();
        authent.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (email.equals("")){
            loginEmail.setError("Please enter your Email");
            return;
        }
        if (password.equals("")){
            loginPassword.setError("Password cannot be blank");
            return;
        }

        progressDialog.show();
        authent.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               progressDialog.dismiss();
               if (!task.isSuccessful()){
                   Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_LONG);
               }
            }
        });
    }

}
