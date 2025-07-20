package com.example.jsonparse;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btnParse;
    TextView textView;

    String jsonData = "[{\"name\":\"Minni\",\"age\":19},{\"name\":\"Mouse\",\"age\":21}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParse = findViewById(R.id.btnParse);
        textView = findViewById(R.id.textView);

        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parseJSON();
            }
        });
    }

    private void parseJSON() {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String name = obj.getString("name");
                int age = obj.getInt("age");

                builder.append("Name: ").append(name).append("\n");
                builder.append("Age: ").append(age).append("\n\n");
            }

            textView.setText(builder.toString());

        } catch (Exception e) {
            textView.setText("Error parsing JSON");
        }
    }
}
