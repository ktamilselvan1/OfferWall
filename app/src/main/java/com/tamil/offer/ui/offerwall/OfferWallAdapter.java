package com.tamil.offer.ui.offerwall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tamil.offer.R;
import com.tamil.offer.data.repo.response.Offer;

public class OfferWallAdapter extends ListAdapter<Offer, OfferWallAdapter.OfferWallViewHolder> {


    protected OfferWallAdapter() {
        super(new DiffUtil.ItemCallback<Offer>() {
            @Override
            public boolean areItemsTheSame(@NonNull Offer oldItem, @NonNull Offer newItem) {
                return oldItem.getOfferId().equals(newItem.getOfferId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Offer oldItem, @NonNull Offer newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }

    @NonNull
    @Override
    public OfferWallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_offer, parent, false);
        return new OfferWallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferWallViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(getCurrentList().get(position).getThumbnail().getHires())
                .centerCrop()
                .into(holder.imageView);
        holder.title.setText(getCurrentList().get(position).getTitle());
    }

    public static class OfferWallViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView title;

        public OfferWallViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.offer_img);
            title = itemView.findViewById(R.id.offer_title);
        }
    }
}
