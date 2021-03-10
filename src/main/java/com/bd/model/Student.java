package com.bd.model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    private @Id
    @GeneratedValue
    int studentId;
    @Column
    private String name;
    @Column
    private int licenceId;
    @Column
    private String groupName;

    public Student() {}

    public Student(String name, int licence_id, String groupName) {
        this.name = name;
        this.licenceId = licence_id;
        this.groupName = groupName;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId==student.studentId &&
                Objects.equals(name, student.name) &&
                licenceId == student.licenceId &&
                Objects.equals(groupName, student.groupName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, name, licenceId, groupName);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLicenceId(){
        return licenceId;
    };

    public void setLicenceId(int licenceId) {
        this.licenceId = licenceId;
    }

    public String getGroupName() {
        return groupName;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + studentId +
                ", name='" + name + '\'' +
                ", licence_id='" + licenceId + '\'' +
                ", group='" + groupName + '\'' +
                '}';
    }
}