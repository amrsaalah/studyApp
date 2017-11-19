package com.bignerdranch.android.studyapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bignerdranch.android.studyapp.RetrofitModel.RetrofitModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.bignerdranch.android.studyapp.R.id.editText2;

public class RetrofitActivity extends AppCompatActivity {
    private static final String TAG = "RetrofitActivity";

    private EditText usernameEdit , emailEdit;
    private String username , email ;
    private Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: crearing asfsfhjkasfhf");
        setContentView(R.layout.activity_retrofit);

        usernameEdit = (EditText) findViewById(R.id.editText1);
        emailEdit = (EditText)findViewById(editText2);
        button = (Button) findViewById(R.id.button);

        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(FeedAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final FeedAPI feedAPI = retrofit.create(FeedAPI.class);

        Call<RetrofitModel> call = feedAPI.getData();

        call.enqueue(new Callback<RetrofitModel>() {
            @Override
            public void onResponse(Call<RetrofitModel> call, Response<RetrofitModel> response) {
                Toast.makeText(RetrofitActivity.this  , response.body().getPosts()[1].getUsername(),Toast.LENGTH_LONG).show();
                Toast.makeText(RetrofitActivity.this  , response.body().getPosts()[1].getEmail(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<RetrofitModel> call, Throwable t) {
                Log.d(TAG, "onFailure: failure" +t.toString());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameEdit.getText().toString();
                email = emailEdit.getText().toString();

                Call<RetrofitModel> call2 = feedAPI.insertData(username , email);
                call2.enqueue(new Callback<RetrofitModel>() {
                    @Override
                    public void onResponse(Call<RetrofitModel> call, Response<RetrofitModel> response) {

                    }

                    @Override
                    public void onFailure(Call<RetrofitModel> call, Throwable t) {

                    }
                });


            }
        });

    }
}
