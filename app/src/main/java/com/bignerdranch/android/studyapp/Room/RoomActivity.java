package com.bignerdranch.android.studyapp.Room;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bignerdranch.android.studyapp.R;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends Activity {

    private static final String TAG = "RoomActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .addMigrations()
                .build();
        User user1 = new User();
        user1.setUsername("amrsalah");
        user1.setEmail("@yahoo.com");

        User user2 = new User();
        user2.setUsername("mohamedsalah");
        user2.setEmail("@gmail.com");
        List<User> userList = new ArrayList<>();
        userList =  db.userDAO().getAlll();
        Log.d(TAG, "onCreate: "+userList.get(0));

    }
}
