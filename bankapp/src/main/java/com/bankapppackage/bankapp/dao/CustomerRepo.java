package com.bankapppackage.bankapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bankapppackage.bankapp.beans.Customer;



public interface CustomerRepo extends CrudRepository<com.bankapppackage.bankapp.beans.Customer, Integer>{
	
Iterable<Customer> findAllById(long id);
	
	@Query("from Customer where accountno=?1 and isApprovedNow=?2")
	public Customer getRequests(long accountno,int isApprovedNow);
	
	@Query("from Customer where accountno=?1 and (isApprovedNow=0 or isApprovedNow=1)")
	public Customer getUndeniedRequest(long accountno);
	

	@Query("from Customer where accountno=?1 and isApprovedNow=2")
	public Customer getDeniedRequest(long accountno);
	
	@Query("from Customer where accountno=?1")
	public Iterable<Customer> getAllRequestForAccount(long accountno);
	
}