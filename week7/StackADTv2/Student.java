package week7.StackADTv2;

import java.util.*;

public class Student {
	
	private String id, name, gender;
	private int age;
	private double gpa;
	
	//Construtor
	public Student() {
		
	}
	
	public Student(String id, String name, String gender, int age, double gpa) {
		
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.gpa = gpa;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public void setStudent(String id, String name, String gender, int age, double gpa) {
		
		setId(id);
		setName(name);
		setGender(gender);
		setAge(age);
		setGpa(gpa);
		
	}
	
	public String getStudent() {
		return id + "\t" + name + "\t" + gender + "\t" + age + "\t" + "\t" + gpa + "\n";
		
	}
}
