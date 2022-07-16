package com.CamperLand.CT.controller;

import com.CamperLand.CT.logic.Board;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.Valid;
import java.util.List;

@RestControllerAdvice
public class BoardAdvicer {

    @ExceptionHandler(TooLongException.class)
    public ResponseEntity<?> tooLong(TooLongException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getError());
    }
}
