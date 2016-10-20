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
        items.add(new TourInfoItem(R.string.site_1_g_name, R.string.site_1_e_name, R.string.site_1_hours, R.string.free, R.drawable.kurhaus,
                "https://www.wiesbaden.de/en/tourism/conventions/kurhaus/index.php", R.string.site_1_coordinates,
                R.mipmap.german_flag, R.mipmap.us_flag, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.site_2_g_name, R.string.site_2_e_name, R.string.site_2_hours, R.string.free, R.drawable.rathaus,
                "https://www.wiesbaden.de/en/tourism/sightseeing/buildings/Rathaus.php", R.string.site_2_coordinates,
                R.mipmap.german_flag, R.mipmap.us_flag, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.site_3_g_name, R.string.site_3_e_name, R.string.site_3_hours, R.string.site_3_cost, R.drawable.biebrich_palace,
                "https://www.wiesbaden.de/en/tourism/conventions/event-venues/briebrich-palace.php", R.string.site_3_coordinates,
                R.mipmap.german_flag, R.mipmap.us_flag, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.site_4_g_name, R.string.site_4_e_name, R.string.site_4_hours, R.string.site_4_cost, R.drawable.museum,
                "https://www.wiesbaden.de/en/tourism/conventions/event-venues/museum-wiesbaden.php", R.string.site_4_coordinates,
                R.mipmap.german_flag, R.mipmap.us_flag, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.site_5_g_name, R.string.site_5_e_name, R.string.site_5_hours, R.string.free, R.drawable.boniface,
                "https://www.wiesbaden.de/en/tourism/sightseeing/churches-synagogue/St_Boniface_s_.php", R.string.site_5_coordinates,
                R.mipmap.german_flag, R.mipmap.us_flag, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.site_6_g_name, R.string.site_6_e_name, R.string.site_6_hours, R.string.free, R.drawable.russian_church,
                "https://www.wiesbaden.de/en/tourism/sightseeing/churches-synagogue/Russian_Church.php", R.string.site_6_coordinates,
                R.mipmap.german_flag, R.mipmap.us_flag, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.site_7_g_name, R.string.site_7_e_name, R.string.site_7_hours, R.string.free, R.drawable.market,
                "https://www.wiesbaden.de/en/tourism/sightseeing/streets-squares/Marktplatz.php", R.string.site_7_coordinates,
                R.mipmap.german_flag, R.mipmap.us_flag, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.site_8_g_name, R.string.site_8_e_name, R.string.site_8_hours, R.string.free, R.drawable.humor,
                "https://www.wiesbaden.de/en/culture/museum/lachmuseum/index.php", R.string.site_8_coordinates,
                R.mipmap.german_flag, R.mipmap.us_flag, R.mipmap.clock, R.mipmap.euro));

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
