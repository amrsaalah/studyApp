package com.bignerdranch.android.studyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;
import android.widget.Toast;

public class HandlerActivity extends AppCompatActivity {

    private static final String TAG = "HandlerActivity";
    Handler handler;
    Looper looper;
    Message message ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        handler = new Handler();
        Log.d(TAG, "onCreate: thread starting");
        HandlerThread t = new HandlerThread();
        t.start();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                   // Toast.makeText(getApplicationContext() , String.valueOf(msg.arg1) , Toast.LENGTH_SHORT).show();
            }
        };
        Log.d(TAG, "onCreate: main Ui");
    }

    private class HandlerThread extends Thread {
        @Override
        public void run() {
            Looper.prepare();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext() , "test",Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "run: handler post delayed");
                }
            },3000);

            
            for (int i = 0; i < 10; i++) {
                Log.d(TAG, "run: " +i);
                message  =  handler.obtainMessage();
                message.arg1 = i ;
                handler.sendMessage(message);
                Log.d(TAG, "run: message sent");


            }
            Log.d(TAG, "run: end");
        }
    }
}
