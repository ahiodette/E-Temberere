package com.moringaschool.e_temberere.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.e_temberere.R;
import com.moringaschool.e_temberere.models.Business;
import com.moringaschool.e_temberere.models.Category;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SiteDetailFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.siteImageView) ImageView siteImage;
    @BindView(R.id.siteNameTextView) TextView siteName;
    @BindView(R.id.categoryTextView) TextView category;
    @BindView(R.id.ratingTextView) TextView rating;
    @BindView(R.id.websiteTextView) TextView website;
    @BindView(R.id.phoneTextView) TextView phone;
    @BindView(R.id.addressTextView) TextView address;
    @BindView(R.id.bookSiteButton) Button book;

    private Business site;






    public SiteDetailFragment() {
        // Required empty public constructor
    }


    public static SiteDetailFragment newInstance(Business site) {
        SiteDetailFragment siteDetailsFragment = new SiteDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("site", Parcels.wrap(site));
        siteDetailsFragment.setArguments(args);
        return siteDetailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            site = Parcels.unwrap(getArguments().getParcelable("site"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_site_detail, container, false);
        ButterKnife.bind(this,view);

        Picasso.get().load(site.getImageUrl()).into(siteImage);

        List<String> siteCategories = new ArrayList<>();

        for (Category siteCategory: site.getCategories()){
            siteCategories.add(siteCategory.getTitle());
        }

        siteName.setText(site.getName());
        category.setText(android.text.TextUtils.join(", ",siteCategories));
        rating.setText(Double.toString(site.getRating())+"/5");
        website.setOnClickListener(this);
        phone.setOnClickListener(this);
        address.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v){
        if(v==website){
            Intent gotoWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(site.getUrl()));
            startActivity(gotoWeb);
        }
        if (v==phone){
            Intent startCall = new Intent(Intent.ACTION_VIEW, Uri.parse("tel"+ site.getPhone()));
            startActivity(startCall);
        }
        if (v==address){
            Intent locate = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("location:"+ site.getCoordinates().getLatitude()
                            +"," + site.getCoordinates().getLongitude()
                            + "?q=(" + site.getName()+")"));
            startActivity(locate);
        }
    }
}
