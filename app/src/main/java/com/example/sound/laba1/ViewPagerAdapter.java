package com.example.sound.laba1;

/**
 * Created by sound on 09.11.2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static int TAB_COUNT = 3;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return AlbumFragment.newInstance();
            case 1:
                return ArtistFragment.newInstance();
            case 2:
                return TrackFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return AlbumFragment.TITLE;

            case 1:
                return ArtistFragment.TITLE;

            case 2:
                return TrackFragment.TITLE;
        }
        return super.getPageTitle(position);
    }
}
