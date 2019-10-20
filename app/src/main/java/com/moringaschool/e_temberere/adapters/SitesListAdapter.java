package com.moringaschool.e_temberere.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.e_temberere.R;
import com.moringaschool.e_temberere.models.Business;
import com.moringaschool.e_temberere.ui.CategoriesAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SitesListAdapter extends RecyclerView.Adapter<SitesListAdapter.SitesViewHolder> {
    private List<Business> sites;
    private Context myContext;



    public SitesListAdapter(Context myContext,List<Business> sList) {
        this.sites = sList;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public SitesListAdapter.SitesViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout, parent, false);
        SitesViewHolder viewHolder = new SitesViewHolder(view, myContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( SitesListAdapter.SitesViewHolder holder, int position) {
        holder.bindSite(sites.get(position));
    }

    @Override
    public int getItemCount() {
        return sites.size();
    }

    public class SitesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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

        public void bindSite(Business site){
            Picasso.get().load(site.getImageUrl()).into(pictureView);
            nameView.setText(site.getName());
            categoryView.setText(site.getCategories().get(0).getTitle());
            ratingView.setText("Rating:"+site.getRating()+"/5");
        }

        @Override
        public void onClick(View v) {

        }
    }
}
