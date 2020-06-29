package com.example.jcefoodie;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;import java.util.Random;

public class RatePage extends AppCompatActivity {

    int count, n1, n2;
    int[] ratings;
    String foodItem;
    String[] restaurants;
    Random random = new Random();
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_page);
        Intent intent = getIntent();
        foodItem = intent.getStringExtra("foodItem");
        count = intent.getIntExtra("count",100);
        restaurants = intent.getStringArrayExtra("restaurants");
        ratings = intent.getIntArrayExtra("ratings");
        TextView textView = findViewById(R.id.textView6);
        textView.setText("Pick your favourite place for " + foodItem);
        pickTwoRestaurants(textView);
    }

    public void pickTwoRestaurants(View view) {
        n1 = random.nextInt(count);
        n2 = random.nextInt(count);
        while (n1 == n2)
            n2 = random.nextInt(count);
        button = findViewById(R.id.option1);
        button.setText(restaurants[n1]);
        button = findViewById(R.id.option2);
        button.setText(restaurants[n2]);
    }

    public  void vote (View view) {
        if (view.getId() == R.id.option2)
            n1 = n2;
        String restaurant = restaurants[n1];
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(foodItem).child(restaurant);
        reference.child("rate").setValue(ratings[n1]-1);
        Toast.makeText(this, "Thank You!", Toast.LENGTH_LONG).show();
        finish();
    }
}