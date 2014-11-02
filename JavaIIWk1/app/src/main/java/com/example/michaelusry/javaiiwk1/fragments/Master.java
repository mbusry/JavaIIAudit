package com.example.michaelusry.javaiiwk1.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.michaelusry.javaiiwk1.R;

/**
 * Created by michael on 10/28/14.
 */
public class Master extends Fragment {


    public static final String TAG = "Master Fragment";

    private OnButtonClickListener mListener;

    private ListView lv;
    private Button btnDone;
    String[] artist = getResources().getStringArray(R.array.artist_array);

    public static Master newInstance(){
        Master frag = new Master();
        return frag;

    }

    //INTERFACE
    public interface OnButtonClickListener{
        public void displayText(String text);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        //ENFORCE INTERFACE

        if(activity instanceof OnButtonClickListener){
            mListener = (OnButtonClickListener)activity;
        }else {
            throw new IllegalArgumentException("Activity must implement OnButtonClickListener");
        }
    }

    /*
    Override
	public View onCreateView(LayoutInflater _inflater, ViewGroup _container,
			Bundle _savedInstanceState) {
		// Create and return view for this fragment.
		View view = _inflater.inflate(R.layout.display_fragment, _container, false);
		return view;
	}

     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.master_layout, container, false);
        return view;

    }

    /*

    @Override
	public void onActivityCreated(Bundle _savedInstanceState) {
		super.onActivityCreated(_savedInstanceState);

		// Get our TextView and set some text to it.
		TextView tv = (TextView)getView().findViewById(R.id.name_display);
		tv.setText("Hello World!");
	}
     */

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i(TAG, "onActivityCreated");

        lv = (ListView)getView().findViewById(R.id.listView) ;


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_selectable_list_item,
                artist);

        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i(TAG, "nameList:position: " + artist[position]);

//                tv.setText(distance[position]);

            }
        });


    }



}
