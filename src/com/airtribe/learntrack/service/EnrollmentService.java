package com.airtribe.learntrack.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.util.IdGenerator;

public class EnrollmentService {

	List<Enrollment> enrollList = new ArrayList<>();

	public void addEnrollment(Enrollment enroll) {
		enrollList.add(enroll);
		System.out.println("Enrollment Added Successfully");
	}

	public void addEnrollment(int studID, int courseID, LocalDate enrollDate) {

		Enrollment enroll = new Enrollment();

		enroll.setId(IdGenerator.getEnrollmentCount());
		enroll.setCourseId(courseID);
		enroll.setStudentId(studID);
		enroll.setCompleted(false);
		enroll.setEnrollmentDate(enrollDate);

	}

	public void listEnrollments() {
		if (enrollList.isEmpty()) {
			System.out.println("No Enrollments Found..!!");
		} else {
			for (Enrollment enrollment : enrollList) {
					System.out.println(enrollment.toString());
			}
		}
	}

	public Enrollment findByID(int id) {

		for (Enrollment enrollment : enrollList) {
			if (enrollment.getId() == id) {
				return enrollment;
			}
		}
		return null;
	}

	public void removeEnrollment(int id) {

		Enrollment enrollment = findByID(id);

		if (enrollment != null) {
			enrollment.setCompleted(true);
			System.out.println("Enrollment Deleted..!!");
		} else {
			System.out.println("enrollement not found");
		}
	}

	public void updateEnrollment(int id, LocalDate enrollmentDate) {

		Enrollment enroll = findByID(id);

		if (enroll != null) {
			enroll.setEnrollmentDate(enrollmentDate);
			System.out.println("Enrollment Updated Successfully");
			System.out.println("Updated Enrollment :: " + enroll.toString());
		}
	}
}
