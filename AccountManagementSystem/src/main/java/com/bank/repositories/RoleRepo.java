package com.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.dto.Role;
//Repository to add role functionality
public interface RoleRepo extends JpaRepository<Role, Integer>{
	@Query(value="select * from role where role_id=?1", nativeQuery=true)
	Role findByRoleId(long role_id);

}
