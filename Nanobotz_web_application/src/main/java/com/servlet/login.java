package com.servlet;

public class login {

	private int id;
	private String username;
	private String password;
	private String profile_id;

	public login(int id, String username, String password, String profile_id) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.profile_id = profile_id;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getProfile_id() {
		return profile_id;
	}

}
