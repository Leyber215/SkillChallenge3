package com.meaphorce.services;

import com.meaphorce.exception.MovieNotFoundException;
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
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException(id);
        }

        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException(id);
        }
        updatedMovie.setId(id);
        return movieRepository.save(updatedMovie);
    }

    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException(id);
        }

        movieRepository.deleteById(id);
    }
}
