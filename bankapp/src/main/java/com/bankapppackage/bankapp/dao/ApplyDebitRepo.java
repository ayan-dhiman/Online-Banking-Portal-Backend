package com.bankapppackage.bankapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bankapppackage.bankapp.beans.ApplyDebitCard;



public interface ApplyDebitRepo extends CrudRepository<com.bankapppackage.bankapp.beans.ApplyDebitCard, Integer> {

	Iterable<ApplyDebitCard> findAllById(long id);
	
	@Query("from ApplyDebitCard where accountno=?1 and isApprovedNow=?2")
	public ApplyDebitCard getRequests(long accountno,int isApprovedNow);
	
	@Query("from ApplyDebitCard where accountno=?1 and (isApprovedNow=0 or isApprovedNow=1)")
	public ApplyDebitCard getUndeniedRequest(long accountno);
	

	@Query("from ApplyDebitCard where accountno=?1 and isApprovedNow=2")
	public ApplyDebitCard getDeniedRequest(long accountno);
	
	@Query("from ApplyDebitCard where accountno=?1")
	public Iterable<ApplyDebitCard> getAllRequestForAccount(long accountno);

	
} 
