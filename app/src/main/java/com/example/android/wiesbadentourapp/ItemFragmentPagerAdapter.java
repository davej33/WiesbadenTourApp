package com.example.android.wiesbadentourapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by dnj on 10/14/16.
 */

public class ItemFragmentPagerAdapter extends FragmentPagerAdapter {

    // create and initialize variables
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[]{"Sites", "Food & Drink", "Events", "Phrases"};
    private Context context;

    // constructor
    public ItemFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    // tracks fragment navigation
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    // sets id value to each fragment
    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new SiteFragment();
        } else if (position == 1) {
            return new FoodDrinkFragment();
        } else if (position == 2) {
            return new EventsFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
