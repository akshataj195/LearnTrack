package com.airtribe.learntrack.util;

public class IdGenerator {

	private static int studIDCount = 0;
	private static int courseIDCount = 0;
	private static int enrollmentCount = 0;

	public static int getStudIDCount() {
		return ++studIDCount;
	}

	public static int getCourseIDCount() {
		return ++courseIDCount;
	}

	public static int getEnrollmentCount() {
		return ++enrollmentCount;
	}

}
