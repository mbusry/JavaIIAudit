package com.example.michaelusry.javaiiwk1.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.michaelusry.javaiiwk1.R;

/**
 * Created by michael on 10/28/14.
 */
public class Detail extends Fragment {

    public static final String TAG = "Detail Fragment";
    private static final String ARG_TEXT = "DisplayFragment.ARG_TEXT";



    public static Detail newInstance(String _text){
        Detail frag = new Detail();

        Bundle args = new Bundle();
        args.putString(ARG_TEXT, _text);
        frag.setArguments(args);

        return frag;

    }

    @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container,
                             Bundle _savedInstanceState) {
        View view = _inflater.inflate(R.layout.detail_layout, _container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i(TAG, "onActivityCreated");

        Bundle args = getArguments();
        if(args != null && args.containsKey(ARG_TEXT)) {
            setDisplayText(args.getString(ARG_TEXT));
        }

    }

    public void setDisplayText(String text) {
        TextView tv = (TextView)getView().findViewById(R.id.label1);
        tv.setText(text);
    }



}
