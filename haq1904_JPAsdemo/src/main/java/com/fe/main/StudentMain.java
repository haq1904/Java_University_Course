package com.fe.main;
import com.fe.pojo.Student;
import com.fe.dao.StudentDAO;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args){
        System.out.println("+++++++++MENU+++++++++");
        System.out.println("+ 1. Get Students +");
        System.out.println("+ 2. Add Student +");
        System.out.println("+ 3. Delete Student +");
        System.out.println("+ 4. Update Student +");
        System.out.println("+ 5. Delete Student +");
        System.out.println("+ 6. Get a Student +");
        System.out.println("+ 0. QUIT +");
        System.out.println("+++++++++END++++++++++");
        int inputKey = -1;
        while (inputKey != 0) {
            Scanner console = new Scanner(System.in);
            System.out.println("Please enter a number !");
            inputKey = console.nextInt();
            StudentDAO studentDAO = new StudentDAO("JPAs");
            Student student = new Student("Lam", "Nguyen", 9);
            switch (inputKey) {
                case 0:
                    break;
                case 1:
                    studentDAO.save(student);
                    break;
                case 2:
                    studentDAO.delete(1);
                    break;
                case 3:
                    student = new Student("Sang", "Nguyen", 9);
                    studentDAO.update (student);
                case 4:
                    studentDAO.findById(1);
                    break;
                default:
                    System.out.println("Please choice menu !");
            }
        }
    }

}
