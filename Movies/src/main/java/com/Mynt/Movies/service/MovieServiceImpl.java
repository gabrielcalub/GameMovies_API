package com.Mynt.Movies.service;

import com.Mynt.Movies.repository.MoviesRepository;
import com.mynt.Movies.model.Genre;
import com.Mynt.Movies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements com.mynt.Movies.service.MovieService {
    @Autowired
    MoviesRepository moviesRepository;

    // Utilities
    @Override
    public Movie saveMovie(Movie movie) {
        return moviesRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        moviesRepository.findAll().forEach(movies::add);
        return movies;
    }

    // Specified implementations
    @Override
    public List<Movie> getMoviesByYearReleased(Integer yearReleased) {
        return moviesRepository.getMovieByYearReleased(yearReleased);
    }

    @Override
    public List<Movie> getAllMoviesByOrderByYearReleased() {
        return moviesRepository.getAllMoviesByOrderByYearReleased();
    }

    @Override
    public List<Movie> getMoviesByGenreAndIsSequel(Genre genre, Boolean isSequel) {
        List<Movie> allMovies = new ArrayList<>();
        moviesRepository.findAll().forEach(allMovies::add);

        List<Movie> filteredMovies = new ArrayList<>();
        for(Movie movie: allMovies){
            if (movie.getGenre().contains(genre) && movie.getIsSequel() == isSequel){
                filteredMovies.add(movie);
            }
        }
        return filteredMovies;
    }

    @Override
    public String getSecurity() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "" + auth;
    }
}