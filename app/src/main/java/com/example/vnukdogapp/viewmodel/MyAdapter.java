package com.example.vnukdogapp.viewmodel;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.example.vnukdogapp.R;
import com.example.vnukdogapp.model.DogBreed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.getColor;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<DogBreed> dogs;

    private static Context context;

    public MyAdapter(ArrayList<DogBreed> dogs, Context context) {
        this.dogs = dogs;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dog, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(dogs.get(position).getName());
        Picasso.get().load(dogs.get(position).getUrl())
                .placeholder(R.drawable.my_loading)
                .into(holder.ivAvatar);
        holder.tvBreedGroup.setText(dogs.get(position).getBreedgroup());

    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageView ivAvatar;
        private TextView tvBreedGroup;
        private ImageButton ivLike;

        public ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            ivAvatar = view.findViewById(R.id.iv_avatar);
            tvBreedGroup = view.findViewById(R.id.tv_breedgroup);
            ivLike = view.findViewById(R.id.iv_like);

            ivAvatar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View view){
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("DogCat", dogs.get(getAdapterPosition()));
                    Navigation.findNavController(view).navigate(R.id.action_listFragment_to_detailsFragment, bundle);
                }
            });

            ivLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ivLike.setColorFilter(ContextCompat.getColor(context, R.color.red));
                }
            });

            ivLike.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    ivLike.setColorFilter(ContextCompat.getColor(context, R.color.white));
                    return false;
                }
            });
        }



    }


}


