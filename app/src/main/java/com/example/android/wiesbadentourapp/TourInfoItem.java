package com.example.android.wiesbadentourapp;

/**
 * Created by dnj on 10/14/16.
 */

public class TourInfoItem {

    private String mTourItemNameGerman;
    private String mTourItemNameDefault;
    private String mHoursOpen;
    private String mCost;
    private String mWebsite;
    private String mCoordinates;
    private int mImageResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public TourInfoItem (String germanName, String defaultName, String hours, String cost, int image, String website, String coordinates){
        mTourItemNameGerman = germanName;
        mTourItemNameDefault = defaultName;
        mHoursOpen = hours;
        mCost = cost;
        mImageResourceID = image;
        mWebsite = website;
        mCoordinates = coordinates;
    }

    // getter methods
    public String getmTourItemNameGerman() {
        return mTourItemNameGerman;
    }

    public String getmTourItemNameDefault() {
        return mTourItemNameDefault;
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

    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }
}
