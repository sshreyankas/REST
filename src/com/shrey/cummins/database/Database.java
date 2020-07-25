package com.shrey.cummins.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shrey.cummins.model.Message;

import java.io.*;

public class Database {
	
	Connection conn = null;
	Statement stmt = null;
	public Database()
	{
		try {
//			String url = "jdbc:oracle:thin:system/Cummins12348765@localhost:1521:orcl";
//
//			Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","shrey_25");
			
//			conn = DriverManager.getConnection(url);
			System.out.println("Connection established "+conn);
			stmt = conn.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	
	
	
	public Message addProfile(Message m)
	{
		try {
			String url = "jdbc:oracle:thin:system/Cummins12348765@localhost:1521:orcl";

			System.out.println(m.getCno()+" "+m.getName());
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url);
			System.out.println("Connection established "+conn);
			String query = "insert into B201718 "+"values(?,?)";
			System.out.println(query);
			int cno=m.getCno();
			String name=m.getName();
			PreparedStatement prep_statement;
			 prep_statement = conn.prepareStatement(query);
			 prep_statement.setInt(1, cno);
			 prep_statement.setString(2, name);
			 prep_statement.execute();
//			   conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return m;
	}
	public List<Message> getAllMessages() throws SQLException
	{
		List<Message> result=new ArrayList<>();
		String query = "select * from B201718";
		   int cno;
		   String name;
		   ResultSet rs = stmt.executeQuery(query);
		   Message m;
		   while(rs.next())
		   {
			   cno = rs.getInt("cno");
			   name = rs.getString("name");
			   m=new Message();
			   m.setCno(cno);
			   m.setName(name);
			   result.add(m);
		   }
		   return result;
	}
	
	public String getByID(int cno) throws SQLException
	{
		String query = "select * from B201718 where cno="+cno;
		   String name="";
		   ResultSet rs = stmt.executeQuery(query);
		   while(rs.next())
		   {
			   name = rs.getString("name");
			   
		   }
		   return name;
	}
	
	public Message updateProfile(Message m) 
	{
		try {
			
			String query = "update B201718 set NAME = ?"+" where CNO = ?";
			PreparedStatement prep_statement;
			 prep_statement = conn.prepareStatement(query);
			 prep_statement.setString(1, m.getName());
			 prep_statement.setInt(2, m.getCno());
			 
			 prep_statement.execute();
//			   conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		   return m;
	}
	
	public void deleteProfile(int cno) throws SQLException
	{
		String query = "delete from B201718 where cno = ?";
		   PreparedStatement prep_stmt  = conn.prepareStatement(query);
		   prep_stmt.setInt(1,cno);
		   prep_stmt.execute();
	}
		

}
