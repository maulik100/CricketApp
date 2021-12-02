package com.cricket.entities;

public class Student {
	
	private final int id;
	private final String address;
	private final String name;
	
	
	
	public Student(int id, String address, String name) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
	}
	

	public Student() {
		this.id = 0;
		this.address = "";
		this.name = "";
	}


	public int getId() {
		return id;
	}


	public String getAddress() {
		return address;
	}


	public String getName() {
		return name;
	}
	
	
	
	public Student changeName(String newName) {
		Student s1 = new Student(this.id, this.address,newName);
		return s1;
	}
	
	
	public static void main(String[] args) {
		String s = "sanket";
		s.replace("s", "S");
		Student s1 = new Student(1, "R102","Sanket");
		Student s2 = new Student(1, "R103","Sanket Joshi");
		s1 =s2;
		System.out.println();
		
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", address=" + address + ", name=" + name + "]";
	}
	
	
	
	
	
}
