package com.util;

import  java.sql.DriverManager;
import  java.sql.SQLException;
import  java.sql.Connection;

public class DBConnection{
	
	public static Connection con;
	public static Connection getCon() {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost3306/Medical?useSSL=false","root","sql@7");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
