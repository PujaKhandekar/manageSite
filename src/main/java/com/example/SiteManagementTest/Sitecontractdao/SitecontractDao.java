package com.example.SiteManagementTest.Sitecontractdao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.SiteManagementTest.Sitecontractentities.Company_transaction;
import com.example.SiteManagementTest.Sitecontractentities.Sitecontract;


public interface SitecontractDao extends JpaRepository<Sitecontract, Integer> {

	List<Sitecontract> findBySitename(String sitename);
//public interface SitecontractDao extends JpaRepository{
//public interface SitecontractDao extends CrudRepository{
	//public List<Sitemanagement> findByCompanyname(String companyname);

	List<Sitecontract> findBycontramat(String contra_mat);


//	List<Sitecontract> findBycontra_mat(String contra_mat);


//	List<Sitecontract> findByCont_mat(String contra_mat);

}
