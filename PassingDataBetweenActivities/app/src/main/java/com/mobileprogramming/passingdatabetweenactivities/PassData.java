package com.mobileprogramming.passingdatabetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PassData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.passdata);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText myName = findViewById(R.id.idname);
        EditText myAddress = findViewById(R.id.idaddr);
        EditText myPhone = findViewById(R.id.idphn);
        Button b = findViewById(R.id.btnsub);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendName = myName.getText().toString();
                String sendAddress = myAddress.getText().toString();
                String sendPhn = myPhone.getText().toString();

                Intent intent = new Intent(getApplicationContext(),ReceiveData.class);

                intent.putExtra("name_key",sendName);
                intent.putExtra("address_key",sendAddress);
                intent.putExtra("phone_key",sendPhn);

                startActivity(intent);
            }
        });
    }
}