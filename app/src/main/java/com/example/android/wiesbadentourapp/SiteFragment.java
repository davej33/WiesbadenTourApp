package com.example.android.wiesbadentourapp;

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
        items.add(new TourInfoItem("Kurhaus - Cure House", "T-F: 9-5 & SAT/SUN: 10-4", "Free", R.mipmap.ic_launcher,
                "https://www.wiesbaden.de/en/tourism/conventions/kurhaus/index.php", "geo:50.084722,8.2475"));
        items.add(new TourInfoItem("Neues Rathaus - Town Hall", "M-F: 8-4 & SAT: 9-12", "Free", R.mipmap.ic_launcher,
                "https://www.wiesbaden.de/en/tourism/sightseeing/buildings/Rathaus.php", "geo:50.081797,8.242116"));
        items.add(new TourInfoItem("Schloss Biebrich - Biebrich Palace", "TH-SUN: 10-3", "Free", R.mipmap.ic_launcher,
                "https://www.wiesbaden.de/en/tourism/conventions/event-venues/briebrich-palace.php", "geo:50.037617,8.234129"));
        items.add(new TourInfoItem("Museum Wiesbaden - Wiesbaden Museum", "T-SUN: 9-4", "5 Euro", R.mipmap.ic_launcher,
                "https://www.wiesbaden.de/en/tourism/conventions/event-venues/museum-wiesbaden.php", "geo:50.077735,8.245948"));
        items.add(new TourInfoItem("Bonifatiuskirche - St. Boniface Catholic Church", "Daily 8-6", "Free", R.mipmap.ic_launcher,
                "https://www.wiesbaden.de/en/tourism/sightseeing/churches-synagogue/St_Boniface_s_.php", "geo:50.079451,8.239630"));
        items.add(new TourInfoItem("St. Elizabeth's Church - Russian Orthodox", "Daily 10-4", "Free", R.mipmap.ic_launcher,
                "https://www.wiesbaden.de/en/tourism/sightseeing/churches-synagogue/Russian_Church.php", "geo:50.097789,8.234713"));

        // create instance of custom adapter and set to listview
        TourInfoItemAdapter adapter = new TourInfoItemAdapter(getActivity(), items, R.color.colorAccent);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view_id);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TourInfoItem item = items.get(position);
            }
        });

        return rootView;

    }
}
