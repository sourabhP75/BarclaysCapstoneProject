package com.bank.services;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.repositories.BankAccountRepo;
import com.bank.dto.BankAccount;

//Service class for BankAccount
@Service
@Transactional
public class BankAccountService {
	
	@Autowired
	private BankAccountRepo bankAccountRepo;
	
	public BankAccount findByAccountNumber(long accountNumber) {
		return bankAccountRepo.findById(accountNumber).get();
	}
	
	public BankAccount createAccount(BankAccount bankAccount) {
		bankAccountRepo.save(bankAccount);
		return bankAccount;
	}
	public void updateByaccountNumber(double balanceAfterDebit ,long accountNumber) {
		System.out.println(balanceAfterDebit);
		 bankAccountRepo.updateAccount(balanceAfterDebit,accountNumber);
	}
	

}