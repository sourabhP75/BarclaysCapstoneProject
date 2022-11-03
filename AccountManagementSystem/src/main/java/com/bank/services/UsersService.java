package com.bank.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.repositories.UsersRepo;
import com.bank.dto.Users;

//Service class for Users
@Service
@Transactional
public class UsersService {
	@Autowired
	private UsersRepo userRepo;
	
	//@SuppressWarnings("deprecation")
	public Users getUserById(Integer customerId) {
		return userRepo.findByCustomerId(customerId);
	}

	public Users createUser(Users user) {
		return userRepo.save(user);
	}
	
	public void deleteUser(Integer customerId) {
		userRepo.deleteById(customerId);
	}
	public Users findByCustomerId(Long customer_id) {
		return userRepo.findByCustomerId(customer_id);
	}
}

