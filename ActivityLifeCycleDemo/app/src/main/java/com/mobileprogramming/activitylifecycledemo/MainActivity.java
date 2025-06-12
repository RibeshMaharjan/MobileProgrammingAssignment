package com.mobileprogramming.activitylifecycledemo;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d(TAG, "onCreateInvoked");
    }

    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStartInvoked");
    }

    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResumeInvoked");
    }

    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPauseInvoked");
    }

    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStopInvoked");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestartInvoked");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroyInvoked");
    }
}