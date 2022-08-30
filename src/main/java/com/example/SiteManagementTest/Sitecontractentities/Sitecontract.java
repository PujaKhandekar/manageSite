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

@JsonFilter("SomeBeanFilterSc")
@Entity
public class Sitecontract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sitecontramatid;
	
	@NotEmpty
//	@Size(min=5, message = "Company name is required")
	private String companyname;
	
	@NotEmpty
	@Size(min=5, message = "Site name is required")
	private String sitename;
	
	@NotEmpty
	@Size(min=5, message = "Contractor/Material name is required")
	private String contra_mat;
	
	
	private String sitefixamt;
	
	private double available_balance;
	
	private String startdate;
	
	private String enddate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;
	
	@PrePersist
	private void onCreate() {
		createdate = new Date();
	}
	
	public Sitecontract(int sitecontramatid,
			@NotEmpty @Size(min = 5, message = "Company name is required") String companyname,
			@NotEmpty @Size(min = 5, message = "Site name is required") String sitename,
			@NotEmpty @Size(min = 5, message = "Contractor/Material name is required") String contra_mat,
			String sitefixamt, double available_balance, String startdate, String enddate, Date createdate) {
		super();
		this.sitecontramatid = sitecontramatid;
		this.companyname = companyname;
		this.sitename = sitename;
		this.contra_mat = contra_mat;
		this.sitefixamt = sitefixamt;
		this.available_balance = available_balance;
		this.startdate = startdate;
		this.enddate = enddate;
		this.createdate = createdate;
	}

	public Sitecontract() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getSitecontramatid() {
		return sitecontramatid;
	}
	public void setSitecontramatid(int sitecontramatid) {
		this.sitecontramatid = sitecontramatid;
	}

	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getSitename() {
		return sitename;
	}
	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public String getContra_mat() {
		return contra_mat;
	}
	public void setContra_mat(String contra_mat) {
		this.contra_mat = contra_mat;
	}

	public String getSitefixamt() {
		return sitefixamt;
	}
	public void setSitefixamt(String sitefixamt) {
		this.sitefixamt = sitefixamt;
	}

	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	public double getAvailable_balance() {
		return available_balance;
	}

	public void setAvailable_balance(double available_balance) {
		this.available_balance = available_balance;
	}
	
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	@Override
	public String toString() {
		return "Sitecontract [sitecontramatid=" + sitecontramatid + ", companyname=" + companyname + ", sitename="
				+ sitename + ", contra_mat=" + contra_mat + ", sitefixamt=" + sitefixamt + ", available_balance="
				+ available_balance + ", startdate=" + startdate + ", enddate=" + enddate + ", createdate=" + createdate
				+ "]";
	}

	

	
}


