package com.bank.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Table to add Role Details
@Entity
@Table(name = "Role")
public class Role {
	//Variable to store role id
	@Id
	@NotNull
	public long roleId;
	//Variable to store role name
	public String roleName;
	
	
	//Default constructor
	public Role() {

	}
	//Parameterised constructor
	public Role(@NotNull long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
    //Getter for role id
	public long getRoleId() {
		return roleId;
	}
    //Setter for Role id
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
