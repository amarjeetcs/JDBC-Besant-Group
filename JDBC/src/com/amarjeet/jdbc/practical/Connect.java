package com.amarjeet.jdbc.practical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class Connect {
	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/completejdbc", "root", "root");
			Statement st = con.createStatement();

			String select="select *from users";
			ResultSet rs=st.executeQuery(select);
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String city=rs.getString(3);
				String college=rs.getString(4);
				long number=rs.getLong(5);
				String country=rs.getString(6);
				
				System.out.println(id);
				System.out.println(name);
				System.out.println(city);
				System.out.println(college);
				System.out.println(number);
				System.out.println(country);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
