package com.bankapppackage.bankapp.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int transaction_id;
	String Description;

	
	String TransactionDate;

	double amount;
	long from_acc_no;
	long to_acc_no;
	long account;
	
	double balance;
	
	String debit;
	String credit;
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public long getFrom_acc_no() {
		return from_acc_no;
	}
	public void setFrom_acc_no(long from_acc_no) {
		this.from_acc_no = from_acc_no;
	}
	public long getTo_acc_no() {
		return to_acc_no;
	}
	public void setTo_acc_no(long to_acc_no) {
		this.to_acc_no = to_acc_no;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	public String getTransactionDate() {
		return TransactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		TransactionDate = transactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}


