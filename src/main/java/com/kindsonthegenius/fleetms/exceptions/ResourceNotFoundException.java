package com.kindsonthegenius.fleetms.exceptions;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s with %s = %s not found", resourceName, fieldName, fieldValue));
    }
}
