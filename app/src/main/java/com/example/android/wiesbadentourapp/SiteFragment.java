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

public class SiteFragment extends Fragment {

    // empty constructor
    public SiteFragment(){
    }

    // onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // create ArrayList using TourInfoItem objects
        final ArrayList<TourInfoItem> items = new ArrayList<TourInfoItem>();
        items.add(new TourInfoItem("Kurhaus", "Cure House", "T-F 9-5; SA/SU 10-4", "Free", R.drawable.kurhaus,
                "https://www.wiesbaden.de/en/tourism/conventions/kurhaus/index.php", "50.084722,8.2475",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("Neues Rathaus","Town Hall", "M-F 8-4; SA: 9-12", "Free", R.drawable.kurhaus,
                "https://www.wiesbaden.de/en/tourism/sightseeing/buildings/Rathaus.php", "50.081797,8.242116",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("Schloss Biebrich","Biebrich Palace", "TH-SU 10-3", "7", R.drawable.kurhaus,
                "https://www.wiesbaden.de/en/tourism/conventions/event-venues/briebrich-palace.php", "50.037617,8.234129",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("Museum Wiesbaden","Wiesbaden Museum", "T-SU 9-4", "5", R.drawable.kurhaus,
                "https://www.wiesbaden.de/en/tourism/conventions/event-venues/museum-wiesbaden.php", "50.077735,8.245948",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("Bonifatiuskirche","St. Boniface Catholic Church", "Daily 8-6", "Free", R.drawable.kurhaus,
                "https://www.wiesbaden.de/en/tourism/sightseeing/churches-synagogue/St_Boniface_s_.php", "50.079451,8.239630",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("Kirche Russische","Russian Orthodox Church", "Daily 10-4", "Free", R.drawable.kurhaus,
                "https://www.wiesbaden.de/en/tourism/sightseeing/churches-synagogue/Russian_Church.php", "50.097789,8.234713",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("Marketplatz","Market Square", "24/7", "Free", R.drawable.kurhaus,
                "https://www.wiesbaden.de/en/tourism/sightseeing/streets-squares/Marktplatz.php", "50.081326,8.242725",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("Harlekinäum","Museum of Humour", "M-SA 9-4", "10", R.drawable.kurhaus,
                "https://www.wiesbaden.de/en/culture/museum/lachmuseum/index.php", "50.055214,8.305569",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));

        // create instance of custom adapter and set to listview
        TourInfoItemAdapter adapter = new TourInfoItemAdapter(getActivity(), items, R.color.primaryLight);
        final ListView listView = (ListView) rootView.findViewById(R.id.list_view_id);
        listView.setAdapter(adapter);

        // create and set item onclick listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TourInfoItem item = items.get(position);
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getmWebsite()));
                startActivity(browser);
            }
        });
        return rootView;

    }

}
