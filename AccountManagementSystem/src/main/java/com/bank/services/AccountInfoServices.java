package com.bank.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.repositories.AccountInfoDao;
import com.bank.dto.AccountInfo;

//Service class for AccountInfo
@Service
public class AccountInfoService {

	@Autowired
	private AccountInfoDao accountInfoDao;

	public List<AccountInfo> getAllAccounts() { //To get all the Accounts linked with one Common Customer ID
		return accountInfoDao.getAllAccounts();

	}

	public AccountInfo addTransaction(AccountInfo accountInfo) { // To add transactions into the transaction table given a particular customer ID
		return accountInfoDao.addTransaction(accountInfo);

	}

	public List<AccountInfo> findByAccountNo(long accno) {// List of All Common Accounts'
		return accountInfoDao.findByAccountNo(accno);

	}

}
