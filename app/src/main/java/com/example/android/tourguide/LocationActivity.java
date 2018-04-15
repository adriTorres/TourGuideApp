package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Shows the place information selected from a ListView using content_main.xml
 */
public class LocationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        /* Getting the intent */
        Intent myIntent = getIntent();
        /* Getting the extra intent to know which place we want to see, getting its position in the List. */
        int pos = myIntent.getIntExtra(MainActivity.CAT, 0);
        /* Getting the extra intent to know from where the element was selected,
         * LocationListFragment or CatListActivity. */
        int from = myIntent.getIntExtra(MainActivity.FROM, 0);

        //Place used to store the place that was clicked.
        Place location = null;

        if(from==MainActivity.GRID){
            //If value is GRID, get the place from CatListActivity's list using its position.
            location = CatListActivity.getLocations().get(pos);
        }
        else if(from==MainActivity.LIST){
            //If value equals LIST, get the place from LocationListFragment's list using its position.
            location = LocationListFragment.getLocations().get(pos);
        }

        //If location has changed and it's not null.
        if(location != null) {
            //Set toolbar title as the place's title
            setTitle(location.getTitle());

            //Find views and set their texts/images using the Place attr.
            TextView title = (TextView) findViewById(R.id.content_title);
            title.setText(location.getTitle());

            TextView info = (TextView) findViewById(R.id.content_summary);
            info.setText(location.getSummary());

            ImageView image = (ImageView) findViewById(R.id.content_image);
            image.setImageResource(location.getImage());

            TextView link = (TextView) findViewById(R.id.content_bottomText);
            link.setText(location.getLocation());

            TextView address = (TextView) findViewById(R.id.address_text);
            address.setText(R.string.adress);
            //Make the address TextView visible
            address.setVisibility(View.VISIBLE);
        }
    }
}
