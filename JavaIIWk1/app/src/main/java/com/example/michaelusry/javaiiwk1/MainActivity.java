package com.example.michaelusry.javaiiwk1;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import com.example.michaelusry.javaiiwk1.fragments.Detail;
import com.example.michaelusry.javaiiwk1.fragments.Master.OnButtonClickListener;
import com.example.michaelusry.javaiiwk1.fragments.Master;


/*

--Create a master/detail type application that utilizes two fragments
and one activity (do not use the Master/Detail template).

--Application must display the Master & Detail fragments side by side
in Landscape (Portrait is not required until week 2).

Master fragment allows the user to select from a pre-defined set of queries.

Details fragment shows the data retrieved from the query.

Application pulls data from a remote API when network is available.

Data is pulled from local storage if no network is available.

--Application checks for network connectivity at launch.

Application stores data pulled from API in a local file using Android I/O classes.

In addition to the above minimum requirements, the following functionality
is required to demonstrate mastery of the week one topics:

Master fragment allows the user to query a remote API using a dynamic query
based on user text input.

Network connectivity is checked before each network connection.

Application stores cached local data in a serializable object format.

Application properly handles all errors when a local data cache is not available while offline.

 */

public class MainActivity extends Activity implements OnButtonClickListener {

    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean online = false;

        if (isOnline()){
            System.out.println("I'm online");
            online = true;
        }else {
            Log.i("HELLO", "NOT ONLINE");
            online = false;
        }




        if(savedInstanceState == null){

            Log.i(TAG,"savedInstanceState (container1) == null");

            Master frag = Master.newInstance();
            getFragmentManager().beginTransaction()
                    .replace(R.id.container1,frag,Master.TAG)
                    .commit();
            Log.i(TAG,"savedInstanceState (container1) == null **END**");

        }

    }

    @Override
    public void displayText(String _text) {

        Log.i(TAG," - displayText");
        Detail frag = (Detail)getFragmentManager().findFragmentByTag(Detail.TAG);

        if(frag == null) {
            Log.i(TAG,"savedInstanceState (container2) == null");

            frag = Detail.newInstance(_text);
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, frag, Detail.TAG)
                    .commit();
        } else {
            frag.setDisplayText(_text);
        }
    }

    protected boolean isOnline() {
        // Getting our connectivity manager.
        ConnectivityManager mgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
// Getting our active network information.
        NetworkInfo netInfo = mgr.getActiveNetworkInfo();
// We have a network connection, but not necessarily a data connection.
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            if (netInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                // We're on 3G/4G data
            } else if (netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                // We're on WiFi data
            }
            if (netInfo.isConnected()) {
                // We have a valid data connection
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

}
