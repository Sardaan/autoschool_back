package com.bd.repository;

import com.bd.model.Lesson;
import com.bd.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRep extends JpaRepository<Subject, Integer> {
    Lesson findOneBySubjectId(int id);

}
