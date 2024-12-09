package com.Mynt.Movies.repository;

import com.Mynt.Movies.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoviesRepository extends CrudRepository<Movie,Long> {
    List<Movie> getMovieByYearReleased(Integer yearReleased);
    List<Movie> getAllMoviesByOrderByYearReleased();
    List<Movie> getMoviesByGenreAndIsSequel(com.mynt.Movies.model.Genre genre, boolean isSequel);
}
