package com.bignerdranch.android.studyapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by user on 7/19/2017.
 */

public class Fragment2 extends Fragment {

    FragmentListener fragmentListener;
    Button button;
    public interface FragmentListener{
         void onListen();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            fragmentListener = (FragmentListener)activity;
        }catch(Exception e){

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.fragment2,container,false);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListener.onListen();
            }
        });
        return view;
    }
}
