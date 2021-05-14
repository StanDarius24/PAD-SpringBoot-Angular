package com.example.chatserver.pojo;

public class UserX {
	
	private int id;
	
	private String userName;
	
	public UserX(int id, String userName) {
		this.id = id;
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

}
