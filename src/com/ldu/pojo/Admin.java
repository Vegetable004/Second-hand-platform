package com.ldu.pojo;

public class Admin {
	private Integer id;
	private String userName;
	private Long phone;
	private String password;
	private String userRole;
	
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

	
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", phone=" + phone + ", password=" + password
				+ ", userRole=" + userRole + "]";
	}
	
	
}
