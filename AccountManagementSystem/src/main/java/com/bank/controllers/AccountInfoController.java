package com.bank.controllers;
//Added import for using list data type
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Added import for using AccountInfo Dto
import com.bank.dto.AccountInfo;
import com.bank.services.AccountInfoService;

//Controller to get customers account details and create entry in transaction table
@RestController
public class AccountInfoController {

	@Autowired
	private AccountInfoService accountInfoService;
    
	//Rest api to get details of account using the account number
	@GetMapping("/customers/{accno}")
	private List<AccountInfo> findByAccountNo(@PathVariable long accno) {
		return accountInfoService.findByAccountNo(accno);
	}
	
	//Rest api to store transaction details in transaction table
	@PostMapping("/customers/addTransaction")
	private AccountInfo addTransaction(@RequestBody AccountInfo accountInfo) {
		return accountInfoService.addTransaction(accountInfo);

	}


}

