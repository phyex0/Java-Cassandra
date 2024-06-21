package com.phyex0.cassandra.controller;

import com.phyex0.cassandra.exception.LibraryAlreadyExistsException;
import com.phyex0.cassandra.exception.LibraryNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestControllerAdvice {

    @ExceptionHandler({LibraryNotFoundException.class, LibraryAlreadyExistsException.class})
    @ResponseBody
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
