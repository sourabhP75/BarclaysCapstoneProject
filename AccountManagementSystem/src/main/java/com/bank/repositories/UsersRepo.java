package com.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.dto.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{
	@Query(value="select * from users where customer_id=?1", nativeQuery=true)
	Users findByCustomerId(long customer_id);

}
