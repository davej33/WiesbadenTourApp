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

public class FestivalsFragment extends Fragment {

    //create blank constructor
    public FestivalsFragment(){

    }

    // Create view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<TourInfoItem> items = new ArrayList<TourInfoItem>();
        items.add(new TourInfoItem("gname","dname","hours","cost", R.drawable.kurhaus, "https://www.espn.com", "location",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("gname","dname","hours","cost", R.drawable.kurhaus, "https://www.espn.com", "location",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("gname","dname","hours","cost", R.drawable.kurhaus, "https://www.espn.com", "location",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("gname","dname","hours","cost", R.drawable.kurhaus, "https://www.espn.com", "location",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("gname","dname","hours","cost", R.drawable.kurhaus, "https://www.espn.com", "location",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("gname","dname","hours","cost", R.drawable.kurhaus, "https://www.espn.com", "location",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("gname","dname","hours","cost", R.drawable.kurhaus, "https://www.espn.com", "location",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));
        items.add(new TourInfoItem("gname","dname","hours","cost", R.drawable.kurhaus, "https://www.espn.com", "location",
                R.drawable.german_flag, R.drawable.us_flag, R.drawable.clock, R.drawable.euro));

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
