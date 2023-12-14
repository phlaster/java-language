package ru.java.exception;

public class SomeClassStringIsEmptyException extends SomeClassException{
    public SomeClassStringIsEmptyException() {
        super("The string is null");
    }
}
