package com.example.android.wiesbadentourapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dnj on 10/14/16.
 */

public class TourInfoItemAdapter extends ArrayAdapter<TourInfoItemAdapter> {

    private int mColorID;

    public TourInfoItemAdapter(Context context, ArrayList<TourInfoItemAdapter> items, int color){
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

        TextView name = (TextView) listItemView.findViewById(R.id.name_view);
        name.setText(currentItem.getmTourItemName());

        TextView hours = (TextView) listItemView.findViewById(R.id.hours_view);
        hours.setText(currentItem.getmHoursOpen());

        TextView cost = (TextView) listItemView.findViewById(R.id.cost_view);
        cost.setText(currentItem.getmCost());

        return listItemView;
    }
}
