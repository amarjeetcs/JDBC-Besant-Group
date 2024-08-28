package com.jdbc.practical.with.maven.JDBC_With_Maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class App {

	private static final String URL = "jdbc:mysql://localhost:3306/completejdbc";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static Connection con = null;
	
	// if you do not want to create connection object each time then you can write
	// the blow logic
	static {
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection created successfully" + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method to insert a record
	public static void insertRecord(String name, String city, String college, long number, String country)
			throws Exception {
		// Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		String insertSQL = "INSERT INTO users (name, city, college, number, country) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(insertSQL);
		pstmt.setString(1, name);
		pstmt.setString(2, city);
		pstmt.setString(3, college);
		pstmt.setLong(4, number);
		pstmt.setString(5, country);

		int rowsAffected = pstmt.executeUpdate();
		System.out.println("Inserted " + rowsAffected + " row(s) successfully.");

		pstmt.close();
		// con.close();
	}

	// Method to fetch all records
	public static void fetchRecords() throws Exception {
		// Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		String selectSQL = "SELECT * FROM users";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSQL);

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

		rs.close();
		stmt.close();
		// con.close();
	}

	// Method to update a record
	public static void updateRecord(int id, String name, String city, String college, long number, String country)
			throws Exception {
		// Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		String updateSQL = "UPDATE users SET name=?, city=?, college=?, number=?, country=? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(updateSQL);
		pstmt.setString(1, name);
		pstmt.setString(2, city);
		pstmt.setString(3, college);
		pstmt.setLong(4, number);
		pstmt.setString(5, country);
		pstmt.setInt(6, id);

		int rowsAffected = pstmt.executeUpdate();
		System.out.println("Updated " + rowsAffected + " row(s) successfully.");

		pstmt.close();
		// con.close();

	}

	// Method to delete a record
	public static void deleteRecord(int id) throws Exception {
		// Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		String deleteSQL = "DELETE FROM users WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(deleteSQL);
		pstmt.setInt(1, id);

		int rowsAffected = pstmt.executeUpdate();
		System.out.println("Deleted " + rowsAffected + " row(s) successfully.");

		pstmt.close();
//		con.close();
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Choose an option:");
			System.out.println("1. Insert Data");
			System.out.println("2. Fetch Data");
			System.out.println("3. Update Data");
			System.out.println("4. Delete Data");
			System.out.println("5. Exit");
			System.out.print("Enter your choice (1/2/3/4/5): ");
			int choice = sc.nextInt();
			sc.nextLine(); // Consume newline left-over

			switch (choice) {
			case 1:
				// Insert Data
				System.out.println("Enter the Name:");
				String name = sc.nextLine();

				System.out.println("Enter the City:");
				String city = sc.nextLine();

				System.out.println("Enter the College:");
				String college = sc.nextLine();

				System.out.println("Enter the Mobile Number:");
				long number = sc.nextLong();
				sc.nextLine(); // Consume newline left-over

				System.out.println("Enter the Country Name:");
				String country = sc.nextLine();

				insertRecord(name, city, college, number, country);
				break;

			case 2:
				// Fetch Data
				fetchRecords();
				break;

			case 3:
				// Update Data
				System.out.println("Enter the ID of the record to update:");
				int idToUpdate = sc.nextInt();
				sc.nextLine(); // Consume newline left-over

				System.out.println("Enter the new Name:");
				String newName = sc.nextLine();

				System.out.println("Enter the new City:");
				String newCity = sc.nextLine();

				System.out.println("Enter the new College:");
				String newCollege = sc.nextLine();

				System.out.println("Enter the new Mobile Number:");
				long newNumber = sc.nextLong();
				sc.nextLine(); // Consume newline left-over

				System.out.println("Enter the new Country Name:");
				String newCountry = sc.nextLine();

				updateRecord(idToUpdate, newName, newCity, newCollege, newNumber, newCountry);
				break;

			case 4:
				// Delete Data
				System.out.println("Enter the ID of the record to delete:");
				int idToDelete = sc.nextInt();
				sc.nextLine(); // Consume newline left-over

				deleteRecord(idToDelete);
				break;

			case 5:
				// Exit
				System.out.println("Exiting the application. Thanks for using it!");
				sc.close();
				return; // Exit the application

			default:
				System.out.println("Invalid choice. Please enter 1, 2, 3, 4, or 5.");
			}
		}
	}
}
