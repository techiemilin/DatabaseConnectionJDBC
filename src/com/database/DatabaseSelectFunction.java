package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseSelectFunction {

	/*
	 * Steps To connect to Database
	 * 
	 * 1. Connect to the database 2. Create the Query Statement 3. Execute the Query
	 * Statement 4. Close the Database Connection
	 * 
	 */

	@Test
	public void deteleDataFromTable() throws SQLException {

		// Step 1 - create connection

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin@localhost:1521/pdborc1", "hr", "hr");

		// Step 2 - create statement
		Statement stmt = conn.createStatement();

		// Step 3 - execute statement
		String s = "select uname,password from users";
		ResultSet res = stmt.executeQuery(s);

		while (res.next()) {
			String username = res.getString("uname");
			String password = res.getString("password");

			System.out.println(username + "  ");
			System.out.println(password);

		}

		// Step 4 - close connection
		conn.close();
	}

}
