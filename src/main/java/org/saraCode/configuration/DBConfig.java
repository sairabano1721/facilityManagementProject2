package org.saraCode.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBConfig {

	@Value("${jdbc.driverClassName}")
	private String JDBC_DRIVER;
	@Value("${jdbc.url}")
	private String URL;
	@Value("${jdbc.username}")
	private String USERNAME;
	@Value("${jdbc.password}")
	private String PASSWORD;

	public Connection getConnection() {
		Connection conn = null;
		try {
			JDBC_DRIVER = getDriverNameAndValiDate(JDBC_DRIVER);
			URL = getURL(URL);
			USERNAME = getUsername(USERNAME);
			PASSWORD = getPasswordAndValidate(PASSWORD);
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception se) {
			se.printStackTrace();
		}
		return conn;

	}

	private String getDriverNameAndValiDate(String JDBC_DRIVER) {
		if (JDBC_DRIVER == null)
			JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		return JDBC_DRIVER;
	}

	private String getURL(String URL) {
		if (URL == null)
			URL = "jdbc:mysql://localhost:3306/sql3395846";
		return URL;
	}

	private String getUsername(String USERNAME) {

		if (USERNAME == null)
			USERNAME = "root";

		return USERNAME;

	}

	private String getPasswordAndValidate(String PASSWORD) {

		if (PASSWORD == null)
			PASSWORD = "root";

		return PASSWORD;

	}

}
