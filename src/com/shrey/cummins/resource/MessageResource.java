package com.shrey.cummins.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.shrey.cummins.database.Database;
import com.shrey.cummins.model.Message;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class MessageResource {

	Database g = new Database();
	@GET
	public List<Message> message() throws SQLException
	{
		return g.getAllMessages();
		
	}
	
	@POST
	public Message add(Message m)
	{
		
		return g.addProfile(m);
	}
	
	@GET
	@Path("/{cno}")
	public String getBycno(@PathParam("cno") int cno) throws SQLException
	{
		return g.getByID(cno);
	}
	
	@PUT
	@Path("/{cno}")
	public Message updateProfile(@PathParam("cno")int cno, Message m) throws SQLException
	{
		m.setCno(cno);
		return g.updateProfile(m);
	}
	
	@DELETE
	@Path("/{cno}")
	public void delete(@PathParam("cno") int cno) throws SQLException
	{
		g.deleteProfile(cno);
	}
	
}
