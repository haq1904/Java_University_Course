package com.fe.main;

import java.util.List;

import com.fe.pojo.Book;
import com.fe.pojo.Student;
import com.fe.service.IStudentService;
import com.fe.service.StudentService;

public class StudentMain {

    public static void main(String[] args) {
        String fileName = "JPAs";
        IStudentService studentService = new StudentService(fileName);
        Student student = new Student("Quy", "Anh", 9);
        Book book = new Book("Java Persistence with Spring", "Catalin Tudose", "978");
        student.getBooks().add(book);
        studentService.save(student);
        List<Student> students = studentService.findAll();
        for (Student s : students) {
            System.out.println(s.getFirstName());
        }

    }

}
