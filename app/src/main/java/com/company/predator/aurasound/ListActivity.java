package com.company.predator.aurasound;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends MainActivity {

    public  static String TAG = "List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView soundsList = (ListView) findViewById(R.id.listSounds);

        ArrayAdapter<String> arrayAdapter;
        //arrayAdapter = new ArrayAdapter<String>(this, R.);
        //soundsList.setAdapter(arrayAdapter);
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
