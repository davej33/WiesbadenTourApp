package com.example.android.wiesbadentourapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dnj on 10/14/16.
 */

public class TourInfoItemAdapter extends ArrayAdapter<TourInfoItem> {

    // variable
    private int mColorID;

    // constructor
    public TourInfoItemAdapter(Context context, ArrayList<TourInfoItem> items, int color){
        super(context, 0 , items);
        mColorID = color;
    }

    // create view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // inflate view if necessary
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_view,parent,false);
        }

        // get item location in arraylist
        final TourInfoItem currentItem = getItem(position);

        // create and set text views
        TextView defaultName = (TextView) listItemView.findViewById(R.id.default_name_view);
        defaultName.setText(currentItem.getmTourItemNameDefault());

        TextView germanName = (TextView) listItemView.findViewById(R.id.german_name_view);
        germanName.setText(currentItem.getmTourItemNameGerman());
        germanName.setTypeface(null, Typeface.BOLD);

        TextView hours = (TextView) listItemView.findViewById(R.id.hours_view);
        TextView cost = (TextView) listItemView.findViewById(R.id.cost_view);

        // determine if third and fourth have text for particular fragment
        if(currentItem.hasText()){
            // if so, create and set text views
            hours.setText(currentItem.getmHoursOpen());
            hours.setVisibility(View.VISIBLE);

            cost.setText(currentItem.getmCost());
            cost.setVisibility(View.VISIBLE);

            // set layout_weight for each linear layout
            LinearLayout firstLine = (LinearLayout) listItemView.findViewById(R.id.first_linear_layout);
            firstLine.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    0, 1f));
            LinearLayout secondLine = (LinearLayout) listItemView.findViewById(R.id.second_linear_layout);
            secondLine.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    0, 1f));
            LinearLayout thirdLine = (LinearLayout) listItemView.findViewById(R.id.third_linear_layout);
            thirdLine.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    0, 1f));
            LinearLayout fourthLine = (LinearLayout) listItemView.findViewById(R.id.fourth_linear_layout);
            fourthLine.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    0, 1f));
        } else {
            // if not, hide third and fourth views
            hours.setVisibility(View.GONE);
            cost.setVisibility(View.GONE);
        }

        // create and set image views
        ImageView image = (ImageView) listItemView.findViewById(R.id.image_view);

        // determine if item has an image
        if (currentItem.hasImage()){
            image.setImageResource(currentItem.getmImageResourceID());
            image.setVisibility(View.VISIBLE);
        } else {
            // if not, remove image view
            image.setVisibility(View.GONE);
        }

        // create image views for icons, go button and
        ImageView topIcon = (ImageView) listItemView.findViewById(R.id.top_icon);
        topIcon.setImageResource(currentItem.getmTopIcon());
        topIcon.setVisibility(View.VISIBLE);

        ImageView secondIcon = (ImageView) listItemView.findViewById(R.id.second_icon);
        secondIcon.setImageResource(currentItem.getmSecondIcon());
        secondIcon.setVisibility(View.VISIBLE);

        ImageView thirdIcon = (ImageView) listItemView.findViewById(R.id.third_icon);
        ImageView bottomIcon = (ImageView) listItemView.findViewById(R.id.bottom_icon);
        ImageView goButton = (ImageView) listItemView.findViewById(R.id.go_button);
        RelativeLayout itemLayout = (RelativeLayout) listItemView.findViewById(R.id.object_background);

        // determine if third and fourth lines have icons
        if (currentItem.hasIcons()){
            // if so, set
            thirdIcon.setImageResource(currentItem.getmThirdIcon());
            thirdIcon.setVisibility(View.VISIBLE);

            bottomIcon.setImageResource(currentItem.getmBottomIcon());
            bottomIcon.setVisibility(View.VISIBLE);

        } else {
            //if not, remove view and set linear weights to first and second lines
            thirdIcon.setVisibility(View.GONE);
            bottomIcon.setVisibility(View.GONE);

            LinearLayout firstLine = (LinearLayout) listItemView.findViewById(R.id.first_linear_layout);
            firstLine.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    0, 1f));
            LinearLayout secondLine = (LinearLayout) listItemView.findViewById(R.id.second_linear_layout);
            secondLine.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    0, 1f));

            // add padding
            firstLine.setPadding(4,8,0,4);
            secondLine.setPadding(4,4,0,4);

            // change item height
            itemLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 100));

            // set goButton image to play image
            goButton.setImageResource(R.drawable.play);
            goButton.setVisibility(View.VISIBLE);

            // change goButton image size
            goButton.getLayoutParams().height=24;
            goButton.getLayoutParams().width=24;
        }

        // use the hasIcons getter to determine if item contains 2 or 4 lines.
        // for items with 4 lines, create and onClick listener with map intent
        if(currentItem.hasIcons()){
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"
                        + currentItem.getmCoordinates()
                        + "?q=" + currentItem.getmCoordinates()
                        + "(" + currentItem.getmTourItemNameGerman() + ")"));
                getContext().startActivity(mapIntent);
            }
        });}

        /* Note to Reviewer: I originally included "google.navigation:?q=" instead of "geo"
            to auto-load directions, but removed because no directions available when off continent */

        // create view to set background color
        final View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorID);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
