package com.amarjeet.jdbc.practical;

import java.sql.*;

public class WithStoredProcedure {

	// Database URL, username, and password
	private static final String URL = "jdbc:mysql://localhost:3306/completejdbc";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static void main(String[] args) {
		// Example calls to methods
		//insertData(108, "amarjeet singh", "bangalore", "ies college bhpal", 6261535069l, "india");
		//fetchData();
		updateData(108, "Jane Doe", "Los Angeles", "XYZ University", 9876543210L, "india");
		//deleteAllRecords();
	}

	public static void insertData(int id, String name, String city, String college, long number, String country) {
		String insertProcedure = "{CALL insertData(?, ?, ?, ?, ?,?)}";

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				CallableStatement insertStatement = connection.prepareCall(insertProcedure)) {

			insertStatement.setInt(1,id);
			insertStatement.setString(2, name);
			insertStatement.setString(3, city);
			insertStatement.setString(4, college);
			insertStatement.setLong(5, number);
			insertStatement.setString(6, country);

			insertStatement.executeUpdate();
			System.out.println("Data inserted successfully.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void fetchData() {
		String fetchProcedure = "{CALL InsertUsersWithPrimaryKey()}";

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				CallableStatement fetchStatement = connection.prepareCall(fetchProcedure);
				ResultSet resultSet = fetchStatement.executeQuery()) {

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String city = resultSet.getString("city");
				String college = resultSet.getString("college");
				long number = resultSet.getLong("number");
				String country = resultSet.getString("country");

				System.out.println("ID: " + id + ", Name: " + name + ", City: " + city + ", College: " + college
						+ ", Number: " + number + ", Country: " + country);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateData(int id, String name, String city, String college, long number, String country) {
		String updateProcedure = "{CALL UpdateUser(?, ?, ?, ?, ?, ?)}";

		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				CallableStatement updateStatement = connection.prepareCall(updateProcedure)) {

			updateStatement.setInt(1, id);
			updateStatement.setString(2, name);
			updateStatement.setString(3, city);
			updateStatement.setString(4, college);
			updateStatement.setLong(5, number);
			updateStatement.setString(6, country);

			updateStatement.executeUpdate();
			System.out.println("Data updated successfully.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteAllRecords() {
		String deleteProcedure = "{CALL DeleteAllUsers()}";

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				CallableStatement deleteStatement = connection.prepareCall(deleteProcedure)) {

			deleteStatement.executeUpdate();
			System.out.println("All records deleted successfully.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
