package com.safa.aquarium.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorControler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> controladorErrores(MethodArgumentNotValidException exception){


        Map<String, String> mapaErrores = new HashMap<>();


        for(FieldError error : exception.getBindingResult().getFieldErrors()){

            mapaErrores.put(error.getField(), error.getDefaultMessage());

        }

        return new ResponseEntity<>(mapaErrores, HttpStatus.BAD_REQUEST);

    }







}
