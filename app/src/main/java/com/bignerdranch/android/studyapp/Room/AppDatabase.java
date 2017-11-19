package com.bignerdranch.android.studyapp.Room;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by user on 11/8/2017.
 */
@Database(entities = {User.class} , version = 3 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
}
