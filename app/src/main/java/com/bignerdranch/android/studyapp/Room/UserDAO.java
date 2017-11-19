package com.bignerdranch.android.studyapp.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by user on 11/8/2017.
 */
@Dao
public interface UserDAO {

    @Query("SELECT * FROM user")
    List<User> getAlll();

    @Insert
    void insertt(User user);

    @Delete
    void deletee(User user);



}
