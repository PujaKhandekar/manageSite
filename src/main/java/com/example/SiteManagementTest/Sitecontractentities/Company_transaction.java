package com.example.SiteManagementTest.Sitecontractentities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilterCt")
@Entity
public class Company_transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionid;
	
	@NotEmpty
	@Size(min=5, message = "Company name is required")
	private String companyname;
	
	@NotEmpty
	@Size(min=5, message = "Ledger name is required")
	private String ledgername;
	
	@NotEmpty
	@Size(min=5, message = "Transaction value is required")
	private double transactionvalue;

	public Company_transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;
	
	@PrePersist
	private void onCreate() {
		createdate = new Date();
	}

	public Company_transaction(int transactionid,
			@NotEmpty @Size(min = 5, message = "Company name is required") String companyname,
			@NotEmpty @Size(min = 5, message = "Ledger name is required") String ledgername,
			@NotEmpty @Size(min = 5, message = "Transaction value is required") double transactionvalue,
			Date createdate) {
		super();
		this.transactionid = transactionid;
		this.companyname = companyname;
		this.ledgername = ledgername;
		this.transactionvalue = transactionvalue;
		this.createdate = createdate;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getLedgername() {
		return ledgername;
	}

	public void setLedgername(String ledgername) {
		this.ledgername = ledgername;
	}

	public double getTransactionvalue() {
		return transactionvalue;
	}

	public void setTransactionvalue(double transactionvalue) {
		this.transactionvalue = transactionvalue;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	@Override
	public String toString() {
		return "Company_transaction [transactionid=" + transactionid + ", companyname=" + companyname + ", ledgername="
				+ ledgername + ", transactionvalue=" + transactionvalue + ", createdate=" + createdate + "]";
	}

	
	
	
}