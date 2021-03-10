package com.bd.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Column
    private int studentId;
    @Column
    private int lessonId;
    @Id
    private String id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return studentId == schedule.studentId &&
                lessonId == schedule.lessonId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, lessonId);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }


    @Override
    public String toString() {
        return "Schedule{" +
                "student id=" + studentId +
                ", lesson id ='" + lessonId +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
