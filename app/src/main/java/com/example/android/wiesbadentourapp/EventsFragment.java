package com.example.android.wiesbadentourapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by dnj on 10/14/16.
 */

public class EventsFragment extends Fragment {

    //create blank constructor
    public EventsFragment() {

    }

    // Create view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // create and initialize array list
        final ArrayList<TourInfoItem> items = new ArrayList<TourInfoItem>();
        items.add(new TourInfoItem(R.string.events_1_g_name, R.string.events_1_e_name, R.string.events_1_hours, R.string.events_1_cost,
                "https://www.wiesbaden.de/en/tourism/events/twelve-fabulous-reasons/12r-eastermarket.php", R.string.events_1_coordinates,
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.events_2_g_name, R.string.events_2_e_name, R.string.events_2_hours, R.string.events_2_cost,
                "https://www.wiesbaden.de/en/tourism/events/twelve-fabulous-reasons/12r-cityfestival.php", R.string.events_2_coordinates,
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.events_3_g_name, R.string.events_3_e_name, R.string.events_3_hours, R.string.events_3_cost,
                "https://www.wiesbaden.de/en/tourism/events/twelve-fabulous-reasons/12r-wilhelmstrassenfest.php", R.string.events_3_coordinates,
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.events_4_g_name, R.string.events_4_e_name, R.string.events_4_hours, R.string.events_4_cost,
                "https://www.wiesbaden.de/en/tourism/events/twelve-fabulous-reasons/12r-rheingaumusicfestival.php", R.string.events_4_coordinates,
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.events_5_g_name, R.string.events_5_e_name, R.string.events_5_hours, R.string.events_5_cost,
                "https://www.wiesbaden.de/en/tourism/events/twelve-fabulous-reasons/12r-christmasmarket.php", R.string.events_5_coordinates,
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.events_6_g_name, R.string.events_6_e_name, R.string.events_6_hours, R.string.events_6_cost,
                "http://wiesbaden-oktoberfest.de", R.string.events_6_coordinates,
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.events_7_g_name, R.string.events_7_e_name, R.string.events_7_hours, R.string.events_7_cost,
                "https://www.wiesbaden.de/en/living-in-wiesbaden/festivities-markets/festivities/carnival.php", R.string.events_7_coordinates,
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.events_8_g_name, R.string.events_8_e_name, R.string.events_8_hours, R.string.events_8_cost,
                "https://www.wiesbaden.de/en/tourism/events/twelve-fabulous-reasons/12r-wine-ball.php", R.string.events_8_coordinates,
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));


        // create adapter
        TourInfoItemAdapter adapter = new TourInfoItemAdapter(getActivity(), items, R.color.primaryLight);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view_id);
        listView.setAdapter(adapter);

        // create and set item onclick listener to list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TourInfoItem item = items.get(position);
                Intent website = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getmWebsite()));
                startActivity(website);
            }
        });

        return rootView;
    }
}
