package com.dermenji.exeption;


public class DataNotFoundExeption extends RuntimeException {

    public DataNotFoundExeption(String message) {
        super(message);
    }
}
