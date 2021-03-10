package com.bd.controller;

import com.bd.exception.UserDoesntExistException;
import com.bd.model.User;
import com.bd.service.StudentService;
import com.bd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/signUp")
public class SignUpController {
    private final UserService userService;
    private final StudentService studentService;

    @Autowired
    public SignUpController(UserService userService, StudentService studentService) {
        this.userService = userService;
        this.studentService = studentService;
    }

    @PostMapping
    public void signUp(@RequestBody User user) {
        System.out.println("       IJbkjsbdcjksbdjk        ");
        if(user.getCode().equals("teach") && user.getStatus().equals("teacher")){
            userService.saveUser(user);
        }

        if(studentService.loadStudent(user.getName()) != null && user.getStatus().equals("student")){
            userService.saveUser(user);
        }

    }
}
