package com.bankapppackage.bankapp.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ApplyCreditCard {
	@Id
	@GeneratedValue
	private int id;
	private String fullName;
	private double salary;
	private String mobile;
	private String email;
	private String address;
	private double CreditLimit;
	private String CreditCardNo;

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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getCreditLimit() {
		return CreditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		CreditLimit = creditLimit;
	}
	public String getCreditCardNo() {
		return CreditCardNo;
	}
	public void setCreditCardNo(String creditCardNo) {
		CreditCardNo = creditCardNo;
	}
	@Override
	public String toString() {
		return "ApplyCreditCard [id=" + id + ", fullName=" + fullName + ", salary=" + salary + ", mobile=" + mobile
				+ ", email=" + email + ", address=" + address + ", CreditLimit=" + CreditLimit + ", CreditCardNo="
				+ CreditCardNo + ", accountno=" + accountno + ", isApprovedNow=" + isApprovedNow + "]";
	}
	
	


}
