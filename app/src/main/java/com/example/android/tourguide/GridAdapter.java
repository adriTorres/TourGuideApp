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
 * based on a data source, which is a list of {@link Category} objects.
 */
public class GridAdapter extends ArrayAdapter<Category> {

    /**
     * List of Category passed in the constructor
     */
    private List<Category> categories;

    /**
     * Create a new {@link ListAdapter} object.
     *
     * @param context    is the current context (i.e. Activity) that the adapter is being created in.
     * @param source     is the activity to use as element list.
     * @param categories is the list of {@link Category}s to be displayed.
     */
    public GridAdapter(Context context, int source, ArrayList<Category> categories) {
        super(context, source, categories);
        this.categories = categories;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View gridItemView = convertView;

        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.element_grid_layout, parent, false);
        }

        // Get the {@link Category} object located at this position in the list
        Category currentCategory = categories.get(position);

        //Find and set the layout's views with the proper attributes from the current Category
        TextView nameTextView = (TextView) gridItemView.findViewById(R.id.name);
        nameTextView.setText(currentCategory.getName());

        ImageView imageView = (ImageView) gridItemView.findViewById(R.id.category_image);
        imageView.setImageResource(currentCategory.getImage());

        //Return the whole list item layout
        return gridItemView;
    }
}


