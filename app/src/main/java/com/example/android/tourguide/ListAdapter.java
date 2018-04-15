package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link ListAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Place} objects.
 */
public class ListAdapter extends ArrayAdapter<Place> {

    /**
     * List of Place passed in the constructor
     */
    private List<Place> locations;

    /**
     * Create a new {@link ListAdapter} object.
     *
     * @param context   is the current context (i.e. Activity) that the adapter is being created in.
     * @param source    is the activity to use as element list.
     * @param locations is the list of {@link Place}s to be displayed.
     */
    public ListAdapter(Context context, int source, ArrayList<Place> locations) {
        super(context, source, locations);
        this.locations = locations;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.element_list_layout, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        Place currentCategory = locations.get(position);

        //Find and set the layout's views with the proper attributes from the current Place
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.location_image);
        imageView.setImageResource(currentCategory.getImage());

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.list_title);
        titleTextView.setText(currentCategory.getTitle());

        TextView infoTextView = (TextView) listItemView.findViewById(R.id.list_description);
        infoTextView.setText(currentCategory.getInfo());

        //Return the whole list item layout
        return listItemView;
    }
}

