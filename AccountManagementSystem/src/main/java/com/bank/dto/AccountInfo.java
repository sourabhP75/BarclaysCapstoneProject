package com.bank.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class AccountInfo {

	@Id
//	@GenericGenerator(name = "kaugen", strategy = "increment")
//	@GeneratedValue(generator = "kaugen")
	
	//Variable to denote unique transaction id
	private int id;
	//Variable to denote account number
	private long accno;
	//Variable to denote transaction date
	private String tdate;
	//Variable to denote remarks
	private String remarks;
	//Variable to refernce number
	private long refno;
	//Variable to balance
	private long balance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getRefno() {
		return refno;
	}

	public void setRefno(long refno) {
		this.refno = refno;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

}
