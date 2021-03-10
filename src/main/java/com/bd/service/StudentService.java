package com.bd.service;

import com.bd.model.Student;
import com.bd.repository.StudentRep;
import com.bd.security.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRep studentRep;
    PasswordEncryptor passwordEncryptor;

    @Autowired
    public StudentService(StudentRep studentRep, PasswordEncryptor passwordEncryptor){
        this.studentRep = studentRep;
        this.passwordEncryptor = passwordEncryptor;
    }


    public Student loadStudent(String name){
        return studentRep.findOneByName(name);
    }

    public Student getStudentById(int id){
        return studentRep.findOneByStudentId(id);
    }

    public Student getStudentByName(String name){
        return studentRep.findOneByName(name);
    }

}
