package com.servlet;

public class profile {

	private int id;
	private String salutation;
	private String firstname;
	private String lastname;
	private String tel;
	private String address;
	private String email;

	public profile(int id, String salutation, String firstname, String lastname, String tel, String address,
			String email) {
		this.id = id;
		this.salutation = salutation;
		this.firstname = firstname;
		this.lastname = lastname;
		this.tel = tel;
		this.address = address;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getSalutation() {
		return salutation;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

}
