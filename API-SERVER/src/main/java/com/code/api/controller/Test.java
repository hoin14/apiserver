package com.code.api.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/apiserver?serverTimezone=UTC&characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD =  "1111";
	
	public static void main(String[] args) throws SQLException {
		testConnet();
	}
	public static void testConnet() throws SQLException {
		try {
			Class.forName(DRIVER);
			Connection cn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println(cn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
			
}
