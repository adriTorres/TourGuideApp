package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Show a ListView of places depending in which category was selected from the GridView using list.xml
 */
public class CatListActivity extends AppCompatActivity {

    //List of all the places to show in the ListView
    private static ArrayList<Place> locations = new ArrayList<Place>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //Clear the list to show the proper places because locations is a static variable
        locations.clear();

        /* Getting the intent */
        Intent myIntent = getIntent();
        /* Getting the extra intent int to know which list of places we want to see, using the grid position clicked. */
        int cat = myIntent.getIntExtra(MainActivity.CAT, 0);

        /* Find the {@link ListView} object in the view hierarchy of the view activity */
        ListView listView = (ListView) findViewById(R.id.list);

        if (cat == MainActivity.PASEO) {
            //If intent value is PASEO
            //Set the toolbar title
            this.setTitle(getString(R.string.paseo_title));

            //Add locations related to Paseo del Arte
            locations.add(new Place(R.drawable.p_p_prado, getString(R.string.paseo_prado_title), getString(R.string.paseo_prado_info), getString(R.string.paseo_prado_summ), getString(R.string.paseo_prado_add)));
            locations.add(new Place(R.drawable.p_p_cibeles, getString(R.string.paseo_cibeles_title), getString(R.string.paseo_cibeles_info), getString(R.string.paseo_cib_summ), getString(R.string.paseo_cib_add)));

        } else if (cat == MainActivity.HOUSEM) {
            //If intent value is HOUSEM
            //Set the toolbar title
            this.setTitle(getString(R.string.house_title));

            //Add locations related to House Museums
            locations.add(new Place(R.drawable.p_hm_cervantes, getString(R.string.house_cerv_title), getString(R.string.house_cerv_info), getString(R.string.house_cerv_summ), getString(R.string.house_cerv_add)));
            locations.add(new Place(R.drawable.p_hm_vega, getString(R.string.house_vega_title), getString(R.string.house_vega_info), getString(R.string.house_vega_summ), getString(R.string.house_vega_add)));
            locations.add(new Place(R.drawable.p_hm_roman, getString(R.string.house_roman_title), getString(R.string.house_roman_info), getString(R.string.house_roman_summ), getString(R.string.house_roman_add)));

        } else if (cat == MainActivity.CHURCHES) {
            //If intent value is CHURCHES
            //Set the toolbar title
            this.setTitle(getString(R.string.church_title));

            //Add locations related to Baroque Churches
            locations.add(new Place(R.drawable.p_c_francisco, getString(R.string.church_francisco_title), getString(R.string.church_francisco_info), getString(R.string.church_fran_summ), getString(R.string.church_fran_add)));
            locations.add(new Place(R.drawable.p_c_isidro, getString(R.string.church_isidro_title), getString(R.string.church_isidro_info), getString(R.string.church_isidro_summ), getString(R.string.church_isidro_add)));
            locations.add(new Place(R.drawable.p_c_marcos, getString(R.string.church_marcos_title), getString(R.string.church_marcos_info), getString(R.string.church_marcos_summ), getString(R.string.church_marcos_add)));
            locations.add(new Place(R.drawable.p_c_monserrat, getString(R.string.church_monserrat_title), getString(R.string.church_monserrat_info), getString(R.string.church_mon_summ), getString(R.string.church_mon_add)));
        }

        /* Create a {@link ListAdapter}, whose data source is a list of {@link Place}s.
         * The adapter knows how to create list items for each item in the list. */
        ListAdapter adapter = new ListAdapter(this, R.layout.element_list_layout, locations);
        /* Make the {@link ListView} use the {@link ListAdapter} */
        listView.setAdapter(adapter);

        /* Set a click item listener on the list view */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Explicit intent */
                Intent gridIntent = new Intent(CatListActivity.this, LocationActivity.class);
                /* Extra intent to know which cat's list of places we want to see. */
                gridIntent.putExtra(MainActivity.CAT, position);
                /* Extra intent to know from where the item was clicked if {@Link LocationListFragment} then value=LIST
                 * if {@Link CatListActivity} then value=GRID */
                gridIntent.putExtra(MainActivity.FROM, MainActivity.GRID);
                startActivity(gridIntent);
            }
        });
    }

    //Getter
    public static ArrayList<Place> getLocations() {
        return locations;
    }
}

