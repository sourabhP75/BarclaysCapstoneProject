package com.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.BankAccount;
import com.bank.dto.BankCustomerDetails;
import com.bank.dto.Users;
import com.bank.response.ResponseHandler;
import com.bank.services.BankAccountService;
import com.bank.services.BankCustomerDetailsService;
import com.bank.services.UsersService;


@RestController
public class BankCustomerDetailsController {
	
	@Autowired
	private BankCustomerDetailsService bankCustomerDetailsService;
	@Autowired
	private BankAccountService bankAccountService;
	@Autowired
	private UsersService usersService;
	
	/*
	 * Get User 
	 * by
	 * PAN Number 
	 * if present no need to create account 
	 * else create
	 */
	@GetMapping("/getdetailsbypan/{pannumber}")
	public ResponseEntity<Object> getUserDetailsByPan(@PathVariable String pannumber) {
		try {
			
			BankCustomerDetails bankCustomerDetails =bankCustomerDetailsService.getDetailsByPan(pannumber);
			if(!bankCustomerDetails.equals(null))
			return ResponseHandler.generateResponse("success",HttpStatus.OK, bankCustomerDetails);
			else 
				return ResponseHandler.generateResponse("not found",HttpStatus.OK, null);
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseHandler.generateResponse("failed",HttpStatus.NOT_FOUND, null);
		}
		
	}
	
	/*
	 * Get Account details
	 */
	@GetMapping("/getcustdetails/{customerId}")
	public ResponseEntity<Object> getCustomerDetailsById(@PathVariable Long customerId) {
		try {
			BankCustomerDetails customerDetails= bankCustomerDetailsService.getCustomerDetails(customerId);
			if(customerDetails!=null)
			return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, customerDetails);
			else 
				return ResponseHandler.generateResponse("User not found", HttpStatus.NOT_FOUND, null);
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		}
	}
	
	/*
	 * Create Account
	 * by
	 * Bank Manager- Admin
	 * 
	 */
	@PostMapping("/adduserdetails")
	public ResponseEntity<Object> addUserDetails(@RequestBody BankCustomerDetails customerDetails){
		
		BankCustomerDetails bankCustomerDetailsfromDB =bankCustomerDetailsService.getDetailsByPan(customerDetails.getPanNumber());
		//if user does not exist -> create new one
		if(bankCustomerDetailsfromDB==null) {
		
			try {
				
				BankCustomerDetails bankCustomerDetails = bankCustomerDetailsService.createNewCusomer(customerDetails);
			
				Users newUser = createNewLoginCredentials(bankCustomerDetails);
				
				return ResponseHandler.generatResponseForAccountCreation("Success", HttpStatus.CREATED, bankCustomerDetails,
						createbankAccount(bankCustomerDetails));
				
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseHandler.generatResponseForAccountCreation(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null,null);
			}
		}
		else 
			//if user already exists -> create new account and add that account number to existing customerId
		{
			return ResponseHandler.generatResponseForAccountCreation("User added to existing customer Id", HttpStatus.CREATED, bankCustomerDetailsfromDB,createbankAccount(bankCustomerDetailsfromDB));
		}

	}
	
	
	//Delete 
	
	@DeleteMapping("/deleteuserdetails/{customerId}")
	public ResponseEntity<Object> deleteUserDetails(@PathVariable Integer customerId){
		try {
			bankCustomerDetailsService.deleteCustomer(customerId);
			return ResponseHandler.generateResponse("User deleted", HttpStatus.OK, null);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseHandler.generateResponse("Failed to delete", HttpStatus.BAD_REQUEST, null);
		}
	}
	
	
	public BankAccount createbankAccount(BankCustomerDetails bankCustomerDetails) {
		BankAccount bankAccount = new BankAccount();
		bankAccount.customerId = bankCustomerDetails.getCustomerId();
		
		bankAccountService.createAccount(bankAccount);
		return bankAccount;
	}
	
	/*
	 * User table populated by the details from here
	 */
	public Users createNewLoginCredentials(BankCustomerDetails bankCustomerDetails) {
		Users newUser = new Users();
		newUser.customerId=bankCustomerDetails.getCustomerId();
		newUser.password="aj12P2&^ioa";
		usersService.createUser(newUser);
		return newUser;
	}
}

