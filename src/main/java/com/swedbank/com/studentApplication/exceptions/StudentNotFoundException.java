package com.swedbank.com.studentApplication.exceptions;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(Long id){
        super("Could not find student id: " + id);
    }
}