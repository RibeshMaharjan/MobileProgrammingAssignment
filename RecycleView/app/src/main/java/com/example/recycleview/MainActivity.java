package com.example.recycleview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] myArray = {
            "Ferrari", "McLaren", "Jaguar", "Skoda", "Suzuki", "Hyundai", "Toyota",
            "Renault", "Mercedes", "BMW", "Ford", "Honda", "Chevrolet", "Volkswagen",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, Arrays.asList(myArray));
        recyclerView.setAdapter(adapter);
    }
}
