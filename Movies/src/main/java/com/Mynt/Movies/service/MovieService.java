package com.mynt.Movies.service;

import com.mynt.Movies.model.Genre;
import com.Mynt.Movies.model.Movie;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface MovieService {
    Movie saveMovie(Movie movie);
    List<Movie> getAllMovies();

    List<Movie> getMoviesByYearReleased(Integer yearReleased);
    List<Movie> getAllMoviesByOrderByYearReleased();
    List<Movie> getMoviesByGenreAndIsSequel(Genre genre, Boolean isSequel);

    @PreAuthorize("isAuthenticated()")
    String getSecurity();
}
