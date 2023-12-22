package com.bankapppackage.bankapp.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class ApplyDebitCard {
	@Id
	@GeneratedValue
	private int id;
	private String fullName;
	private String mobile;
	private String email;
	private String address;
	private String DebitCardNo;
	

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
	public String getDebitCardNo() {
		return DebitCardNo;
	}
	public void setDebitCardNo(String debitCardNo) {
		DebitCardNo = debitCardNo;
	}
	@Override
	public String toString() {
		return "ApplyDebitCard [id=" + id + ", fullName=" + fullName + ", mobile=" + mobile + ", email=" + email
				+ ", address=" + address + ", DebitCardNo=" + DebitCardNo + ", accountno=" + accountno
				+ ", isApprovedNow=" + isApprovedNow + "]";
	}

	
	

}
