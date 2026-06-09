package com.airtribe.learntrack.entity;

import java.time.LocalDate;
import java.util.Date;

public class Enrollment {

	private int id;
	private int studentId;
	private int courseId;
	private LocalDate enrollmentDate;
	private boolean isCompleted;

	private enum enrollStatus {
		ACTIVE, COMPLETED, CANCELLED
	}

	public Enrollment(int id, int studentId, int courseId, LocalDate enrollmentDate) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.courseId = courseId;
		this.enrollmentDate = enrollmentDate;
	}

	public Enrollment() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "***Enrollment [id=" + id + ", studentId=" + studentId + ", courseId=" + courseId + ", enrollmentDate="
				+ enrollmentDate + "]***";
	}

}
