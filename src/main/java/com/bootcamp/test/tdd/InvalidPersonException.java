package com.bootcamp.test.tdd;

public class InvalidPersonException extends RuntimeException {
    public InvalidPersonException(){
        super("Person not found in family");
    }
}
