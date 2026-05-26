package com.fe.dao;

import java.util.List;
import javax.persistence.*;
import com.fe.pojo.*;

public class StudentDAO {
	private static EntityManager em;
	private static EntityManagerFactory emf;
	
	public StudentDAO(String persistenceName){
		emf = Persistence.createEntityManagerFactory(persistenceName);
	}
	
	public void save(Student student) {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(student);
			em.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println(("Error " + ex.getMessage()));
		}finally{
			em.close();
		}
	}
	
	public List<Student> getStudents(){
		List<Student> students = null;
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			students = em.createQuery("from Student").getResultList();
		}catch (Exception ex){
			System.out.println("Error " + ex.getMessage());
		}
		finally {
			em.close();
		}
		return students;
	}
	
	public void delete(long studentId){
		try{
			em= emf.createEntityManager();
			em.getTransaction().begin();
			Student foundStudent = em.find(Student.class, studentId);
			em.remove(foundStudent);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}finally {
			em.close();
		}
	}

	public Student findById(long studentId){
		Student foundStudent= null;
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			foundStudent = em.find(Student.class, studentId);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}finally{
			em.close();
		}

		return foundStudent;
	}

	public void update(Student student){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Student studentToAdd = em.find(Student.class, student.getId());
			if(studentToAdd != null) {
				studentToAdd.setFirstName(student.getFirstName());
				studentToAdd.setLastName(student.getLastName());
				studentToAdd.setMarks(student.getMarks());
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}finally {
			em.close();
		}
	}
}

