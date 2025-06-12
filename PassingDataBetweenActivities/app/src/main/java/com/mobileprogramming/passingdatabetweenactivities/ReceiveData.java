package com.mobileprogramming.passingdatabetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReceiveData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.receivedata);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView myInfo = (TextView) findViewById(R.id.myinfo);

        Intent in = getIntent();

        String name = in.getStringExtra("name_key");
        String address = in.getStringExtra("address_key");
        String phone = in.getStringExtra("phone_key");

        myInfo.setText("Name = "+ name +"\n Address = "+address+"\n Phone No = "+phone);
    }
}