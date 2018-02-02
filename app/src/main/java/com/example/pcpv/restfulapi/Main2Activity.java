package com.example.pcpv.restfulapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SerializedObjectDemo serializedObjectDemo = (SerializedObjectDemo) getIntent().getExtras().getSerializable("data");
        Log.i(TAG, "onCreate: "+serializedObjectDemo.getName());
    }
}
