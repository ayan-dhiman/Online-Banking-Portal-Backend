package com.bankapppackage.bankapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bankapppackage.bankapp.beans.Transaction;



public interface transactionRepository extends CrudRepository<Transaction, Integer> {

	@Query("from Transaction t where t.account=?1")
	List<Transaction> findTransactionsById(long id);
}
