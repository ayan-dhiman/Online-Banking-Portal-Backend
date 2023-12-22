package com.bankapppackage.bankapp.beans;

public class AccountNumber {
	
	private long accNumber;

	public long getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}

	@Override
	public String toString() {
		return "AccountNumber [accNumber=" + accNumber + "]";
	}

}
