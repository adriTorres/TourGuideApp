package com.example.android.tourguide;

import android.app.Fragment;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Fragment with general information about Madrid used as Home layout using content_main.xml
 * Set all the TextViews and ImageViews needed.
 */
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);

        //Find the views and set the Madrid info.
        TextView link = (TextView) view.findViewById(R.id.content_bottomText);
        link.setText(getString(R.string.web_link));
        //Set the text as a web link
        Linkify.addLinks(link, Linkify.WEB_URLS);

        ImageView image = (ImageView) view.findViewById(R.id.content_image);
        image.setImageResource(R.drawable.madrid);

        TextView title = (TextView) view.findViewById(R.id.content_title);
        title.setText(getString(R.string.home_title));

        TextView summ = (TextView) view.findViewById(R.id.content_summary);
        summ.setText(getString(R.string.home_info));

        return view;
    }
}
