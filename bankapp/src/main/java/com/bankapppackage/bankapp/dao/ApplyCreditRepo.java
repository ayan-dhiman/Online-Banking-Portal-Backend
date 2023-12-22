package com.bankapppackage.bankapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bankapppackage.bankapp.beans.ApplyCreditCard;



public interface ApplyCreditRepo extends CrudRepository<ApplyCreditCard, Integer> {

Iterable<ApplyCreditCard> findAllById(long id);
	
	@Query("from ApplyCreditCard where accountno=?1 and isApprovedNow=?2")
	public ApplyCreditCard getRequests(long accountno,int isApprovedNow);
	
	@Query("from ApplyCreditCard where accountno=?1 and (isApprovedNow=0 or isApprovedNow=1)")
	public ApplyCreditCard getUndeniedRequest(long accountno);
	
	@Query("from ApplyCreditCard where accountno=?1 and isApprovedNow=2")
	public ApplyCreditCard getDeniedRequest(long accountno);
	
	@Query("from ApplyCreditCard where accountno=?1")
	public Iterable<ApplyCreditCard> getAllRequestForAccount(long accountno);
	
}
 