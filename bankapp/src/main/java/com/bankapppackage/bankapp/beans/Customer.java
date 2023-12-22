package com.bankapppackage.bankapp.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Customer {

	
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private long amount;
	private int loanPeriod;
	private String typeLoan;
	private long accountno;
	private int isApprovedNow;
	
	
	
	public long getAccountno() {
		return accountno;
	}
	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}
	public int getIsApprovedNow() {
		return isApprovedNow;
	}
	public void setIsApprovedNow(int isApprovedNow) {
		this.isApprovedNow = isApprovedNow;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public int getLoanPeriod() {
		return loanPeriod;
	}
	public void setLoanPeriod(int loanPeriod) {
		this.loanPeriod = loanPeriod;
	}
	public String getTypeLoan() {
		return typeLoan;
	}
	public void setTypeLoan(String typeLoan) {
		this.typeLoan = typeLoan;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", email=" + email + ", amount=" + amount + ", loanPeriod=" + loanPeriod + ", typeLoan=" + typeLoan
				+ ", accountno=" + accountno + ", isApprovedNow=" + isApprovedNow + "]";
	}
	
	

}



