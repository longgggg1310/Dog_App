package com.example.vnukdogapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.vnukdogapp.R;
import com.example.vnukdogapp.model.DogBreed;
import com.squareup.picasso.Picasso;


public class DetailsFragment extends Fragment {

    private DogBreed dogBreed;
    private ImageView ivAvatar;
    private TextView tvName, tvBreedFor, tvBreedGroup, tvLifeSpan, tvOrigin, tvHeight, tvTemperament, tvWeight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dogBreed = (DogBreed) getArguments().getSerializable("DogCat");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivAvatar = view.findViewById(R.id.iv_avatar);
        tvName = view.findViewById(R.id.tv_name);
        tvBreedFor = view.findViewById(R.id.tv_breed_for);
        tvBreedGroup = view.findViewById(R.id.tv_breed_group);
        tvLifeSpan = view.findViewById(R.id.tv_life_span);
        tvOrigin = view.findViewById(R.id.tv_origin);
        tvHeight = view.findViewById(R.id.tv_height);
        tvTemperament = view.findViewById(R.id.tv_temperament);
        tvWeight = view.findViewById(R.id.tv_weight);

        Picasso.get().load(dogBreed.getUrl()).into(ivAvatar);
        tvBreedFor.setText(dogBreed.getBreedfor());
        tvName.setText(dogBreed.getName());
//        tvBreedFor.setText(dogBreed.get);
        tvBreedGroup.setText(dogBreed.getBreedgroup());
        tvLifeSpan.setText(dogBreed.getLifespan());
        tvOrigin.setText(dogBreed.getOrigin());
        tvTemperament.setText(dogBreed.getTemperament());
        tvHeight.setText(dogBreed.getHeight().getImperial());
        tvWeight.setText(dogBreed.getWeight().getMetric());

    }
}