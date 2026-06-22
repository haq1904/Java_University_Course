package hsf301.fe.com.repository;

import java.util.List;

import hsf301.fe.com.pojo.Student;

public interface IStudentRepository {
    
    public List<Student> findAll();
    
    public void save(Student student);
    
    public void delete(int studentID);
    
    public Student findById(int studentID);
    
    public void update(Student student);

}
