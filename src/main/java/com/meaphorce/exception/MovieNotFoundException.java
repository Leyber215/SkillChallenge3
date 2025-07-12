package com.meaphorce.exception;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(Long movieId) {
        super("Movie with id " + movieId + " not found");
    }
}
