package a12mob.fiap.rapha.times_app.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import a12mob.fiap.rapha.times_app.Fragments.TimesFragment;

/**
 * Created by rapha on 26/11/2016.
 */

public class TabAdapter extends FragmentStatePagerAdapter {
    // How many tabs we want
    public static final int TOTAL_TABS = 1;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Returns which fragment we'll display
     */

    @Override
    public Fragment getItem(int position) {

        // Pass information between fragments
        Bundle b = new Bundle();
        b.putString("type", "57c49ba10f00007111b50c00");


        Fragment frag = new TimesFragment();
        frag.setArguments(b);

        return frag;
    }

    // Returns total tabs
    @Override
    public int getCount() {
        return TOTAL_TABS;
    }
}
