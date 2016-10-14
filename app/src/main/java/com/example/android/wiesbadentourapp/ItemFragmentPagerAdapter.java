package com.example.android.wiesbadentourapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by dnj on 10/14/16.
 */

public class ItemFragmentPagerAdapter extends FragmentPagerAdapter {


    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[]{"Sites", "Food & Drink", "Festivals", "Phrases"};
    private Context context;

    public ItemFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new SiteFragment();
        } else if (position == 1) {
            return new FoodDrinkFragment();
        } else if (position == 2) {
            return new FestivalsFragment();
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
