package com.example.android.tourguide;

import android.app.FragmentManager;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Resources (images, text) used in this project from https://www.esmadrid.com/en
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * CONSTANTS
     * <p>
     * Constants used to select the proper fragment between "Amusement Parks" and "Parks and Gardens"
     */
    public final static String FRAGMENT = "fragment";
    public final static int AMUS = 0;
    public final static int PARK = 1;

    /**
     * Constants used to select which category from "Art and Culture" the user is clicking.
     */
    public final static String CAT = "cat";
    public final static int PASEO = 0;
    public final static int HOUSEM = 1;
    public final static int CHURCHES = 2;

    /**
     * Constants used to known if an element in {@link LocationActivity} from a list is clicked
     * from {@link CatListActivity} or {@link LocationListFragment}
     */
    public final static String FROM = "from";
    public final static int GRID = 0;
    public final static int LIST = 1;

    /**
     * Auto-generated method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().getItem(0).setChecked(true);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
    }

    /**
     * Auto-generated method to set the button.
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();
        LocationListFragment lf = new LocationListFragment();
        Bundle bund = new Bundle();

        /* Jump to different fragments depending on which drawer element is clicked
         * To know which element has been clicked between amus or parks, it sends a bundle with the
         * key FRAGMENT and the proper value using constants.
         */
        if (id == R.id.nav_home) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new HomeFragment()).commit();
        } else if (id == R.id.nav_art) {
            GridFragment gf = new GridFragment();
            fragmentManager.beginTransaction().replace(R.id.content_frame, gf).commit();
        } else if (id == R.id.nav_amus) {
            bund.putInt(FRAGMENT, AMUS);
            lf.setArguments(bund);
            fragmentManager.beginTransaction().replace(R.id.content_frame, lf).commit();
        } else if (id == R.id.nav_parks) {
            bund.putInt(FRAGMENT, PARK);
            lf.setArguments(bund);
            fragmentManager.beginTransaction().replace(R.id.content_frame, lf).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
