package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.util.IdGenerator;

public class CourseService {

	private List<Course> courseList = new ArrayList<>();

	public void addCourse(Course course) {
		courseList.add(course);
		System.out.println("Course Added Successfuly");

	}

	public void addCourse(String courseName, String description, int durationInWeeks) {

		Course course = new Course();

		course.setActive(true);
		course.setId(IdGenerator.getCourseIDCount());
		course.setCourseName(courseName);
		course.setDescription(description);
		course.setDurationInWeeks(durationInWeeks);

		courseList.add(course);
		System.out.println("Course Added Successfuly");
	}

	public void listCourse() {
		if (courseList.isEmpty()) {
			System.out.println("Course Not Found...!!!");

		} else {
			for (Course course : courseList) {
				if (course.isActive()) {
					System.out.println(course.toString());
				}
			}
		}
	}

	public Course getCourseByID(int courseID) {

		for (Course course : courseList) {
			if (course.getId() == courseID) {
				return course;
			}
		}
		return null;
	}

	public void removeCourse(int courseID) {

		Course removeCourse = getCourseByID(courseID);

		if (removeCourse != null) {
			removeCourse.setActive(false);
			System.out.println("Course Removed Succesfully");
		} else {
			System.out.println("Course Not Found...!!!");
		}
	}

	public void updateCourse(int id, String name) {

		Course course = getCourseByID(id);

		if (course != null) {
			course.setCourseName(name);
			System.out.println("Course updated successfully!");
			System.out.println("Updated Course Record :: " + course.toString());
		} else {
			System.out.println("Course Not Found...!!!");
		}
	}

}
