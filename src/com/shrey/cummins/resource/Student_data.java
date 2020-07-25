package com.shrey.cummins.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;

import com.shrey.cummins.model.Exam_model;
import com.shrey.cummins.model.Message;

public class Student_data {

	Connection conn = null;
	Statement stmt = null;
	
	public Student_data()
	{
		try {
			String url = "jdbc:oracle:thin:c##result/Cummins12348765@localhost:1521:orcl";

			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url);
			System.out.println("Connection established "+conn);
			stmt = conn.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	
	
	public List<Exam_model> display(String[] arr, int cno) throws SQLException
	{

		ArrayList<Exam_model> result=new ArrayList<>();
		for(int i=0;i<arr.length;i++)
		{
			String query = "select * from "+arr[i]+" where cno="+cno;
			System.out.println(query);
			Exam_model m;
			int t1;
			int t2;
			int end;
			String batch, subject;
			ResultSet rs = stmt.executeQuery(query);
			   while(rs.next())
			   {
				   cno = rs.getInt("cno");
				   t1=rs.getInt("t1");
				   t2=rs.getInt("t2");
				   end=rs.getInt("end");
				   batch=rs.getString("batch");
				   subject=rs.getString("subject");
				   m=new Exam_model();
				   m.setCno(cno);
				   m.setBatch(batch);
				   m.setT1(t1);
				   m.setT2(t2);
				   m.setEnd(end);
				   m.setSubject(subject);
				   result.add(m);
			   }

		}
				
		return result;
	}
	
	
}
