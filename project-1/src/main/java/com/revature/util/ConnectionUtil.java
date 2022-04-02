package com.revature.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static ConnectionUtil cu = null;
	Properties prop;
	private Connection conn;
	
	
	private ConnectionUtil() {
		
//		prop = new Properties();
//		
//		try {
//			File file = new File("/src/main/resources/database.properties");
//			FileReader fileReader = new FileReader(file);
//			prop.load(fileReader);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	public static synchronized ConnectionUtil getConnectionUtil() {
		if(cu == null) {
			cu = new ConnectionUtil();
			}
		return cu;
	}
	
	public Connection getConnection() {
		
		//CONNECT TO POSTGRES DATABASE
		try { 
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/p1", "postgres", "bama0000");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
