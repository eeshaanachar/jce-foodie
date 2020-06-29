package com.example.jceinsider;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login (View view) {
        EditText text = findViewById(R.id.editText);
        String userName = text.getText().toString();
        text = findViewById(R.id.editText2);
        String password = text.getText().toString();
        if (userName.equals("admin") && password.equals("admin")) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }
}