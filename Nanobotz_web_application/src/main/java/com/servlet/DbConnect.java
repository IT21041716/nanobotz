package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

	private static String url = "jdbc:mysql://localhost:3306/demo_db";
	private static String user = "root";
	private static String password = "Sithanga@1231";
	private static Connection con;

	// establish the database connection
	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, password);
			System.out.println("Database Connection is successfull..!!");
		} catch (Exception e) {
			System.out.println("Database Connection is not success..!!");
			e.printStackTrace();
		}
		return con;
	}

}
