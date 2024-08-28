package com.amarjeet.jdbc.practical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

class Connect1 {
	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/completejdbc", "root", "root");
			String insertData = "insert into users(name,city,college,number,country) values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(insertData);

			pst.setString(1, "Lakshmi1");
			pst.setString(2, "Hyd");
			pst.setString(3, "ies college");
			pst.setLong(4, 768767575);
			pst.setString(5, "India");
			pst.addBatch();

			pst.setString(1, "Lakshmi2");
			pst.setString(2, "Hyd");
			pst.setString(3, "ies college");
			pst.setLong(4, 768767575);
			pst.setString(5, "India");
			pst.addBatch();

			pst.setString(1, "Lakshmi3");
			pst.setString(2, "Hyd");
			pst.setString(3, "ies college");
			pst.setLong(4, 768767575);
			pst.setString(5, "India");
			pst.addBatch();

			pst.setString(1, "Lakshmi4");
			pst.setString(2, "Hyd");
			pst.setString(3, "ies college");
			pst.setLong(4, 768767575);
			pst.setString(5, "India");
			pst.addBatch();

			// for single insertion
//			int insertedData = pst.executeUpdate();
//			System.out.println("data inserted succesfully" + insertedData);

			int[] insertBatch = pst.executeBatch();
			System.out.println("Data inserted succesfully" + insertData);

			String select = "select *from users";
			ResultSet rs = pst.executeQuery(select);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String city = rs.getString(3);
				String college = rs.getString(4);
				long number = rs.getLong(5);
				String country = rs.getString(6);

				System.out.println("ID: " + id);
				System.out.println("NAME: " + name);
				System.out.println("CITY: " + city);
				System.out.println("COLLEGE:" + college);
				System.out.println("NUMBER: " + number);
				System.out.println("COUNTRY: " + country);
				System.out.println("---------------------");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
