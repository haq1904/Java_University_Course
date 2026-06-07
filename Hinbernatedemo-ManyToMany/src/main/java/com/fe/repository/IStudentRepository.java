package com.fe.repository;

import java.util.List;

import com.fe.pojo.Student;

public interface IStudentRepository {

    List<Student> findAll();

    void save(Student student);

    void delete(int studentId);

    Student findById(int studentId);

    void update(int id, Student student);
}
