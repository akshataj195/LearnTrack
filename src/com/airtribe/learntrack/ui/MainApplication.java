package com.airtribe.learntrack.ui;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;

import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

public class MainApplication {

	public static void main(String[] args) {

		StudentService studentService = new StudentService();
		EnrollmentService enrollmentService = new EnrollmentService();
		CourseService courseService = new CourseService();

		Scanner scanner = new Scanner(System.in);
		System.out.println("**** Welcome to Learntrack ****");

		boolean exitMainMenu = false;

		while (!exitMainMenu) {
			System.out.println("Select Option : " + "\r\n1.Student Management " + "\r\n2.Course Management "
					+ "\r\n3.Enrollment Management " + "\r\n4.Exit");

			int choice = -1;
			try {
				choice = scanner.nextInt();
			} catch (Exception e) {
				// If non-int entered, consume and continue
			}
			scanner.nextLine();

			switch (choice) {
			case 1 -> {
				boolean exitStudMenu = false;
				while (!exitStudMenu) {
					System.out.println("Select option : " + "\r\n1.Add new student" + "\r\n2.View all students"
							+ "\r\n3.Search student by ID" + "\r\n4.Deactivate a student" + "\r\n5.Back to Main Menu");

					int studOption = scanner.nextInt();
					scanner.nextLine();

					switch (studOption) {
					case 1 -> {
						System.out.println("\nEnter Student's First Name : ");
						String firstName = scanner.nextLine();

						System.out.println("\nEnter Student's Last Name : ");
						String LastName = scanner.nextLine();

						System.out.println("\nEnter Student's Email : ");
						String email = scanner.nextLine();

						System.out.println("\nEnter Student's Batch : ");
						String batch = scanner.nextLine();

						studentService.addStudent(firstName, LastName, email, batch);
					}

					case 2 -> studentService.listStudent();

					case 3 -> {
						System.out.println("Enter Student ID : ");
						int studentID = scanner.nextInt();
						scanner.nextLine();
						Optional.ofNullable(studentService.getStudentByID(studentID)).ifPresentOrElse(
								student -> System.out.println(student.toString()),
								() -> System.out.println("Student Not Found...!!!"));

					}

					case 4 -> {
						System.out.println("Enter Student ID : ");
						int removeStudentID = scanner.nextInt();
						scanner.nextLine();
						studentService.removeStudent(removeStudentID);
					}

					case 5 -> exitStudMenu = true;

					default -> System.out.println("Invalid Choice..");
					}
				}
			}

			case 2 -> {
				boolean exitCourseMenu = false;
				while (!exitCourseMenu) {
					System.out.println("Select option : " + "\r\n1.Add new course" + "\r\n2.View all courses"
							+ "\r\n3.Deactivate course" + "\r\n4.Back to Main Menu");

					int courseOption = scanner.nextInt();
					scanner.nextLine();

					switch (courseOption) {
					case 1 -> {
						System.out.println("Enter Course Name : ");
						String courseName = scanner.nextLine();

						System.out.println("Enter Course Description : ");
						String desc = scanner.nextLine();

						System.out.println("Enter Duration in number of week : ");
						int noOfWeeks = scanner.nextInt();
						scanner.nextLine();

						courseService.addCourse(courseName, desc, noOfWeeks);
					}

					case 2 -> courseService.listCourse();

					case 3 -> {
						System.out.println("Enter Course ID to be deactivated : ");
						int removeCourse = scanner.nextInt();
						scanner.nextLine();
						courseService.removeCourse(removeCourse);
					}

					case 4 -> exitCourseMenu = true;

					default -> System.out.println("Invalid Choice..");
					}
				}
			}

			case 3 -> {
				boolean exitEnrollMenu = false;
				while (!exitEnrollMenu) {
					System.out.println("Select option : " + "\r\n1.Enroll a student in a course"
							+ "\r\n2.View enrollments for a student" + "\r\n3.Mark enrollment as completed/cancelled"
							+ "\r\n4.Back to Main Menu");

					int enrollChoice = scanner.nextInt();
					scanner.nextLine();

					switch (enrollChoice) {

					case 1 -> {
						System.out.println("Enter Student ID : ");
						int studID = scanner.nextInt();
						scanner.nextLine();

						System.out.println("Enter Course ID : ");
						int courseID = scanner.nextInt();
						scanner.nextLine();

						System.out.println("Enter Enrollment Date (yyyy-MM-dd) : ");
						String enrollDate = scanner.nextLine();
						try {
							LocalDate date = LocalDate.parse(enrollDate);
							enrollmentService.addEnrollment(studID, courseID, date);
						} catch (DateTimeParseException e) {
							System.out.println("Invalid date format. Please use yyyy-MM-dd.");
						}
					}

					case 2 -> enrollmentService.listEnrollments();

					case 3 -> {
						System.out.println("Enter Enrollment ID to be completed/cancelled : ");
						int enrollID = scanner.nextInt();
						scanner.nextLine();
						enrollmentService.removeEnrollment(enrollID);
					}

					case 4 -> exitEnrollMenu = true;

					default -> System.out.println("Invalid Choice.");
					}
				}
			}

			case 4 -> {
				System.out.println("Exiting..");
				exitMainMenu = true;
			}

			default -> System.out.println("Invalid Choice.");
			}
		}
		scanner.close();
	}
}
