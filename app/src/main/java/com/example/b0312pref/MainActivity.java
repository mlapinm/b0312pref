package com.example.b0312pref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private TextView textView1;
    private int counter1 = 0;
    private final static String sCouter1 = "counter1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);

        pref = getSharedPreferences("TABLE", MODE_PRIVATE);
        counter1 = readData();
        textView1.setText(String.valueOf(counter1));

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveData(counter1);
    }

    public void onClick1(View view) {
        counter1++;
        textView1.setText(String.valueOf(counter1));
    }

    private void saveData(int counter1){
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(sCouter1, counter1);
        editor.apply();
    }

    private int readData(){
        counter1 = pref.getInt(sCouter1, 0);
        return counter1;
    }

}