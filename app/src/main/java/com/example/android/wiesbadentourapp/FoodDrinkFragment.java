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

public class FoodDrinkFragment extends Fragment {

    public FoodDrinkFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        // create view
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // create and initialize array list
        final ArrayList<TourInfoItem> items = new ArrayList<TourInfoItem>();
        items.add(new TourInfoItem(R.string.food_1_g_name, R.string.food_1_e_name, R.string.food_1_hours, R.string.food_1_cost, R.drawable.ente,
                "http://www.nassauer-hof.de/en/restaurant-ente", R.string.food_1_coordinates,
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.food_2_g_name, R.string.food_2_e_name, R.string.food_2_hours, R.string.food_2_cost, R.drawable.dasburger,
                "http://www.das-burger.com/en/", R.string.food_2_coordinates,
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.food_3_g_name, R.string.food_3_e_name, R.string.food_3_hours, R.string.food_3_cost, R.drawable.weinguthoehn,
                "http://weinguthoehn.de/de/gutsschaenke.html", R.string.food_3_coordinates,
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.food_4_g_name, R.string.food_4_e_name, R.string.food_4_hours, R.string.food_4_cost, R.drawable.curry,
                "https://www.facebook.com/Curry-Manufaktur-148251825217109/", R.string.food_4_coordinates,
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.food_5_g_name, R.string.food_5_e_name, R.string.food_5_hours, R.string.food_5_cost, R.drawable.herborn,
                "http://www.weingut-herborn.de", R.string.food_5_coordinates,
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.food_6_g_name, R.string.food_6_e_name, R.string.food_6_hours, R.string.food_6_cost, R.drawable.maldaner,
                "http://maldaner1859.de", R.string.food_6_coordinates,
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.food_7_g_name, R.string.food_7_e_name, R.string.food_7_hours, R.string.food_7_cost, R.drawable.becker_winery,
                "http://www.jbbecker.de", R.string.food_7_coordinates,
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem(R.string.food_8_g_name, R.string.food_8_e_name, R.string.food_8_hours, R.string.food_8_cost, R.drawable.scotch,
                "http://www.scotchnsoda.de", R.string.food_8_coordinates,
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));

        // create adapter
        TourInfoItemAdapter adapter = new TourInfoItemAdapter(getActivity(), items, R.color.primaryLight);
        final ListView listView = (ListView) rootView.findViewById(R.id.list_view_id);
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

