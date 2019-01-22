package com.example.userapplication.UserApplication.dto;

public class Movie {
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Movie(String movieName, String genre) {
        this.movieName = movieName;
        this.genre = genre;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String movieName;
    public String genre;
}
