package com.example.MovieTicket.MovieBooking.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Movie {

    @Min(value = 1)
    public String id;
    @Size(min=3, max=20)
    public String movieName;
    @NotBlank
    public String movieDirector;
    @Min(value = 1)
    @Max(value = 10)
    public long movieRating;
    public String movieLanguage;
    public List<String> writers;
    public List<String> actors;
    public List<String> genre;

    public Movie() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public long getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(long movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public Movie(String id, String movieName, String movieDirector, long movieRating, String movieLanguage, List<String> writers, List<String> actors, List<String> genre) {
        this.id = id;
        this.movieName = movieName;
        this.movieDirector = movieDirector;
        this.movieRating = movieRating;
        this.movieLanguage = movieLanguage;
        this.writers = writers;
        this.actors = actors;
        this.genre = genre;
    }
    }
