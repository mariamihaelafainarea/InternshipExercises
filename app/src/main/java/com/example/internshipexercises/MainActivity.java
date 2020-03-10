package com.example.internshipexercises;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private int incrementValue = 0;
    private TextView incrementTextView;
    private Button incrementButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: Happy to be born");
        initViews();
    }

    private void initViews() {
        incrementTextView = findViewById(R.id.counter_value_tv);
        incrementButton = findViewById(R.id.increment_bt);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementValue ++;
                incrementTextView.setText(String.valueOf(incrementValue));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart: I exist but you cannot see me");


    }

    @Override
    protected void onResume() {
        //activitatea e vizibila
        //userul poate interactiona cu aplicatia
        super.onResume();
        Log.d(TAG,"onResume: Preparing final UI changes for you master");
    }

    @Override
    protected void onPause() {
        //userul nu mai poate interactiona cu aplicatia
        //exemplu cu dialog
        super.onPause();
        Log.d(TAG,"onPause: You can see me but i don't want to interact");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop: Packing up to leave");
    }

    @Override
    protected void onDestroy() {
        //nu e garantat ca se va folosi
        super.onDestroy();
        Log.d(TAG,"onDestroy: Bye,bye !");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("TheCounter",incrementValue);

    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("TheCounter")) {
            incrementValue  = savedInstanceState.getInt("TheCounter");
            incrementTextView.setText(String.valueOf(incrementValue));
        }

    }
}
