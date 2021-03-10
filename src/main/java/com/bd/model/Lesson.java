package com.bd.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "lesson")
public class Lesson {
    private @Id
    @GeneratedValue
    int lessonId;
    @Column
    private int subjectId;
    @Column
    private String lesDay;
    @Column
    private String lesTime;
    @Column
    private String audId;
    @Column
    private String carId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return lessonId == lesson.lessonId &&
                subjectId == lesson.subjectId &&
                lesDay.equals(lesson.lesDay) &&
                lesTime.equals(lesson.lesTime) &&
                audId.equals(lesson.audId)&&
                carId.equals(lesson.carId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lessonId, subjectId, lesDay, lesTime, audId, carId);
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getLesDay(){
        return lesDay;
    };

    public void setLesDay(String lesDay) {
        this.lesDay = lesDay;
    }

    public String getLesTime() {
        return lesTime;
    }

    public void setLesTime(String lesTime) {
        this.lesTime = lesTime;
    }

    public void setAudId(String audId) {
        this.audId = audId;
    }

    public String getAudId() {
        return audId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lesson id=" + lessonId +
                ", subject id='" + subjectId + '\'' +
                ", day ='" + lesDay + '\'' +
                ", time='" + lesTime + '\'' +
                '}';
    }
}
