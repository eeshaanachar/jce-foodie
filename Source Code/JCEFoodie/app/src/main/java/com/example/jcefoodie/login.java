package com.example.jcefoodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener{

    private EditText email, password;
    private Button sign_up,signin,reset;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        sign_up= findViewById(R.id.btn_signup);
        signin = findViewById(R.id.btn_login);
        reset = findViewById(R.id.btn_reset_password);
        progressBar = findViewById(R.id.progressBar);

        signin.setOnClickListener(this);
        reset.setOnClickListener(this);
        sign_up.setOnClickListener(this);
    }

    private void login_fun() {

        String email_t = email.getText().toString().trim();
        String pass_t = password.getText().toString().trim();
        auth.signInWithEmailAndPassword(email_t, pass_t).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                password.setError(getString(R.string.minimum_password));
                            } else {
                                Toast.makeText(login.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Intent intent = new Intent(login.this, HomePage.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {

        if(view == signin){
            login_fun();
        }

        if(view == reset){
            Intent intent = new Intent(this, reset.class);
            startActivity(intent);
        }

        if(view == sign_up){
            Intent intent = new Intent(this, signup.class);
            startActivity(intent);
        }
    }
}
