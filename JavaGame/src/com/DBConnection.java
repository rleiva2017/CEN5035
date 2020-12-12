package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class is used to create DB connection or close DB connection.
 * 
 * @version 17 Oct 2019
 * @author KwangSoo Yang 
 */

public class DBConnection {

	/**
	 * Creates DB connection.
	 * 
	 * @param url      a database url of the form jdbc:subprotocol:subname
	 * @param user     user
	 * @param password password
	 * @return a Connection to the URL
	 * @throws Exception if a database access error occurs
	 */

	public static Connection getConnection(final String url, final String user, final String password) throws Exception {
		final Properties props = new Properties();
		props.put("user", user);
		props.put("password", password);
		System.out.println("Class loaded:" + Class.forName("oracle.jdbc.driver.OracleDriver"));
		System.out.println("[URL] " + url);
		System.out.println(DriverManager.getConnection(url, props));
		return DriverManager.getConnection(url, props);
	}

	/**
	 * Closes DB connection.
	 * 
	 * @param conn DB Connection
	 * 
	 */

	public static void close(final Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException se) {
				// nothing
			}
		}
	}

}
