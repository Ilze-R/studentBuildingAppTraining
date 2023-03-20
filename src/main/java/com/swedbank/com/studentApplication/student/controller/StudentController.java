package com.swedbank.com.studentApplication.student.controller;


import com.swedbank.com.studentApplication.exceptions.StudentNotFoundException;
import com.swedbank.com.studentApplication.student.model.StudentRepository;
import com.swedbank.com.studentApplication.student.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository repository;

    @GetMapping()
    public List<Student> all(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable final long id){
        return new ResponseEntity<>(repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id)), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) throws StudentNotFoundException {
        Student student = repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        student.setName(newStudent.getName());
        student.setSurname(newStudent.getSurname());
        student.setPersonalCode(newStudent.getPersonalCode());
        final var updatedStudent = repository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @PostMapping
    public void save(@RequestBody Student student){
        repository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable final long id) {
        repository.deleteById(id);
    }

    @GetMapping("/first")
    public Student getFirst() {
        return repository.getFirstStudent().get(0);
    }

    @GetMapping("/byName")
    public List<Student> getByName(@RequestParam() String name) {
        return repository.getByName(name);
    }

}








