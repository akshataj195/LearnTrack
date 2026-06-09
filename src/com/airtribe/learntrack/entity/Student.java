package com.airtribe.learntrack.entity;

public class Student extends Person {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String batch;
	private boolean active;

	public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.batch = batch;
		this.active = active;
	}

	public Student(int id, String firstName, String lastName, String batch, boolean active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.batch = batch;
		this.active = active;
	}

	public Student(int id, String firstName, String lastName, String email) {
		super(id, firstName, lastName, email);
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public void getDisplayName() {
		System.out.println("Hii.... I am Student" + getFirstName());
	}

	@Override
	public String toString() {
		return "****Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", batch=" + batch + ", active=" + active + "]****";
	}
	
	
}
