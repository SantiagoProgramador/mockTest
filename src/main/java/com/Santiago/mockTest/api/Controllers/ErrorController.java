package com.Santiago.mockTest.api.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Santiago.mockTest.api.Errors.BaseErrorResponse;
import com.Santiago.mockTest.api.Errors.ErrorResponse;
import com.Santiago.mockTest.api.Errors.ErrorsResponse;
import com.Santiago.mockTest.util.exceptions.IdNotFoundException;


@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ErrorController {
  @ExceptionHandler(IdNotFoundException.class)
  public BaseErrorResponse IdNotFound(IdNotFoundException exception) {

    return ErrorResponse.builder().message(exception.getMessage()).status(HttpStatus.BAD_REQUEST.name())
        .code(HttpStatus.BAD_REQUEST.value()).build();
  }

  

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public BaseErrorResponse ErrorsResponse(MethodArgumentNotValidException exception) {
    List<String> Errors = new ArrayList<>();

    exception.getAllErrors().forEach(error -> Errors.add(error.getDefaultMessage()));

    return ErrorsResponse.builder().Errors(Errors).status(HttpStatus.BAD_REQUEST.name())
        .code(HttpStatus.BAD_REQUEST.value()).build();
  }
}