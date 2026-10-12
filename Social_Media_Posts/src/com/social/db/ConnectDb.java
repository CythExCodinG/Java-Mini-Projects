package com.social.db;

import com.social.util.*;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class ConnectDb {
	public static Connection connectToDb() throws SQLException, UserInputValidation {
		String urlString="jdbc:mysql://localhost/student_manager";
		Connection conn=DriverManager.getConnection(urlString,"root","tiger");
		if(conn==null) {
			throw new UserInputValidation("Db cannot be connected error in pass or dbname");
		}else {
			System.out.println("Connected to DB******");
		}
		return conn;
	}
}
