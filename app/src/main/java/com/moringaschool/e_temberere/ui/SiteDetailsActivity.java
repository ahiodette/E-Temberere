package com.moringaschool.e_temberere.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.moringaschool.e_temberere.R;
import com.moringaschool.e_temberere.adapters.SitePagerAdapter;
import com.moringaschool.e_temberere.models.Business;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SiteDetailsActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager viewPager;
    private SitePagerAdapter pagerAdapter;
    List<Business> sites;
    private int FragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_details);
        ButterKnife.bind(this);

        sites = Parcels.unwrap(getIntent().getParcelableExtra("sites"));
        int firstPosition = getIntent().getIntExtra("position",0);
        pagerAdapter = new SitePagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter, sites);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(firstPosition);
    }
}
