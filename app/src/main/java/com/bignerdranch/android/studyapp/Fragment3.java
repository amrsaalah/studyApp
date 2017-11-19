package com.bignerdranch.android.studyapp;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.media.session.MediaControllerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by user on 7/19/2017.
 */

public class Fragment3 extends Fragment {

    private Button button;
    private Callbacks callbacks;

    public interface Callbacks{
         void fragmentUpdate();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callbacks = (Callbacks)activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.fragment3,container,false);
        button  = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "News for you!");
                startActivity(intent);*/

                callbacks.fragmentUpdate();

                Intent i = new Intent(getActivity()  , PagerActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}
