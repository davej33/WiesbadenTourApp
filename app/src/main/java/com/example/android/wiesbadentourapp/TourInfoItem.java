package com.example.android.wiesbadentourapp;

/**
 * Created by dnj on 10/14/16.
 */

public class TourInfoItem {

    private String mTourItemName;
    private String mHoursOpen;
    private String mCost;
    private int mImageResourceID;
    private String mWebsite;
    private String mCoordinates;

    public TourInfoItem (String name, String hours, String cost, int image, String website, String coordinates){
        mTourItemName = name;
        mHoursOpen = hours;
        mCost = cost;
        mImageResourceID = image;
        mWebsite = website;
        mCoordinates = coordinates;
    }

    // getter methods
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

    public String getmWebsite() {
        return mWebsite;
    }

    public String getmCoordinates() {
        return mCoordinates;
    }
}
