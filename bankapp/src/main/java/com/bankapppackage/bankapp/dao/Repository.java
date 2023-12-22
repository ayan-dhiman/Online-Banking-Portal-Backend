package com.bankapppackage.bankapp.dao;

import com.bankapppackage.bankapp.beans.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<User, Integer> {

	User findByAccountNumber(long accNumber);

	@Query("from User where phone = ?1")
	User findByPhone(String phone);
	
}
