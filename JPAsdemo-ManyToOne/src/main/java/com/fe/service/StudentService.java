package com.fe.service;

import java.util.List;

import com.fe.pojo.Student;
import com.fe.repository.IStudentRepository;
import com.fe.repository.StudentRepository;

public class StudentService implements IStudentService {

    private IStudentRepository IStudentRepo = null;

    public StudentService(String fileConfig) {
        IStudentRepo = new StudentRepository(fileConfig);
    }

    @Override
    public void save(Student student) {
        IStudentRepo.save(student);
    }

    @Override
    public List<Student> findAll() {
        return IStudentRepo.findAll();
    }

    @Override
    public void delete(int studentId) {
        IStudentRepo.delete(studentId);
    }

    @Override
    public Student findById(int studentId) {
        return IStudentRepo.findById(studentId);
    }

    @Override
    public void update(int studentId, Student student) {
        IStudentRepo.update(studentId, student);
    }
}
