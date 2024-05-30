package com.Santiago.mockTest.util.exceptions;

public class IdNotFoundException extends RuntimeException {
  private static final String ERROR_MESSGE = "The id suplied for the entity %s was not found :(";

  public IdNotFoundException(String nameEntity) {
    super(String.format(ERROR_MESSGE, nameEntity));
  }

}
