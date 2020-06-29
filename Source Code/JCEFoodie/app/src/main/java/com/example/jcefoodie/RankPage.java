package com.example.jcefoodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RankPage extends AppCompatActivity {

    boolean rank1 = true, rank2 = true, rank3 = true;
    int count = 0;
    int[] ratings = new int[4];
    String foodItem, text;
    String[] restaurants = new String[4];
    String[] locations = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_page);
        Intent intent = getIntent();
        foodItem = intent.getStringExtra("foodItem");
        TextView textView = findViewById(R.id.textView5);
        text = "Popular Places in JCE for " + foodItem;
        textView.setText(text);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(foodItem);
        reference.orderByChild("rate").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (rank1) {
                        TextView textView = findViewById(R.id.textView1);
                        text = "1. "+snapshot.getKey() +"\nPreparation Time: " +snapshot.child("prepTime").getValue()+" minutes\nPrice: Rs." +snapshot.child("price").getValue();
                        textView.setText(text);
                        ImageButton button = findViewById(R.id.imageButton1);
                        button.setBackgroundResource(R.drawable.map_pointer);
                        rank1 = false;
                    } else if (rank2) {
                        TextView textView = findViewById(R.id.textView2);
                        text = "2. "+snapshot.getKey() +"\nPreparation Time: " +snapshot.child("prepTime").getValue()+" minutes\nPrice: Rs." +snapshot.child("price").getValue();
                        textView.setText(text);
                        ImageButton button = findViewById(R.id.imageButton2);
                        button.setBackgroundResource(R.drawable.map_pointer);
                        rank2 = false;
                    } else if (rank3) {
                        TextView textView = findViewById(R.id.textView3);
                        text = "3. "+snapshot.getKey() +"\nPreparation Time: " +snapshot.child("prepTime").getValue()+" minutes\nPrice: Rs." +snapshot.child("price").getValue();
                        textView.setText(text);
                        ImageButton button = findViewById(R.id.imageButton3);
                        button.setBackgroundResource(R.drawable.map_pointer);
                        rank3 = false;
                    } else {
                        TextView textView = findViewById(R.id.textView4);
                        text = "4. "+snapshot.getKey() +"\nPreparation Time: " +snapshot.child("prepTime").getValue()+" minutes\nPrice: Rs." +snapshot.child("price").getValue();
                        textView.setText(text);
                        ImageButton button = findViewById(R.id.imageButton4);
                        button.setBackgroundResource(R.drawable.map_pointer);
                    }
                    locations[count] = snapshot.child("gmapLink").getValue(String.class);
                    ratings[count] = snapshot.child("rate").getValue(int.class);
                    restaurants[count++] = snapshot.getKey();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void gotoRatePage (View view) {
        if (count != 0) {
            Intent intent = new Intent(this, RatePage.class);
            intent.putExtra("foodItem", foodItem);
            intent.putExtra("count", count);
            intent.putExtra("restaurants", restaurants);
            intent.putExtra("ratings", ratings);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Please wait!", Toast.LENGTH_SHORT).show();
        }
    }

    public void r1 (View view) {
        try {
            Uri uri = Uri.parse(locations[0]);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (Exception e) {
            //Just wait for DB to load
        }
    }
    public void r2 (View view) {
        try {
            Uri uri = Uri.parse(locations[1]);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (Exception e) {
            //Just wait for DB to load
        }
    }
    public void r3 (View view) {
        try {
            Uri uri = Uri.parse(locations[2]);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (Exception e) {
            //Just wait for DB to load
        }
    }
    public void r4 (View view) {
        try {
            Uri uri = Uri.parse(locations[3]);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (Exception e) {
            //Just wait for DB to load
        }
    }
}