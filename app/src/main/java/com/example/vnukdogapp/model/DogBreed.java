package com.example.vnukdogapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DogBreed implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("life_span")
    private String lifespan;

    @SerializedName("name")
    private String name;

    @SerializedName("origin")
    private String origin;

    @SerializedName("temperament")
    private String temperament;

    @SerializedName("url")
    private String url;

    @SerializedName("breed_group")
    private String breedgroup;

    @SerializedName("bred_for")
    private String breedfor;


    private Height height;

    private Weight weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLifespan() {
        return lifespan;
    }

    public void setLifespan(String lifespan) {
        this.lifespan = lifespan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

        public String getBreedgroup() {
            return breedgroup;
        }

        public void setBreedgroup(String breedgroup) {
            this.breedgroup = breedgroup;
        }

        public String getBreedfor() {
            return breedfor;
        }

        public void setBreedfor(String breedfor) {
            this.breedfor = breedfor;
        }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }
}