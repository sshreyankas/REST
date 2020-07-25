package com.shrey.cummins.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.shrey.cummins.model.Exam_model;
import com.shrey.cummins.resource.Student_data;

@Path("/result")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class All_in_one {
	
	String[] sem1= {"M1","Phy1","Chem1"};
	String[] sem3= {"Data structures","OS","DM"};
	String[] sem5= {"DBMS","CC","CN"};
	Student_data s=new Student_data();
	
	@GET
	@Path("/{cno}")
	public List<Exam_model> getResult(@PathParam("cno") int cno) throws SQLException
	{
		return s.display(sem1,cno);
	}

}
