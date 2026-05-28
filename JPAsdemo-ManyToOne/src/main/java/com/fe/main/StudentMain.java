package com.fe.main;

import java.util.List;
import java.util.Scanner;

import com.fe.dao.StudentDAO;
import com.fe.pojo.Student;

public class StudentMain {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO("JPAs");

        int inputKey = -1;
        while (inputKey != 0) {
            // 2. MANG MENU VÀO TRONG VÒNG LẶP ĐỂ IN LẠI MỖI KHI CHẠY XONG 1 CHỨC NĂNG
            System.out.println("\n+++++++++ MENU +++++++++");
            System.out.println("+ 1. Get All Students  +");
            System.out.println("+ 2. Add Student       +");
            System.out.println("+ 3. Update Student    +");
            System.out.println("+ 4. Delete Student    +");
            System.out.println("+ 5. Get a Student     +");
            System.out.println("+ 0. QUIT              +");
            System.out.println("+++++++++ END ++++++++++");
            System.out.print("Please enter a number: ");

            inputKey = console.nextInt();

            // 3. KHỚP SWITCH-CASE ĐÚNG VỚI MENU PHÍA TRÊN
            switch (inputKey) {
                case 1:
                    System.out.println("--- Danh sách Sinh viên ---");
                    List<Student> students = studentDAO.getStudents();
                    for (Student s : students) {
                        System.out.println("Id: " + s.getId() + " First name: " + s.getFirstName() + " Last name: " + s.getLastName() + " Marks: " + s.getMarks());
                    }
                    break;

                case 2:
                    System.out.println("--- Thêm Sinh viên mới ---");
                    Student newStudent = new Student("Sang", "Nguyen", 9);
                    studentDAO.save(newStudent);
                    System.out.println("Đã thêm thành công!");
                    break;

                case 3:
                    System.out.println("--- Cập nhật Sinh viên ---");
                    Student updateStudent = new Student("Sang", "Nguyen", 7);
                    // Lưu ý: Thường khi update ông phải set id cho updateStudent để JPA biết sửa dòng nào
                    studentDAO.update(4, updateStudent);
                    System.out.println("Đã cập nhật thành công!");
                    break; // CỦA ÔNG ĐANG BỊ THIẾU LỆNH BREAK Ở ĐÂY NÈ!

                case 4:
                    System.out.println("--- Xóa Sinh viên ---");
                    studentDAO.delete(1);
                    System.out.println("Đã xóa thành công!");
                    break;

                case 5:
                    System.out.println("--- Tìm Sinh viên theo ID ---");
                    Student foundStudent = studentDAO.findById(1);
                    System.out.println("Id: " + foundStudent.getId() + " First name: " + foundStudent.getFirstName() + " Last name: " + foundStudent.getLastName() + " Marks: " + foundStudent.getMarks());
                    break;

                case 0:
                    System.out.println("Thoát chương trình. Tạm biệt ông nha!");
                    break;

                default:
                    System.out.println("Vui lòng chọn đúng số trên menu!");
                    break;
            }
        }
    }

}
