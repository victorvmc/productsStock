package br.com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	static Connection connection;
	
	public static Connection getConnection() {
	if (connection != null) {
		return connection;
	}else {
	String url = "jdbc:mysql://localhost:3306/";
	String dbName ="stockdb"; 
	String uname = "user";
	String pwd = "userroot";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(url+dbName,uname,pwd);
	} catch (ClassNotFoundException e) {
		// TODO Auto-geconnectionnerated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
	}
	}
}
