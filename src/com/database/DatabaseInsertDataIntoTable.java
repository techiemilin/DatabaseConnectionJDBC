package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInsertDataIntoTable {

	/*
	 * Steps To connect to Database
	 * 
	 * 1. Connect to the database 
	 * 2. Create the Query Statement 
	 * 3. Execute the Query Statement 
	 * 4. Close the Database Connection
	 * 
	 */

	public static void main(String[] args) throws SQLException {

		// Step 1 - create connection
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin@localhost:1521/pdborc1", "hr", "hr");

		// Step 2 - create statement
		Statement stmt = conn.createStatement();

		// Step 3 - execute statement
		String s = "insert into users values('Milin','Password@123')";
		stmt.executeQuery(s);

		// Step 4 - close connection
		conn.close();
		
		
	}
}
