package com.example.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetDataTask extends AsyncTask<String,Void,String> {
    public static final String TAG = "RestApi";

    public void downloadrRestData(String remoteUrl){
        Log.d(TAG, " Downloading data");
        StringBuilder sb = new StringBuilder();
        try{
            URL url = new URL(remoteUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            int responseCode = connection.getResponseCode();
            if(responseCode==HttpURLConnection.HTTP_OK){
                Log.d(TAG," Request accepted");

                InputStream inputstream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
                String line = reader.readLine();

                while(line!=null){
                    sb.append(line).append("\n");
                    line= reader.readLine();
                }
                reader.close();
            }
            else{
                Log.d(TAG," Something went wrong. Response code was"+ responseCode);
            }
        }catch(Exception e){
            Log.e(TAG," Error happened ! ");

        }


    }
   @Override
    protected String doInBackground(String... strings){
        String url = strings[0];
        Log.d(TAG,"Doing task in background for url"+ url);
        return "RESULT";
    }

}
