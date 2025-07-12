package com.meaphorce.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Validations Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(final MethodArgumentNotValidException e) {
        List<ErrorDetail> errors = e.getBindingResult().getFieldErrors().stream().map(error ->
                new ErrorDetail(
                        error.getDefaultMessage(),
                        error.getField(),
                        error.getCode()

                )
        ).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errors);
    }

    // Custom Errors
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<?> handleMovieNotFoundException(final MovieNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Movie Not Found", e.getMessage()));
    }

    // Others errors
    //*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllException(final Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Internal Error", e.getMessage()));
    }// */
}