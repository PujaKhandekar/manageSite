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

@JsonFilter("SomeBeanFilterSm")
@Entity
public class Sitemanagement {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int siteid;
	
	private int companyid;
	
	@NotEmpty
	@Size(min=5, message = "Company name is required")
	private String companyname;
	
	@NotEmpty
	@Size(min=5, message = "site name is required")
	private String sitename;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;
	
	@PrePersist
	private void onCreate() {
		createdate = new Date();
	}
	
	private double sitefixamt;
	
	public Sitemanagement(int siteid, int companyid,
			@NotEmpty @Size(min = 5, message = "Company name is required") String companyname,
			@NotEmpty @Size(min = 5, message = "site name is required") String sitename, Date createdate,
			double sitefixamt) {
		super();
		this.siteid = siteid;
		this.companyid = companyid;
		this.companyname = companyname;
		this.sitename = sitename;
		this.createdate = createdate;
		this.sitefixamt = sitefixamt;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date creatdate) {
		this.createdate = creatdate;
	}

	public Sitemanagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSiteid() {   
		return siteid;
	}

	public void setSiteid(int siteid) {
		this.siteid = siteid;
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
	
	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	
	public double getSitefixamt() {
		return sitefixamt;
	}

	public void setSitefixamt(double sitefixamt) {
		this.sitefixamt = sitefixamt;
	}

	@Override
	public String toString() {
		return "Sitemanagement [siteid=" + siteid + ", companyid=" + companyid + ", companyname=" + companyname
				+ ", sitename=" + sitename + ", createdate=" + createdate + ", sitefixamt=" + sitefixamt + "]";
	}

	
	
}

