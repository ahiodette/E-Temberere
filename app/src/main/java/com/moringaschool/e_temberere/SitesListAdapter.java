package com.moringaschool.e_temberere;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.e_temberere.models.Business;
import com.moringaschool.e_temberere.ui.CategoriesAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SitesListAdapter extends RecyclerView.Adapter<CategoriesAdapter.SitesViewHolder> {
    private List<Business> sList;
    private Context myContext;

    public SitesListAdapter(List<Business> sList, Context myContext) {
        this.sList = sList;
        this.myContext = myContext;
    }

    public class SitesViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.sitePicture) ImageView pictureView;
        @BindView(R.id.siteName) TextView nameView;
        @BindView(R.id.categoryName) TextView categoryView;
        @BindView(R.id.rating) TextView ratingView;

        private Context myContext;

        public SitesViewHolder(@NonNull View itemView, Context myContext) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            myContext = itemView.getContext();
        }
    }
}
