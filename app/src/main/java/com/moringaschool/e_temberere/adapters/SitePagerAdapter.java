package com.moringaschool.e_temberere.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.e_temberere.models.Business;
import com.moringaschool.e_temberere.ui.SiteDetailFragment;

import java.util.List;

public class SitePagerAdapter extends FragmentPagerAdapter {

    private List<Business> sites ;

    public SitePagerAdapter(@NonNull FragmentManager fm, int behavior, List<Business> sites) {
        super(fm, behavior);
        this.sites = sites;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return SiteDetailFragment.newInstance(sites.get(position));
    }

    @Override
    public int getCount() {
        return sites.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return sites.get(position).getName();
    }

}
