package com.bd.repository;

import com.bd.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRep extends JpaRepository<Lesson, Integer> {
    Lesson findOneByLessonId(int id);
    List<Lesson> findAll();
}
