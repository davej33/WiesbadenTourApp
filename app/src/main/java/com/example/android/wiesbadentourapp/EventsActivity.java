package com.example.android.wiesbadentourapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // inserts related fragment into layout textview.
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new EventsFragment()).commit();
    }
}
