package com.shrey.cummins.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login_database {

	Connection conn=null;
	Statement stmt=null;
	public login_database()
	{
		try {
//			String url = "jdbc:oracle:thin:system/Cummins12348765@localhost:1521:orcl";

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","shrey_25");
			System.out.println("Connection established "+conn);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	}
