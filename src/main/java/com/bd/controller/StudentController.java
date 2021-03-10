package com.bd.controller;

import com.bd.model.Student;
import com.bd.repository.StudentRep;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/studs")
public class StudentController {

    StudentRep studentRep;

    public StudentController(StudentRep studentRep) {
        this.studentRep = studentRep;
    }

    @PostMapping
    Student newStudent(@RequestBody Student newStudent) {
        return studentRep.save(newStudent);
    }

}
