package com.bd.repository;

import com.bd.model.Schedule;
import com.bd.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRep extends JpaRepository<Schedule, Integer> {

    List<Integer> findAllByStudentId(int student);

}
