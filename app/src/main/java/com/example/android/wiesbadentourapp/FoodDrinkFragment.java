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

        // create and initialize arraylist
        final ArrayList<TourInfoItem> items = new ArrayList<TourInfoItem>();
        items.add(new TourInfoItem("Ente","French","Daily 2-Midnight","Expensive", R.drawable.ente,
                "http://www.nassauer-hof.de/en/restaurant-ente", "50.084800,8.243511",
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("das!Burger","American","Daily 11-10","Mid-range", R.drawable.dasburger,
                "http://www.das-burger.com/en/", "50.083010,8.240282",
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("Weinguthoehn","Local","W-SU 4-11","Mid-range", R.drawable.weinguthoehn,
                "http://weinguthoehn.de/de/gutsschaenke.html", "50.063103,8.185101",
                R.mipmap.wine, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("Curry Manufaktur","German","T-SU 11-9","Cheap", R.drawable.curry,
                "https://www.facebook.com/Curry-Manufaktur-148251825217109/", "50.084188,8.239668",
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("Weingut Herborn","Local","Th-M 230-9","Higher-end", R.drawable.herborn,
                "http://www.weingut-herborn.de", "50.057453,8.161098",
                R.mipmap.wine, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("Cafe Maldaner","European Desserts","Daily 830-7","Mid-range", R.drawable.maldaner,
                "http://maldaner1859.de", "50.082516,8.239241",
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("Weingut Josef Becker","Local","W-SU 4-9","Mid-range", R.drawable.becker_winery,
                "http://www.jbbecker.de", "50.033338,8.160040",
                R.mipmap.wine, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));
        items.add(new TourInfoItem("Pub Scotch 'n' Soda","Scottish Pub","Daily 10-Midnight","Cheap", R.drawable.scotch,
                "http://www.scotchnsoda.de", "50.083996,8.240865",
                R.mipmap.knife_fork, R.mipmap.globe, R.mipmap.clock, R.mipmap.euro));

        // create adapter and set to list view
        TourInfoItemAdapter adapter = new TourInfoItemAdapter(getActivity(), items, R.color.primaryLight);
        final ListView listView = (ListView) rootView.findViewById(R.id.list_view_id);
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

