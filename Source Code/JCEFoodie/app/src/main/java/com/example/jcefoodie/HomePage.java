package com.example.jcefoodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        auth = FirebaseAuth.getInstance();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_us:
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
                break;
            case R.id.sign_out:
                auth.signOut();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void sandwichClick (View view) {
        Intent intent = new Intent(this, RankPage.class);
        intent.putExtra("foodItem", "Sandwich");
        startActivity(intent);
    }
    public void oreoClick (View view) {
        Intent intent = new Intent(this, RankPage.class);
        intent.putExtra("foodItem", "Oreo Shake");
        startActivity(intent);
    }
    public void samosaClick (View view) {
        Intent intent = new Intent(this, RankPage.class);
        intent.putExtra("foodItem", "Samosa");
        startActivity(intent);
    }
    public void teaClick (View view) {
        Intent intent = new Intent(this, RankPage.class);
        intent.putExtra("foodItem", "Coffee");
        startActivity(intent);
    }
    public void gobiClick (View view) {
        Intent intent = new Intent(this, RankPage.class);
        intent.putExtra("foodItem", "Gobi Manchurian");
        startActivity(intent);
    }
    public void mealClick (View view) {
        Intent intent = new Intent(this, RankPage.class);
        intent.putExtra("foodItem", "Meals");
        startActivity(intent);
    }
    public void noodlesClick (View view) {
        Intent intent = new Intent(this, RankPage.class);
        intent.putExtra("foodItem", "Noodles");
        startActivity(intent);
    }
    public void burgerClick (View view) {
        Intent intent = new Intent(this, RankPage.class);
        intent.putExtra("foodItem", "Burger");
        startActivity(intent);
    }
    private Boolean exit = false;
    public void onBackPressed() {
        if (exit) {
            moveTaskToBack(true); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.", Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
        }
    }
}