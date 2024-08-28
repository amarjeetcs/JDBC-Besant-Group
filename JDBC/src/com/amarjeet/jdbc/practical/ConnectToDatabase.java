package com.amarjeet.jdbc.practical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectToDatabase {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Load the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Connection parameters
			String mySqlHostName = "jdbc:mysql://localhost:3306/completejdbc";
			String userName = "root";
			String password = "root";

			// Establish the connection
			con = DriverManager.getConnection(mySqlHostName, userName, password);
			System.out.println("Connection created successfully: " + con);

			// Create a statement
			stmt = con.createStatement();

			// Insert data
			String sql = "INSERT INTO users (name, city, college, number, country) "
					+ "VALUES ('John Doe1', 'New York1', 'Harvard University1', '1234567890', 'USA')";
			stmt.execute(sql);
			System.out.println("Data inserted successfully: " + sql);

			// Delete data
			String delete = "DELETE FROM users WHERE id=1";
			stmt.execute(delete);
			System.out.println("Data deleted successfully");

			// Fetch data
			String fetch = "SELECT * FROM users";
			rs = stmt.executeQuery(fetch);

			// Process the result set
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
				String college = rs.getString("college");
				long number = rs.getLong("number");
				String country = rs.getString("country");

				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("City: " + city);
				System.out.println("College: " + college);
				System.out.println("Number: " + number);
				System.out.println("Country: " + country);
				System.out.println("----------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace(); // Print any exception that occurs
		} finally {
			try {
				// Close the ResultSet
				if (rs != null)
					rs.close();

				// Close the Statement
				if (stmt != null)
					stmt.close();

				// Close the Connection
				if (con != null)
					con.close();

				System.out.println("Resources closed successfully.");
			} catch (Exception e) {
				e.printStackTrace(); // Handle any exceptions during resource closing
			}
		}
	}
}