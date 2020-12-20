package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
private static final String TAG = "RestApp";
private static final String REMOTE_API = "https://jsonplaceholder.typicode.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(TAG,"On Create : Starting Download of Web Service Data");
        GetDataTask  dataObj = new GetDataTask();
        dataObj.execute(REMOTE_API);
        Log.d(TAG,"Finished downloading the data");
    }
}