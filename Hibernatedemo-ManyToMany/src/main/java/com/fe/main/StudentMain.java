package com.fe.main;

import com.fe.pojo.Book;
import com.fe.pojo.Student;
import com.fe.service.IStudentService;
import com.fe.service.StudentService;

public class StudentMain {

    public static void main(String[] args) {
        String fileName = "hibernate.cfg.xml";
        IStudentService studentService = new StudentService(fileName);
        Student student = new Student("Huynh", "Que", 9);
        Book book = new Book("Java hoc tap ", "Catalin Tudose", "988");
        student.getBooks().add(book);
        studentService.save(student);

    }

}
