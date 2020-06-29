package com.example.jceinsider;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText price, prepTime;
    Button saveButton;
    Spinner foodItem, restaurantName;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ref = FirebaseDatabase.getInstance().getReference();
        restaurantName = findViewById(R.id.restaurantName);
        saveButton = findViewById(R.id.save);
        price = findViewById(R.id.price);
        prepTime = findViewById(R.id.prepTime);
        foodItem = findViewById(R.id.spinner);;
    }

    public void addItem (View view){
        String restaurantName = this.restaurantName.getSelectedItem().toString();
        String price = this.price.getText().toString();
        String prepTime = this.prepTime.getText().toString();
        String foodItem= this.foodItem.getSelectedItem().toString();
        if(TextUtils.isEmpty(restaurantName)||TextUtils.isEmpty(price)||TextUtils.isEmpty(prepTime)||TextUtils.isEmpty(foodItem)) {
            Toast.makeText(this,"Enter complete details!", Toast.LENGTH_LONG).show();
        }
        else {
            Food f = new Food(restaurantName, price, prepTime);
            ref.child(foodItem).child(restaurantName).setValue(f);
            Toast.makeText(this,"Thank you!", Toast.LENGTH_LONG).show();
        }
    }
}