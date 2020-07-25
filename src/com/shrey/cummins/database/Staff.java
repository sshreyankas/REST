//package com.shrey.cummins.database;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//public class Staff {
//	
//	Connection conn=null;
//	Statement stmt=null;
//	public Staff()
//	{
//		try {
//			String url = "jdbc:oracle:thin:system/Cummins12348765@localhost:1521:orcl";
//
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn = DriverManager.getConnection(url);
//			System.out.println("Connection established "+conn);
//			stmt = conn.createStatement();
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
//	}
//	
//	public void addResult()
//	{
//		String query = "insert into  "+"values(?,?)";
//		System.out.println(query);
////		int cno=m.getCno();
////		String name=m.getName();
//		PreparedStatement prep_statement;
//		 prep_statement = conn.prepareStatement(query);
//		 prep_statement.setInt(1, cno);
//		 prep_statement.setString(2, name);
//		 prep_statement.execute();
//	}
//}
