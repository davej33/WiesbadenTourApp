package com.example.android.wiesbadentourapp;

/**
 * Created by dnj on 10/14/16.
 */

public class TourInfoItem {

    private String mTourItemName;
    private String mHoursOpen;
    private String mCost;
    private int mImageResourceID;

    public TourInfoItem (String name, String hours, String cost, int image){
        mTourItemName = name;
        mHoursOpen = hours;
        mCost = cost;
        mImageResourceID = image;
    }

    public String getmTourItemName() {
        return mTourItemName;
    }

    public String getmHoursOpen() {
        return mHoursOpen;
    }

    public String getmCost() {
        return mCost;
    }

    public int getmImageResourceID() {
        return mImageResourceID;
    }
}
