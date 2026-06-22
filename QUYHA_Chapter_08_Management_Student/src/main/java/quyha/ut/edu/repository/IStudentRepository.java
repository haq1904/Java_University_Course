package quyha.ut.edu.repository;

import java.util.List;

import quyha.ut.edu.pojo.Student;

public interface IStudentRepository {
    
    public List<Student> findAll();
    
    public void save(Student student);
    
    public void delete(int studentID);
    
    public Student findById(int studentID);
    
    public void update(Student student);

}

