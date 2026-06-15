package com.fe.dao;

import java.util.List;



import com.fe.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAO {

    private SessionFactory sessionFactory = null;
    private Configuration cf = null;

    public StudentDAO(String persistenceName) {
        cf = new Configuration();
        cf = cf.configure(persistenceName);
        sessionFactory = cf.buildSessionFactory();
    }

    public void save(Student student) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(student);
            t.commit();
            System.out.println("Successfully saved");
        } catch (Exception ex) {
            t.rollback();
            System.out.println(("Error " + ex.getMessage()));
        } finally {
            session.close();
        }
    }

    public List<Student> getStudents() {
        List<Student> students = null;
        Session session = sessionFactory.openSession();
        try {
            students = session.createQuery("from Student", Student.class).getResultList();
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            session.close();
        }
        return students;
    }

    public void delete(long studentId) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            t.begin();
            Student student =(Student) session.get(Student.class, studentId);
            session.delete(student);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            System.out.println("Error " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public Student findById(long studentId) {
        Session session = sessionFactory.openSession();
        try {
            return (Student) session.get(Student.class,studentId);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            throw e;
        } finally {
            session.close();
        }
    }

    public void update(int id, Student student) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(student);
            t.commit();
            System.out.println("update saved");
        } catch (Exception e) {
            t.rollback();
            System.out.println("Error " + e.getMessage());
        } finally {
            session.close();
        }
    }
}
