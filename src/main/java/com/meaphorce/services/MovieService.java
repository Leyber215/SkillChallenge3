package com.meaphorce.services;

import com.meaphorce.models.Movie;
import com.meaphorce.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> updateMovie(Long id, Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            movieOptional.get().setTitle(movie.getTitle());
            movieOptional.get().setDescription(movie.getDescription());
            movieOptional.get().setAvailable(movie.isAvailable());
        }
        movieRepository.save(movieOptional.get());
        return movieOptional;
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
