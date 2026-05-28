package com.fe.repository;

import com.fe.dao.StudentDAO;
import com.fe.pojo.Student;

import java.util.List;

public class StudentRepository implements IStudentRepository {

    private StudentDAO studentDAO = null;

    public StudentRepository(String fileConfig) {
        studentDAO = new StudentDAO(fileConfig);
    }

    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.getStudents();
    }

    @Override
    public void delete(int studentId) {
        studentDAO.delete(studentId);
    }

    @Override
    public Student findById(int studentId) {
        return studentDAO.findById(studentId);
    }

    @Override
    public void update(int studentId, Student student) {
        studentDAO.update(studentId, student);
    }
}
