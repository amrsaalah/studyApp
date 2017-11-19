package com.bignerdranch.android.studyapp;

import com.bignerdranch.android.studyapp.RetrofitModel.RetrofitModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by user on 10/27/2017.
 */

public interface FeedAPI {

     String BASE_URL = "http://192.168.1.101/projects/Test/";

    @GET("test.php")
    Call<RetrofitModel> getData();

    @FormUrlEncoded
    @POST("insert.php")
    Call<RetrofitModel> insertData(@Field("username") String username , @Field("email") String email);
}
