package com.SuperMark.pojo;

public class User {
	String Userid;
	String Userpass;
	
	public User() {}
	public User(String userid, String userpass) {
		super();
		Userid = userid;
		Userpass = userpass;
	}
	
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public String getUserpass() {
		return Userpass;
	}
	public void setUserpass(String userpass) {
		Userpass = userpass;
	}
	
	@Override
	public String toString() {
		return "User [Userid=" + Userid + ", Userpass=" + Userpass + "]";
	}
	
}
