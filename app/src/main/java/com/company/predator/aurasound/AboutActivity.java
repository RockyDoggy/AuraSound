package com.company.predator.aurasound;


import android.os.Bundle;


public class AboutActivity extends MainActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_about);

    }
}
