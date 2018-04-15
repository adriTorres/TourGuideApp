package com.example.android.tourguide;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Region;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

/**
 * Fragment that shows a ListView of all the places related to Amusement Parks or Gardens
 * depending of which element in the drawer the user has clicked, using list.xml
 */
public class LocationListFragment extends Fragment {

    //List of all the places to show in the ListView
    private static ArrayList<Place> locations = new ArrayList<Place>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list, container, false);

        //Clear the list to show the proper places because locations is a static variable
        locations.clear();

        //Bundle to know which element has been clicked.
        Bundle bundle = this.getArguments();
        //Integer to store the value passed as bundle when the drawer element was clicked.
        int fragment = -1;

        //Check if the bundle is null.
        if (bundle != null) {
            //If not null, get the value passed as bundle to know the element clicked.
            fragment = bundle.getInt(MainActivity.FRAGMENT);
        } else {
            return view;
        }

        if (fragment == MainActivity.AMUS) {
            //If the bundle's value is AMUS it adds all the locations related to Amusement Parks
            locations.add(new Place(R.drawable.p_a_aquop, getString(R.string.amus_aquop_title), getString(R.string.amus_aquop_info), getString(R.string.amus_aquop_summ), getString(R.string.amus_aquop_loc)));
            locations.add(new Place(R.drawable.p_a_park, getString(R.string.amus_park_title), getString(R.string.amus_park_info), getString(R.string.amus_park_summary), getString(R.string.amus_park_loc)));
            locations.add(new Place(R.drawable.p_a_planet, getString(R.string.amus_planet_title), getString(R.string.amus_planet_info), getString(R.string.amus_planet_summ), getString(R.string.amus_planet_loc)));
            locations.add(new Place(R.drawable.p_a_zoo, getString(R.string.amus_zoo_title), getString(R.string.amus_zoo_info), getString(R.string.amus_zoo_summary), getString(R.string.amus_zoo_loc)));

        } else if (fragment == MainActivity.PARK) {
            //If the bundle's value is PARK it adds all the locations related to Parks and Gardens.
            locations.add(new Place(R.drawable.p_pa_capricho, getString(R.string.park_capricho_title), getString(R.string.park_capricho_info), getString(R.string.park_cap_summ), getString(R.string.park_cap_loc)));
            locations.add(new Place(R.drawable.p_pa_debod, getString(R.string.park_debod_title), getString(R.string.park_debod_info), getString(R.string.park_debod_summ), getString(R.string.park_debod_loc)));
            locations.add(new Place(R.drawable.p_pa_retiro, getString(R.string.park_retiro_title), getString(R.string.park_retiro_info), getString(R.string.park_retiro_summ), getString(R.string.park_retiro_loc)));
            locations.add(new Place(R.drawable.p_pa_rio, getString(R.string.park_rio_title), getString(R.string.park_rio_info), getString(R.string.park_rio_summ), getString(R.string.park_rio_loc)));
            locations.add(new Place(R.drawable.p_pa_sabatini, getString(R.string.park_sabat_title), getString(R.string.park_sabitini_info), getString(R.string.park_sab_summ), getString(R.string.park_sab_loc)));

        } else return view;

        /* Find the {@link ListView} object in the view hierarchy of the view activity */
        ListView listView = (ListView) view.findViewById(R.id.list);
        /* Create a {@link ListAdapter}, whose data source is a list of {@link Place}s.
         * The adapter knows how to create list items for each item in the list. */
        ListAdapter adapter = new ListAdapter(getActivity(), R.layout.element_list_layout, locations);
        /* Make the {@link ListView} use the {@link ListAdapter} */
        listView.setAdapter(adapter);

        /* Set a click item listener on the list view */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Explicit intent */
                Intent listIntent = new Intent(getActivity(), LocationActivity.class);
                /* Extra intent to know which place the user is clicking using the position as value. */
                listIntent.putExtra(MainActivity.CAT, position);
                /* Extra intent to know from which class the item was clicked if {@Link LocationListFragment} then value=LIST
                 * if {@Link CatListActivity} then value=GRID */
                listIntent.putExtra(MainActivity.FROM, MainActivity.LIST);
                startActivity(listIntent);
            }
        });

        return view;
    }

    //Getter
    public static ArrayList<Place> getLocations() {
        return locations;
    }
}
