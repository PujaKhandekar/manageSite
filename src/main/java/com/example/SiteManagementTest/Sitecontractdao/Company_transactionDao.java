package com.example.SiteManagementTest.Sitecontractdao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SiteManagementTest.Sitecontractentities.Company_transaction;


public interface Company_transactionDao extends JpaRepository<Company_transaction, Integer> {

	List<Company_transaction> findByLedgername(String sitename);

}
