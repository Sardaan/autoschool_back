package com.bd.service;

import com.bd.model.Lesson;
import com.bd.repository.LessonRep;
import com.bd.repository.ScheduleRep;
import com.bd.repository.SubjectRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    LessonRep lessonRep;
    ScheduleRep scheduleRep;
    SubjectRep subjectRep;

    @Autowired
    public LessonService(LessonRep lessonRep, ScheduleRep scheduleRep, SubjectRep subjectRep){
        this.lessonRep = lessonRep;
        this.scheduleRep = scheduleRep;
        this.subjectRep = subjectRep;
    }
    public List<Lesson> getLessonsByStudentId(int student) {
        List<Lesson> lessons = null;
        for(int lessonId: scheduleRep.findAllByStudentId(student)){
//            int subjectId = lessonRep.findSubjectIdByLessonId(lessonId);
            lessons.add(lessonRep.findOneByLessonId(lessonId));
        }
        return lessons;
    }

    public List<Lesson> getAllLessons(){
        return lessonRep.findAll();
    }

    public void saveLesson(Lesson lesson){
        lessonRep.save(lesson);
    }
}
