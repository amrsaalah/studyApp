package com.bignerdranch.android.studyapp;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment3.Callbacks , Fragment2.FragmentListener {

    FragmentManager fragmentManager;
    Boolean flag= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      fragmentManager =  getSupportFragmentManager();
        Fragment fragment1 = fragmentManager.findFragmentById(R.id.fragment1_container);
        Fragment fragment3 = fragmentManager.findFragmentById(R.id.fragment3_container);
        if(fragment1 == null || fragment3 == null)
        {
            fragment1 = new Fragment1();
            fragment3 = new Fragment3();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment1_container,fragment1)
                    .add(R.id.fragment3_container,fragment3)
                    .commit();
        }
    }

    @Override
    public void fragmentUpdate() {
        if(flag) {
            Fragment fragment2 = new Fragment2();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment1_container, fragment2)
                    .commit();
            flag = false;
        }
        else{
            Fragment fragment1 = new Fragment1();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment1_container, fragment1)
                    .commit();
            flag = true;
        }
    }

    @Override
    public void onListen() {
        Toast.makeText(MainActivity.this  , "hey" , Toast.LENGTH_LONG).show();
    }
}
