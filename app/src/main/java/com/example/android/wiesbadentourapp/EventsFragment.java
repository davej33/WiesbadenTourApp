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
    public EventsFragment(){

    }

    // Create view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<TourInfoItem> items = new ArrayList<TourInfoItem>();
        items.add(new TourInfoItem("Easter Market","MAR 10-12 2017","9-Midnight","Free",
                "https://www.wiesbaden.de/en/tourism/events/twelve-fabulous-reasons/12r-eastermarket.php", "50.081326,8.242725",
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("Wine Ball","MAY 16 2017","8-Midnight","50",
                "https://www.wiesbaden.de/en/tourism/events/twelve-fabulous-reasons/12r-wine-ball.php", "50.084722,8.2475",
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("City Festival","SEP 21-23 2017","9-Midnight","Free",
                "https://www.wiesbaden.de/en/tourism/events/twelve-fabulous-reasons/12r-cityfestival.php", "50.081326,8.242725",
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("Theatrium","JUNE 10-11 2017","9-Midnight","Free",
                "https://www.wiesbaden.de/en/tourism/events/twelve-fabulous-reasons/12r-wilhelmstrassenfest.php", "50.082166,8.244771",
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("Rheingau Music Fest","18 JUNE to 27 AUG 2017","TBD - Locations Vary","Free - 40",
                "https://www.wiesbaden.de/en/tourism/events/twelve-fabulous-reasons/12r-rheingaumusicfestival.php", "50.084233,8.245764",
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("Christmas Market","NOV 22 - DEC 23 2016","9-Midnight","Free",
                "https://www.wiesbaden.de/en/tourism/events/twelve-fabulous-reasons/12r-christmasmarket.php", "50.081326,8.242725",
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("Oktoberfest","SEP 29 - OCT 10 2017","4-Midnight","Free - 30",
                "http://wiesbaden-oktoberfest.de", "50.081326,8.242725",
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("Fasching (Carnival)","FEB 3 - MAR 1","24/7","Free",
                "https://www.wiesbaden.de/en/living-in-wiesbaden/festivities-markets/festivities/carnival.php", "50.081326,8.242725",
                R.mipmap.events, R.mipmap.calendar, R.mipmap.clock, R.mipmap.euro));

        TourInfoItemAdapter adapter = new TourInfoItemAdapter(getActivity(), items, R.color.primaryLight);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view_id);
        listView.setAdapter(adapter);

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
