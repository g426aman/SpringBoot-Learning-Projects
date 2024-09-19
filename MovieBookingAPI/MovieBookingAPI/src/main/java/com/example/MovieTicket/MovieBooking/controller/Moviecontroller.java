package com.example.MovieTicket.MovieBooking.controller;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")

public class Moviecontroller {
   @Autowired
   private MovieService movieService;

    // GET "/ticket/movies": Fetches the list of all the movies
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // POST "/ticket/movie": Adds a new movie, throws RuntimeException if bindingResult has errors
    @PostMapping("/movie")
    public void addMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("Invalid Movie details");
        }
        movieService.addMovie(movie);
    }

    // GET "/ticket/movie/{id}": Fetches a movie by the given Id
    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    // DELETE "/ticket/movie/{id}": Deletes a movie by the given Id
    @DeleteMapping("/movie/{id}")
    public void deleteMovieById(@PathVariable String id) {
        movieService.deleteMovie(id);
    }

    // PUT "/ticket/update/{id}": Updates a movie by the given Id
    @PutMapping("/update/{id}")
    public void updateMovie(@Valid @RequestBody Movie movie, @PathVariable String id) {
        movieService.updateMovie(id, movie);
    }
}






