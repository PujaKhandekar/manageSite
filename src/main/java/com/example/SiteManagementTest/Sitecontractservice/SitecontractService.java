package com.example.SiteManagementTest.Sitecontractservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.example.SiteManagementTest.Sitecontractentities.Company_transaction;
import com.example.SiteManagementTest.Sitecontractentities.Sitecontract;
import com.example.SiteManagementTest.Sitecontractentities.Sitemanagement;

public interface SitecontractService {
	
	public List<Sitecontract> getContractor();

	public Optional<Sitecontract> getoneContractor(int sitecontactorId);

	public Sitecontract addoneContractor(Sitecontract sitecontactor);

	public Sitecontract updateCourse(Sitecontract sitecontactor, int sitecontactorId);

	public void deleteContractor(int sitecontactor);
// SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id
	//@Query(value="select sitename from sitemanagement where companyname =:n",nativeQuery = true)
	//public List<Sitemanagement> gettByCompanyname(@Param("n") String companyname);

	public List<Sitemanagement> getallSite();
	
	//@Query("select s.sitename from Sitemanagement s where s.companyname =:n")
	@Query(value ="select sitename from sitemanagement where companyname =:n",nativeQuery = true)
	public List<Sitemanagement> getByCompanyname(String companyname);

	public List<Sitecontract> getContraCompbySite(String sitename);

	public List<Sitecontract> gettransvalues(String contra_mat);

	public List<Company_transaction> getAvailamt(String sitename);

	public List<Sitecontract> getContractorValue(String contra_mat);

//	public List<Sitecontract> getContractorValue(String contra_mat);
	
//	@Query(value ="select sitefixamt from sitecontract where contra_mat =:n",nativeQuery = true)
//	@Query(value = "SELECT sitefixamt FROM sitecontract where contra_mat = ?1", nativeQuery = true)

	
}