package com.example.android.wiesbadentourapp;

/**
 * Created by dnj on 10/14/16.
 */

public class TourInfoItem {

    // variables
    private int mTourItemNameGerman;
    private int mTourItemNameDefault;
    private int mHoursOpen = NO_IMAGE_PROVIDED;
    private int mCost;
    private String mWebsite;
    private int mCoordinates;
    private int mTopIcon = NO_IMAGE_PROVIDED;
    private int mSecondIcon = NO_IMAGE_PROVIDED;
    private int mThirdIcon = NO_IMAGE_PROVIDED;
    private int mBottomIcon = NO_IMAGE_PROVIDED;
    private int mImageResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioClip;

    // constructor with image for sites and food/drink
    public TourInfoItem (int germanName, int defaultName, int hours, int cost, int image,
                         String website, int coordinates, int topIcon, int secondIcon, int thirdIcon, int bottomIcon){
        mTourItemNameGerman = germanName;
        mTourItemNameDefault = defaultName;
        mHoursOpen = hours;
        mCost = cost;
        mImageResourceID = image;
        mWebsite = website;
        mCoordinates = coordinates;
        mTopIcon = topIcon;
        mSecondIcon = secondIcon;
        mThirdIcon = thirdIcon;
        mBottomIcon = bottomIcon;
    }

    // constructor without image for events fragment
    public TourInfoItem (int germanName, int defaultName, int hours, int cost, String website,
                         int coordinates, int topIcon, int secondIcon, int thirdIcon, int bottomIcon){
        mTourItemNameGerman = germanName;
        mTourItemNameDefault = defaultName;
        mHoursOpen = hours;
        mCost = cost;
        mWebsite = website;
        mCoordinates = coordinates;
        mTopIcon = topIcon;
        mSecondIcon = secondIcon;
        mThirdIcon = thirdIcon;
        mBottomIcon = bottomIcon;

    }

    // constructor for phrases fragment
    public TourInfoItem (int germanName, int defaultName, int audioClip, int topIcon, int secondIcon){
        mTourItemNameGerman = germanName;
        mTourItemNameDefault = defaultName;
        mAudioClip = audioClip;
        mTopIcon = topIcon;
        mSecondIcon = secondIcon;
    }


    // getter methods
    public int getmTourItemNameGerman() {
        return mTourItemNameGerman;
    }

    public int getmTourItemNameDefault() {
        return mTourItemNameDefault;
    }

    public int getmHoursOpen() {
        return mHoursOpen;
    }

    public int getmCost() {
        return mCost;
    }

    public int getmImageResourceID() {
        return mImageResourceID;
    }

    public String getmWebsite() {
        return mWebsite;
    }

    public int getmCoordinates() {
        return mCoordinates;
    }

    public int getmTopIcon() {return mTopIcon;}

    public int getmSecondIcon() {
        return mSecondIcon;
    }

    public int getmThirdIcon(){return mThirdIcon;}

    public int getmBottomIcon() {
        return mBottomIcon;
    }

    public boolean hasIcons(){ return mThirdIcon != NO_IMAGE_PROVIDED; }

    public boolean hasText(){ return mHoursOpen != NO_IMAGE_PROVIDED;}

    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

    public int getmAudioClip(){ return mAudioClip; }
}
