package com.fe.service;

import java.util.List;

import com.fe.pojo.Student;

public interface IStudentService {

    List<Student> findAll();

    void save(Student student);

    void delete(int studentId);

    Student findById(int studentId);

    void update(int studentId, Student student);
}
