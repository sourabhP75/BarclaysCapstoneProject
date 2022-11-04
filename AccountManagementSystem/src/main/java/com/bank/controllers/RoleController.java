package com.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.Role;
import com.bank.response.ResponseHandler;
import com.bank.services.RoleService;

@RestController
public class RoleController {
//Controller to add perform get and put operations in Role table
	@Autowired
	private RoleService roleService;
	
	//Get operation to fetch data based on role id
	@GetMapping("/getrole/{roleId}")
	public ResponseEntity<Object> getRole(@PathVariable Integer roleId){
		try {
		
			Role extRole =roleService.getRoleById(roleId);
			return ResponseHandler.generateResponse("success", HttpStatus.OK, extRole);
		
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		}
	}
	
	//Post operation to add data in role table
	@PostMapping("/createrole")
	public ResponseEntity<Object> createRole(@RequestBody Role role){
		try {
			Role newRole = roleService.createRole(role);
			return ResponseHandler.generateResponse("created", HttpStatus.CREATED, newRole);
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
	

}

