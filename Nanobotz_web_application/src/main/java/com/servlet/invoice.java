package com.servlet;

public class invoice {

	private int id;
	private String date;
	private double total;
	private int points;
	private int profile_id;
	
	
	public invoice(int id, String date, double total, int points, int profile_id) {
		this.id = id;
		this.date = date;
		this.total = total;
		this.points = points;
		this.profile_id = profile_id;
	}


	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public double getTotal() {
		return total;
	}

	public int getPoints() {
		return points;
	}

	public int getProfile_id() {
		return profile_id;
	}


}
