package com.example.SiteManagementTest.Sitecontractservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SiteManagementTest.Sitecontractdao.Company_transactionDao;
import com.example.SiteManagementTest.Sitecontractdao.SitecontractDao;
import com.example.SiteManagementTest.Sitecontractdao.SitemanagementDao;
import com.example.SiteManagementTest.Sitecontractentities.Company_transaction;
import com.example.SiteManagementTest.Sitecontractentities.Sitecontract;
import com.example.SiteManagementTest.Sitecontractentities.Sitemanagement;

@Service
public class SitecontractServiceImpl implements SitecontractService{
	
	@Autowired  //(required = true)
	SitecontractDao sitecontractDao;
	@Autowired  //(required = true)
	SitemanagementDao sitemanagementDao;
	@Autowired  //(required = true)
	Company_transactionDao company_transactionDao;
	
	public SitecontractServiceImpl()
	{
		
	}
	
	@Override
	public List<Sitecontract> getContractor() {
		List<Sitecontract> list = sitecontractDao.findAll();
		return list;
	}

	@Override
	public Optional<Sitecontract> getoneContractor(int sitecontactorId) {
		Optional<Sitecontract> site = null;
		try {
			//return sitecontractDao.getOne((long) sitecontactorId);
			//return sitecontractDao.findById(courseId);
			site =  this.sitecontractDao.findById(sitecontactorId);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return site;
					
	}

	@Override
	public Sitecontract addoneContractor(Sitecontract sitecontactor) {

		Sitecontract site = sitecontractDao.save(sitecontactor);
		return site;
	}

	@Override
	public Sitecontract updateCourse(Sitecontract sitecontactor, int sitecontactorId) {
		
		 sitecontactor.setSitecontramatid(sitecontactorId);
		 return sitecontractDao.save(sitecontactor);
		
		
	}

	@Override
	public void deleteContractor(int sitecontactor) {
		//Sitecontract entity = sitecontractDao.getOne(sitecontactor);
		//sitecontractDao.delete(entity);
		
		
		//Sitecontract entity = sitecontractDao.getById(sitecontactor);
		//sitecontractDao.delete(entity);
		
		//sitecontractDao.deleteById(sitecontactor);
		sitecontractDao.deleteById(sitecontactor);
	}

	
	@Override
	public List<Sitemanagement> getallSite() {
		List<Sitemanagement> site =  sitemanagementDao.findAll();
		return site;
	}

	@Override
	public List<Sitemanagement> getByCompanyname(String companyname) {
		List<Sitemanagement> site =  sitemanagementDao.findByCompanyname(companyname);
		
		return site;
	}

	@Override
	public List<Sitecontract> getContraCompbySite(String sitename) {
		List<Sitecontract> site =  sitecontractDao.findBySitename(sitename);
		
		return site;
	}

	@Override
	public List<Sitecontract> gettransvalues(String contra_mat) {
		List<Sitecontract> site =  sitecontractDao.findAll();
		return site;
	}

	@Override
	public List<Company_transaction> getAvailamt(String sitename) {
		List<Company_transaction> site =  company_transactionDao.findByLedgername(sitename);
		
		return site;
	}

	@Override
	public List<Sitecontract> getContractorValue(String contra_mat) {
		List<Sitecontract> contractor =  sitecontractDao.findBycontramat(contra_mat);
		return contractor;
	}

//	@Override
//	public List<Sitecontract> getContractorValue(String contra_mat) {
//		List<Sitecontract> site =  sitecontractDao.findByCont_mat(contra_mat);
//		return site;
//	}

//	@Override
//	public List<Sitecontract> getContractorValue(String contra_mat) {
//		List<Sitecontract> cont_mat = sitecontractDao.findBycontra_mat(contra_mat);
//		return cont_mat;
//	}

//	@Override
//	public List<Sitemanagement> gettByCompanyname(String companyname) {
//		List<Sitemanagement> site =  sitemanagementDao.gettByCompanyname(companyname);
////		site.forEach(e-> {
////		 e.setSitename(e.getSitename());
////		}
////		);
//		//System.out.println("Hello "+ e+e.getCompanyname()+e.getSitename())
//		return site;
//	}
	
	
	
	// find by name
	//List<Sitecontract> site =  sitecontractDao.findByName(sitecontactorId);
	//site.forEach(e-> System.out.println("Hello"));

	
	
//	@Override
//	public List<Sitecontract> findByName(String companyname) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	
	
	


}