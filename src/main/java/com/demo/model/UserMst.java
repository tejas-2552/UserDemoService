package com.demo.model;

public class UserMst {

	public Integer id;
	public String userName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserMst [id=" + id + ", userName=" + userName + "]";
	}

}
