package com.bank.services;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.repositories.BankAccountRepo;
import com.bank.repositories.BankCustomerDetailsRepo;
import com.bank.dto.BankCustomerDetails;

//Service Class for BankCustomerDetails
@Service
@Transactional
public class BankCustomerDetailsService {

	@Autowired
	private BankCustomerDetailsRepo bankCustomerDetailsRepo;
	@Autowired
	private BankAccountRepo bankAccountRepo;
	//Create
	public BankCustomerDetails createNewCusomer(BankCustomerDetails bankCustomerDetails) {
		
		
		bankCustomerDetailsRepo.save(bankCustomerDetails);
		
		return bankCustomerDetails;
	}
	
	//Read
	public BankCustomerDetails getCustomerDetails(Long customerId) {
		return  bankCustomerDetailsRepo.findByCustomerId(customerId);
			
	}
	
	//Update
	
	
	//Delete - 
	public void deleteCustomer(Integer customerId) {
		bankCustomerDetailsRepo.deleteById(customerId);
		
	}
	public BankCustomerDetails getDetailsByPan(String pannumber) {
		
		return bankCustomerDetailsRepo.findByPannumber(pannumber);
		
	}
}
