package com.kindsonthegenius.fleetms.exceptions;

public class InvalidTokenException extends RuntimeException {
  public InvalidTokenException(String message) {
    super(message);
  }
}
