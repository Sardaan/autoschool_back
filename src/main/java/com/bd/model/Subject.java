package com.bd.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subject")
public class Subject {
    private @Id
    @GeneratedValue
    int subjectId;
    @Column
    private String subjectName;
    @Column
    private int teacherId;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectId == subject.subjectId &&
                subjectName.equals(subject.subjectName) &&
                teacherId == subject.teacherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, subjectName, teacherId);
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName(){
        return subjectName;
    };

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject id=" + subjectId +
                ", subject name='" + subjectName + '\'' +
                ", teacher id ='" + teacherId +
                '}';
    }
}
