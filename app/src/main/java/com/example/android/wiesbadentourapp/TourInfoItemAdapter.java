package com.example.android.wiesbadentourapp;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dnj on 10/14/16.
 */

public class TourInfoItemAdapter extends ArrayAdapter<TourInfoItem> {

    private int mColorID;

    public TourInfoItemAdapter(Context context, ArrayList<TourInfoItem> items, int color){
        super(context, 0 , items);
        mColorID = color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_view,parent,false);
        }

        final TourInfoItem currentItem = getItem(position);

        TextView defaultName = (TextView) listItemView.findViewById(R.id.default_name_view);
        defaultName.setText(currentItem.getmTourItemNameDefault());

        TextView germanName = (TextView) listItemView.findViewById(R.id.german_name_view);
        germanName.setText(currentItem.getmTourItemNameGerman());
        germanName.setTypeface(null, Typeface.BOLD);

        TextView hours = (TextView) listItemView.findViewById(R.id.hours_view);
        hours.setText(currentItem.getmHoursOpen());

        TextView cost = (TextView) listItemView.findViewById(R.id.cost_view);
        cost.setText(currentItem.getmCost());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image_view);

        if (currentItem.hasImage()){
            image.setImageResource(currentItem.getmImageResourceID());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }
/*
        ImageView button = (ImageView) listItemView.findViewById(R.id.go_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String coordinates = "google.navigation:q=" + currentItem.getmCoordinates();
                Uri directions = Uri.parse(coordinates);
                Log.v("Test", "Coords: " + coordinates);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, directions);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });*/



        final View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorID);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
