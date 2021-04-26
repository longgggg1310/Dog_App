package com.example.vnukdogapp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.vnukdogapp.R;
import com.example.vnukdogapp.model.DogBreed;
import com.example.vnukdogapp.viewmodel.DogsApiService;
import com.example.vnukdogapp.viewmodel.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class ListFragment extends Fragment {


    private RecyclerView rvDogs;
    private MyAdapter myAdapter;
    private ArrayList<DogBreed> dogs ;
    private DogsApiService apiService;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvDogs = view.findViewById(R.id.rv_dogs);
        dogs = new ArrayList<>();
        myAdapter = new MyAdapter(dogs, getActivity());

        rvDogs.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvDogs.setAdapter(myAdapter);

        apiService = new DogsApiService();

        apiService.getDogs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<DogBreed>>() {
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<DogBreed> dogBreeds) {
                        Log.d("DEBUG", "Success");

                        for( DogBreed dogBreed: dogBreeds) {
                            Log.d("DEBUG", "" + dogBreed.getName());
                            dogs.add(dogBreed);
                        }
                        myAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.d("DEBUG", "Error" + e.getMessage());
                    }
                });
    }
}