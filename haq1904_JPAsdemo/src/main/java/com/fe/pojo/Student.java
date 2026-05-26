package com.fe.pojo;


import javax.persistence.*;

@Entity
@Table (name = "STUDENTS")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "firstName", nullable = false, unique = false)
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "marks")
	private int marks;
	
	public Student() {
		
	}
	
public Student(String firstName, String lastName, int marks) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.marks = marks;
	}

	public int getMarks() {
		return marks;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
