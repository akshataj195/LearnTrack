package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.util.IdGenerator;

public class StudentService {

	private List<Student> studentList = new ArrayList<>();

	public void addStudent(Student student) {
		studentList.add(student);
		System.out.println("Student Added Successfuly");

	}

	public void addStudent(String firstName, String lastName, String email, String batch) {

		Student student = new Student();

		student.setActive(true);
		student.setBatch(batch);
		student.setEmail(email);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setId(IdGenerator.getStudIDCount());

		studentList.add(student);
		System.out.println("Student Added Successfuly");
	}

	public void listStudent() {
		if (studentList.isEmpty()) {
			System.out.println("Student Not Found...!!!");
		} else {
			for (Student student : studentList) {
				if (student.isActive()) {
					System.out.println(student.toString());
				}
			}
		}
	}

	public Student getStudentByID(int studID) {
		if (studentList.isEmpty()) {
			System.out.println("Student Not Found...!!!");
		} else {
			for (Student student : studentList) {
				if (student.getId() == studID) {
					return student;
				}
			}
		}
		return null;
	}

	public void removeStudent(int studID) {

		Student removeStudent = getStudentByID(studID);

		if (removeStudent != null) {
			removeStudent.setActive(false);
			System.out.println("Student Removed Succesfully");
		} else {
			System.out.println("Student Not Found...!!!");
		}
	}

	public void updateStudent(int id, String batch) {

		Student student = getStudentByID(id);

		if (student != null) {
			student.setBatch(batch);
			System.out.println("Student updated successfully!");
			System.out.println("Updated Student Record :: " + student.toString());
		} else {
			System.out.println("Student Not Found...!!!");
		}
	}
}
