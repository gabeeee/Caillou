package com.example.gabriel.caillou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter
{
    int mNumOfTabs, teamPosition;
    User user;

    public PagerAdapter(FragmentManager fm, int NumOfTabs, User user, int teamPosition) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.user = user;
        this.teamPosition = teamPosition;
    }

    @Override
    public Fragment getItem(int position) {

        // Package user object and send to fragments.
        Bundle bundle = new Bundle();
        bundle.putParcelable("USER", user);
        bundle.putInt("POSITION", teamPosition);

        switch (position) {
            case 0:
                TeamInfoTabFragment tab1 = new TeamInfoTabFragment();
                tab1.setArguments(bundle);
                return tab1;
            case 1:
                TeamCalendarFragment tab2 = new TeamCalendarFragment();
                tab2.setArguments(bundle);
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
