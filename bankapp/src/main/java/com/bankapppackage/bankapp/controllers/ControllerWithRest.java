package com.bankapppackage.bankapp.controllers;

import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bankapppackage.bankapp.beans.Transaction;
import com.bankapppackage.bankapp.beans.User;
import com.bankapppackage.bankapp.dao.Repository;
import com.bankapppackage.bankapp.dao.transactionRepository;

@CrossOrigin
@RestController

public class ControllerWithRest {
	
	@Autowired
	Repository repo;
	
	@Autowired
	transactionRepository transactRepo;
	

	
	@PostMapping("/saveTransaction")
	public void saveTransaction(@RequestBody Transaction transaction)
	{
		//Updating user balance in user table
		User fromUser=repo.findByAccountNumber(transaction.getFrom_acc_no());
		User toUser=repo.findByAccountNumber(transaction.getTo_acc_no());
		double senderBalance=fromUser.getBalance()-transaction.getAmount();
		double receiverBalance=toUser.getBalance()+transaction.getAmount();
		fromUser.setBalance(senderBalance);
		toUser.setBalance(receiverBalance);
		repo.save(fromUser);
		repo.save(toUser);
		
		//Saving Transaction for debit statement in transaction table
		transaction.setAccount(transaction.getFrom_acc_no());
		transaction.setBalance(fromUser.getBalance());
		transaction.setTransactionDate(Calendar.getInstance().getTime().toString());
		transaction.setDescription("Transfer from "+fromUser.getAccountNumber()+" to "+toUser.getAccountNumber());
		transaction.setDebit(Double.toString(transaction.getAmount()));
		transactRepo.save(transaction);
		
		//Saving Transaction for credit statement in transaction table
		Transaction creditTransaction=new Transaction();
		creditTransaction.setAccount(transaction.getTo_acc_no());
		creditTransaction.setAmount(transaction.getAmount());
		creditTransaction.setBalance(toUser.getBalance());
		creditTransaction.setCredit(Double.toString(transaction.getAmount()));
		creditTransaction.setFrom_acc_no(fromUser.getAccountNumber());
		creditTransaction.setTo_acc_no(toUser.getAccountNumber());
		creditTransaction.setDescription(transaction.getDescription());
		creditTransaction.setTransactionDate(Calendar.getInstance().getTime().toString());
		transactRepo.save(creditTransaction);	
		

		
	}
	
	@GetMapping("/getTransactions/{id}")
	public List<Transaction> getUpdate(@PathVariable long id)
	{
		List<Transaction> transactions=(List<Transaction>) transactRepo.findTransactionsById(id);
		return transactions;	
	}
	
	@GetMapping("/getUserPassword/{id}")
	String getPassword(@PathVariable long id)
	{
		User user= repo.findByAccountNumber(id);
		return user.getTransactionPassword();
	}
	
	@GetMapping("/getUserBalance/{id}")
	Double getBalance(@PathVariable long id)
	{
		User user= repo.findByAccountNumber(id);
		return user.getBalance();
	}
	
	@PostMapping("/postUser")
	public void postUser(User user)
	{
		repo.save(user);
		
	}
	
	@PutMapping("/updateUser/{id}")
	public void UpdateUser(@PathVariable long id,@RequestBody User user)
	{
		User updateUser=repo.findByAccountNumber(id);
		
		updateUser.setTransactionPassword(user.getTransactionPassword());
		
		repo.save(updateUser);
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable long id)
	{
		return repo.findByAccountNumber(id);
	}

}
