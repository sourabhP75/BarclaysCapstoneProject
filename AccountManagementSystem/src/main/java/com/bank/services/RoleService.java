package com.bank.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.repositories.RoleRepo;
import com.bank.dto.Role;

//Service class for Role
@Service
@Transactional
public class RoleService {
	@Autowired
	private RoleRepo roleRepo;
	
    //Getter for role id
	public Role getRoleById(Integer roleId) {
		return roleRepo.findByRoleId(roleId);
	}
    //Create new role in role table
	public Role createRole(Role role) {
		return roleRepo.save(role);
	}
    //Delete role from role table
	public void deleteRole(Integer roleId) {
		roleRepo.deleteById(roleId);
	}
    //Find a role using the role id
	public Role findByRoleId(Long role_id) {
		return roleRepo.findByRoleId(role_id);
	}
}

