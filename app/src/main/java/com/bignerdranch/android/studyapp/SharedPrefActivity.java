package com.bignerdranch.android.studyapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SharedPrefActivity extends AppCompatActivity {

    String newHighScore = "newHighScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(newHighScore  , 5);
        editor.commit();


        Toast.makeText(this , String.valueOf(getInt()),Toast.LENGTH_LONG).show();
    }

    private int getInt(){
        int value = 0 ;
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        value = sharedPref.getInt(newHighScore , 0);

        return value;
    }
}
