package com.Mynt.Movies.controller;

import com.mynt.Movies.model.Genre;
import com.Mynt.Movies.model.Movie;
import com.mynt.Movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviesController {

    // Home method that uses OAuth2 authentication (e.g., for GitHub login)
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User principal) {
        if (principal != null) {
            return "Hello, " + principal.getAttribute("login"); // GitHub username
        } else {
            return "Hello, Guest!";
        }
    }

    // Autowired MovieService to handle the logic
    @Autowired
    MovieService movieService;

    // Save a new movie
    @PostMapping("/movies")
    public Movie saveMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    // Get all movies
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Get movies by year released
    @GetMapping("/movies/{yearReleased}")
    public List<Movie> getMoviesByYear(@PathVariable Integer yearReleased) {
        return movieService.getMoviesByYearReleased(yearReleased);
    }

    // Get movies ordered by year released
    @GetMapping("/movies/year-order")
    public List<Movie> getMoviesByOrderByYearReleased() {
        return movieService.getAllMoviesByOrderByYearReleased();
    }

    // Get movies by genre and if they are sequels
    @GetMapping("/movies/{genre}/{isSequel}")
    public List<Movie> getMoviesByGenreAndIsSequel(@PathVariable("genre") Genre genre, @PathVariable("isSequel") Boolean isSequel) {
        return movieService.getMoviesByGenreAndIsSequel(genre, isSequel);
    }
}
