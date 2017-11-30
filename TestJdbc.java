package com.comcast.iot.va;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/testDB";

	// Database credentials
	static final String USER = "username";
	static final String PASS = "password";

	public static void main(String[] args) {
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, "postgres", "test");
			System.out.println("Connection :: " + connection);
			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			Statement stmt = connection.createStatement();
			String sql;
			sql = "SELECT * FROM videoanalyzer.video_analyzer_file";
			sql = "select vafilename0_.id as id1_0_, vafilename0_.gateway_mac as gateway_2_0_, vafilename0_.file_name as file_nam3_0_ from videoanalyzer.video_analyzer_file vafilename0_";
			sql = "SELECT nextval('videoanalyzer.va_file_seq') as nextVal";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// Retrieve by column name
//				int id = rs.getInt("id1_0_");
//				String fileName = rs.getString("file_nam3_0_");
//				String device = rs.getString("device_i2_0_");
				
				int id = rs.getInt("nextVal");
//				String fileName = rs.getString("file_nam3_0_");
//				String device = rs.getString("gateway_2_0_");

				// Display values
				System.out.print("ID: " + id);
//				System.out.print(", Age: " + fileName);
//				System.out.print(", First: " + device);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
