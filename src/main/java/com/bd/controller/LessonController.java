package com.bd.controller;


import com.bd.exception.ResourceNotFoundException;
import com.bd.model.Lesson;
import com.bd.model.Student;
import com.bd.model.User;
import com.bd.repository.LessonRep;
import com.bd.security.HeaderEncryptor;
import com.bd.service.LessonService;
import com.bd.service.StudentService;
import com.bd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LessonController {

    @Autowired
    private LessonRep lessonRep;


    @GetMapping("/lessons")
    List<Lesson> getLessons() {
        return lessonRep.findAll();
    }

    @PostMapping("lessons")
    Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonRep.save(lesson);
    }

    @GetMapping("/lessons/{lessonId}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable int lessonId) {
        Lesson lesson = lessonRep.findById(lessonId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not exist with id :" + lessonId));
        return ResponseEntity.ok(lesson);
    }

    @PutMapping("/lessons/{lessonId}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable int lessonId, @RequestBody Lesson lessonDetails){
        Lesson lesson = lessonRep.findById(lessonId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not exist with id :" + lessonId));

        lesson.setSubjectId(lessonDetails.getSubjectId());
        lesson.setLesDay(lessonDetails.getLesDay());
        lesson.setLesTime(lessonDetails.getLesTime());
        lesson.setAudId(lessonDetails.getAudId());
        lesson.setCarId(lessonDetails.getCarId());


        Lesson updatedLesson = lessonRep.save(lesson);
        return ResponseEntity.ok(updatedLesson);
    }

    @DeleteMapping("/lessons/{lessonId}")
    public ResponseEntity<Map<String, Boolean>> deleteLesson(@PathVariable int lessonId){
        Lesson lesson = lessonRep.findById(lessonId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not exist with id :" + lessonId));

        lessonRep.delete(lesson);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }






}
