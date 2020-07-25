package com.shrey.cummins.resource;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.shrey.cummins.database.login_database;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class loginresource {
	
	login_database l=new login_database();
	
	@GET
	public int get(@QueryParam("who") String who,
					@QueryParam("cno") int cno,
					@QueryParam("pass") String pass) throws SQLException
	{
		System.out.println(who+" "+cno+" "+pass);
		return l.get(who,cno,pass);
	}

}
