package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService implements MovieServiceInterface {

    public List<Movie> list = new ArrayList<>();
    private final Map<String, Movie> movieMap = new HashMap<>(); // In-memory data store

    public void updateMovie(String id, Movie movie) {
        Movie existing_movie = this.getMovieById(movie.getId());
        list.remove(existing_movie);
        movieMap.remove(existing_movie.getId());
        list.add(movie);
        movieMap.put(movie.getId(), movie);

    }

    public void deleteMovie(String id) {
        Movie movie = this.getMovieById(id);
        list.remove(movie);
        movieMap.remove(movie.getId());
    }

    public Movie getMovieById(String id) {
        if (ObjectUtils.isEmpty(movieMap.get(id))) {
            throw new IdNotFound("Movie with ID " + id + " not found.");
        }
        return movieMap.get(id);
    }

    public Movie addMovie(Movie movie) {
        // Check if the movie exists
        String id = "";
        // Check if a movie with the same ID already exists
        if (movieMap.containsKey(movie.getId())) {
            throw new IdAlreadyExist("Movie with ID " + movie.getId() + " already exists.");
        }
       return movieMap.put(movie.getId(), movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movieMap.values());
    }
}
