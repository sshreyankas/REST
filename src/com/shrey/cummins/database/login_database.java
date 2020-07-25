package com.shrey.cummins.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.shrey.cummins.model.Message;

public class login_database {

	Connection conn=null;
	Statement stmt=null;
	public login_database()
	{
		try {
			String url = "jdbc:oracle:thin:system/Cummins12348765@localhost:1521:orcl";

			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url);
			System.out.println("Connection established "+conn);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public int get(int cno, String pass) throws SQLException
	{
		String query = "select * from B201718";
		ResultSet rs = stmt.executeQuery(query);
		Message m;
		   while(rs.next())
		   {
			   return 1;
		   }
		return 0;
	}
}
