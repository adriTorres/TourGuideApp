package com.example.android.tourguide;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Fragment that shows all the Art and Culture categories in the system as a GridView using grid.xml
 */
public class GridFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid, container, false);

        //List of all the categories.
        ArrayList<Category> cats = new ArrayList<Category>();
        //Add the categories to the list.
        cats.add(new Category(R.drawable.cat_paseo, getString(R.string.cat_paseo_title)));
        cats.add(new Category(R.drawable.cat_housem, getString(R.string.cat_housem_title)));
        cats.add(new Category(R.drawable.cat_churches, getString(R.string.cat_church_title)));

        //Find the GridView Object
        GridView gridView = (GridView) view.findViewById(R.id.gridview);
        /* Create a GridAdapter
         * The adapter knows how to create list items for each item in the list.
         */
        GridAdapter adapter = new GridAdapter(getActivity(), R.layout.element_grid_layout, cats);
        /* Make the {@link GridView} use the {@link GridAdapter} */
        gridView.setAdapter(adapter);

        /* Set a click item listener on the grid view */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Explicit intent */
                Intent gridIntent = new Intent(getActivity(), CatListActivity.class);
                /* Extra intent to know which category's list of places we want to see using the position as value. */
                gridIntent.putExtra(MainActivity.CAT, position);
                startActivity(gridIntent);
            }
        });

        return view;
    }
}
