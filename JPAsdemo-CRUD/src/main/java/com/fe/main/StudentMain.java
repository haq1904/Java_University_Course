package com.fe.main;

import java.util.List;
import java.util.Scanner;

import com.fe.dao.StudentDAO;
import com.fe.pojo.Student;

public class StudentMain {

    public static void main(String[] args) {

        System.out.println("\n+++++++++ MENU +++++++++");
        System.out.println("+ 1. Get All Students  +");
        System.out.println("+ 2. Add Student       +");
        System.out.println("+ 3. Update Student    +");
        System.out.println("+ 4. Delete Student    +");
        System.out.println("+ 5. Get a Student     +");
        System.out.println("+ 0. QUIT              +");
        System.out.println("+++++++++ END ++++++++++");
        System.out.print("Please enter a number: ");

        int inputKey = -1;
        while (inputKey != 0) {
            Scanner console = new Scanner(System.in);            
            System.out.print("Please enter a number: ");
            inputKey = console.nextInt();
            StudentDAO studentDAO = new StudentDAO("JPAs");
            Student student = new Student("Lam","Nguyen",9);
            switch(inputKey) {
            case 0 : 
            	break;
            case 1 :
            	List<Student> students = studentDAO.getStudents();
            	for(Student s : students) {
            		System.out.println(s.getId() +" " +s.getId() +" " +s.getFirstName() +" " +s.getLastName() +" " +s.getMarks() +" " );
            	}
            	break;
            case 2 : 
            	studentDAO.save(student);
            	break;
            case 3 : 
            	student = new Student("Sang","Nguyen",9);
            	studentDAO.update(2,student);
            	break;
            case 4 : 
            	studentDAO.delete(2);
            	break;
            case 5 : 
            	Student s = studentDAO.findById(3);
            	System.out.println(s.getId() +" " +s.getId() +" " +s.getFirstName() +" " +s.getLastName() +" " +s.getMarks() +" " );
            	break;
            }
            

            
        }
    }

}
