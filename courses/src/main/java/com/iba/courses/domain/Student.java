package com.iba.courses.domain;

import javax.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name="Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    @NotNull
    private String login;

    @Column(name = "password")
    @NotNull
    private String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Column(name = "name")
    @NotNull
    private String name;


    @Column(name = "course")
    @NotNull
    private Integer course;

    @Column(name = "university")
    @NotNull
    private String university;

    public Student(Integer id, String name, Integer course, String university) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.university = university;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Integer getCourse() {
        return course;
    }

    public String getUniversity() {
        return university;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(course, student.course) &&
                Objects.equals(university, student.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, course, university);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", university='" + university + '\'' +
                '}';
    }

    public Student() {

        id = 5;
        name = "Vanya";
        course = 3;
        university = "BSUIR";

    }
}
