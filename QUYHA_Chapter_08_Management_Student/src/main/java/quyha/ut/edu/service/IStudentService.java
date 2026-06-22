package quyha.ut.edu.service;

import java.util.List;
import quyha.ut.edu.pojo.Student;

public interface IStudentService {
    public List<Student> findAll();
    public void save(Student student);
    public void delete(int studentID);
    public Student findById(int studentID);
    public void update(Student student);
}

