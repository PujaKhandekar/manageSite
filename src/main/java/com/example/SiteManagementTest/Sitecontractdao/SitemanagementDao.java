package com.example.SiteManagementTest.Sitecontractdao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SiteManagementTest.Sitecontractentities.Sitecontract;
import com.example.SiteManagementTest.Sitecontractentities.Sitemanagement;


public interface SitemanagementDao extends JpaRepository<Sitemanagement, Integer> {

	
//	List<Sitemanagement> gettByCompanyname(String companyname);

	//List<Sitemanagement> getByCompanyname(String companyname);

	
	//public interface SitecontractDao extends JpaRepository{
	//public interface SitecontractDao extends CrudRepository{
		//public List<Sitemanagement> gettByCompanyname(String companyname); // findByCompanyname
	
	//@Query("select s.sitename from Sitemanagement s where s.companyname =:n")
	public List<Sitemanagement> getByCompanyname(String companyname);

	//@Query(value ="select sitename from sitemanagement where companyname =:n",nativeQuery = true)
	public List<Sitemanagement> findByCompanyname(String companyname);

	
	
}