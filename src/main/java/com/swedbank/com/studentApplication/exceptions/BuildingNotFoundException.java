package com.swedbank.com.studentApplication.exceptions;


public class BuildingNotFoundException extends RuntimeException{

    public BuildingNotFoundException(int id ){
        super("No building found for  " + id);
    }
}
