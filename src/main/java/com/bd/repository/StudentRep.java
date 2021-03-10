package com.bd.repository;

import com.bd.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRep extends JpaRepository<Student, Integer> {
    Student findOneByStudentId(int id);
    Student findOneByName(String name);
}
