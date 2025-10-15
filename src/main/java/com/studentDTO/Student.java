package com.studentDTO;
//pojo class
public class Student {
	private int id;
	private String name;
	private Long phone;
	private String email;
	private String branch;
	private String loc;
	private String password;
	private String confirmpassword;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	public String toString() {
		return "   Student Details\n" +
				"Sid       : " + id + "\n"+
	            "Name      : " + name + "\n" +
	            "Phone     : " + phone + "\n" +
	            "Email     : " + email + "\n" +
	            "Branch    : " + branch + "\n" +
	            "Location  : " + loc + "\n";
	}
	
	
}
