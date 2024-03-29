package com.controller;

import java.sql.*;

public class RegisterBean {

	Connection connection = null;

	public boolean connectDatabase() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/login_authentication";
			String username = "root";
			connection = DriverManager.getConnection(url, username, "root");
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

	public boolean register(String name, String password, int age, String department, String email ) {
		try {
			String login = "insert into user values(?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(login);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, department);
			try {
				preparedStatement.execute();
				return true;
			}catch (Exception e) {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

}
