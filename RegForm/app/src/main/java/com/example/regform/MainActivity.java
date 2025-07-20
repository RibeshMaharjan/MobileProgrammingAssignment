package com.example.regform;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editName, editAge, editStudentID;
    Button btnSave;
    ListView listView;
    DBHelper dbHelper;
    ArrayAdapter<String> adapter;
    ArrayList<String> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        editStudentID = findViewById(R.id.editStudentID);
        btnSave = findViewById(R.id.btnSave);
        listView = findViewById(R.id.listView);
        dbHelper = new DBHelper(this);
        studentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listView.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String age = editAge.getText().toString();
                String studentID = editStudentID.getText().toString();

                dbHelper.insertData(name, age, studentID);
                loadData();
                editName.setText("");
                editAge.setText("");
                editStudentID.setText("");
            }
        });

        loadData();
    }

    private void loadData() {
        studentList.clear();
        Cursor cursor = dbHelper.getAllData();
        while (cursor.moveToNext()) {
            String data = "Name: " + cursor.getString(1) +
                    ", Age: " + cursor.getString(2) +
                    ", ID: " + cursor.getString(3);
            studentList.add(data);
        }
        adapter.notifyDataSetChanged();
    }
}
