package com.lenore.dappad.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	@GeneratedValue
	private Integer userRoleId;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
	private Username username;
	
	private String role;

	public UserRole() {
	}

	public UserRole(Username username, String role) {
		this.username = username;
		this.role = role;
	}
	
	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Username getUsername() {
		return username;
	}

	public void setUsername(Username user) {
		this.username = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
