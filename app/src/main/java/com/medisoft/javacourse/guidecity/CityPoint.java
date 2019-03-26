package com.medisoft.javacourse.guidecity;

public class CityPoint {

    private int id;
    private String category;
    private String favorites;
    private String name;
    private int rating;
    private String description;
    private String responses;
    private String worktim;
    private String telefon;
    private String adres;



    public CityPoint(int id, String category, String favorites, String name, int rating, String description, String responses, String worktim, String telefon, String adres){
        this.id = id;
        this.category = category;
        this.name = name;
        this.favorites = favorites;
        this.rating = rating;
        this.description = description;
        this.responses = responses;
        this.worktim = worktim;
        this.telefon = telefon;
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponses() {
        return responses;
    }

    public void setResponses(String responses) {
        this.responses = responses;
    }

    public String getWorktim() {
        return worktim;
    }

    public void setWorktim(String worktim) {
        this.worktim = worktim;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }


}
