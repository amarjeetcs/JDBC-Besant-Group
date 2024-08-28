package com.amarjeet.jdbc.practical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class FeatchData {

	public static void main(String[] args) throws Exception {

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/completejdbc", "root", "root");
		String sql = "{CALL featchData()}";
		CallableStatement callableStatement = connection.prepareCall(sql);

		ResultSet resultSet = callableStatement.executeQuery();

		while (resultSet.next()) {

			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String city = resultSet.getString("city");
			String college = resultSet.getString("college");
			String number = resultSet.getString("number");
			String country = resultSet.getString("country");

			System.out.println("ID: " + id + ", Name: " + name + ", City: " + city + ", College: " + college
					+ ", Number: " + number + ", Country: " + country);

		}
	}
}
