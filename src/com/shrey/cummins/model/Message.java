package com.shrey.cummins.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private int cno;
	private String name;
	
	public Message()
	{
		
	}
	
	public Message(int cno, String name)
	{
		this.cno=cno;
		this.name=name;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
