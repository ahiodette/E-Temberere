package com.moringaschool.e_temberere;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.e_temberere.models.Business;
import com.moringaschool.e_temberere.ui.CategoriesAdapter;

import java.util.List;

import butterknife.BindView;

public class SitesListAdapter extends RecyclerView.Adapter<CategoriesAdapter.SitesViewHolder> {
    private List<Business> sList;
    private Context myContext;

    public SitesListAdapter(List<Business> sList, Context myContext) {
        this.sList = sList;
        this.myContext = myContext;
    }

    public class SitesViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.sitePicture) ImageView picture;
        @BindView(R.id.siteName) TextView name;
        @
    }
}
