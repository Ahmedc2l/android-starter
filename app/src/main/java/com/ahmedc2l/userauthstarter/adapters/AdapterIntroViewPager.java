package com.ahmedc2l.userauthstarter.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmedc2l.userauthstarter.R;
import com.ahmedc2l.userauthstarter.databinding.ItemIntroViewPagerBinding;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AdapterIntroViewPager extends RecyclerView.Adapter<AdapterIntroViewPager.ViewHolder>{
    private List<Integer> images;

    public AdapterIntroViewPager() {
        images = new ArrayList<>();
        images.add(R.drawable.ahly);
        images.add(R.drawable.ic_launcher_foreground);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ItemIntroViewPagerBinding itemBinding =
                ItemIntroViewPagerBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images == null ? 0 : images.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemIntroViewPagerBinding binding;

        ViewHolder(ItemIntroViewPagerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(int image){
            Glide.with(binding.getRoot())
                    .load(image)
                    .into(binding.imageView);
        }
    }

}