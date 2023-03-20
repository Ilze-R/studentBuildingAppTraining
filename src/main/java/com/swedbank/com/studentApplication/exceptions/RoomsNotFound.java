package com.swedbank.com.studentApplication.exceptions;



public class RoomsNotFound extends RuntimeException{

    public RoomsNotFound(long id ){
        super("No rooms for building " + id);
    }

}