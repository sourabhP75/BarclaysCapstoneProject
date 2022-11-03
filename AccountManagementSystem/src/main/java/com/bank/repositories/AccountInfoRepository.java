package com.bank.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.dto.AccountInfo;
//import com.bank.dto.Users;

public interface AccountInfoRepository extends JpaRepository<AccountInfo, Integer> {
	@Query(value="select * from accountinfo where accno=?1", nativeQuery=true) //Query to create the AccountInfo table in Database
	AccountInfo findByAccountNo(long accno);
}
