package com.moringaschool.e_temberere.ui;

import android.content.Context;
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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SiteDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SiteDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SiteDetailFragment extends Fragment {
    @BindView(R.id.siteImageView) ImageView siteImage;
    @BindView(R.id.siteNameTextView) TextView siteName;
    @BindView(R.id.categoryTextView) TextView category;
    @BindView(R.id.ratingTextView) TextView rating;
    @BindView(R.id.websiteTextView) TextView website;
    @BindView(R.id.phoneTextView) TextView phone;
    @BindView(R.id.addressTextView) TextView address;
    @BindView(R.id.bookSiteButton) Button book;

    private Business site;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

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
        if (getArguments() != null) {
            site = Parcels.unwrap(getArguments().getParcelable("site"));
        }
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
        phone.setText(site.getPhone());
        address.setText(site.getLocation().toString());


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
