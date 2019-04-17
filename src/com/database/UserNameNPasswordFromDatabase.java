package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UserNameNPasswordFromDatabase {

	@Test
	public void deteleDataFromTable() throws SQLException {

		System.setProperty("webdriver.chrome.driver", "/Users/milinpatel/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com/");

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

			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("login")).click();

			if (driver.getTitle().equals("Finda a Flight: Mercury Tours:")) {
				System.out.println("Testcase has Passed");
			} else {
				System.out.println("Testcase has failed");
			}

		}

		// Step 4 - close connection
		conn.close();

	}

}
