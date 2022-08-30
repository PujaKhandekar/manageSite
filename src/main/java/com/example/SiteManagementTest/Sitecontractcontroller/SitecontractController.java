package com.example.SiteManagementTest.Sitecontractcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SiteManagementTest.Sitecontractentities.Company_transaction;
import com.example.SiteManagementTest.Sitecontractentities.Sitecontract;
import com.example.SiteManagementTest.Sitecontractentities.Sitemanagement;
import com.example.SiteManagementTest.Sitecontractservice.SitecontractService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class SitecontractController {
	
	@Autowired
	private SitecontractService sitecontractService;
	
	@GetMapping("/homesite")
	public String home()
	{
		return "Welcome ! HOME";
		
	}
	
	//get all sitecontactor
	@GetMapping("/sitecontactor")  // **
	public ResponseEntity<List<Sitecontract>> getContractor()
	{
	
		// return this.sitecontractService.getContractor();
//		List<Sitemanagement> siteC =  sitecontractService.findByCompanyname("ABCD");
//		siteC.forEach(e-> System.out.println("Hello "+ e.getCompanyname()));
		
		    List<Sitecontract> list = sitecontractService.getContractor();
		    if(list.size()<=0){
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		    }
		    return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	//get particular course
	@GetMapping("/onesitecontactor/{sitecontactorId}")  // **
	public ResponseEntity<Optional<Sitecontract>> getoneContractor(@PathVariable int sitecontactorId)
	{
		//return this.sitecontractService.getoneContractor(sitecontactorId);

		Optional<Sitecontract> site = sitecontractService.getoneContractor(sitecontactorId);
				if(site == null){
				    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				           
				}
				//site.get().getCompanyname();
		
				
				
				return ResponseEntity.of(Optional.of(site));
	}
	
	//add particular contractor
	@PostMapping("/addsitecontactor")   //  ,consumes = "application/json")  // not taking same values
	public ResponseEntity<Sitecontract> addoneContractor(@RequestBody Sitecontract sitecontactor)
	{
		Sitecontract site = null;
		try{
		
		    site = this.sitecontractService.addoneContractor(sitecontactor);
		    System.out.println(site);
		   // return ResponseEntity.of(Optional.of(site));
		    return ResponseEntity.status(HttpStatus.CREATED).body(site);
		    
		}
		  catch(Exception e){
		   
		    e.printStackTrace();
		    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		  }
	//	return this.sitecontractService.addoneContractor(sitecontactor);
		
	}
	
	//update particular course
	@PutMapping("/updatesitecontactor/{sitecontactorId}")  //**
	public ResponseEntity<Sitecontract> updateContractor(@RequestBody Sitecontract sitecontactor,@PathVariable int sitecontactorId)
	{	
		Sitecontract site = null;
		try { 
			    site = this.sitecontractService.updateCourse(sitecontactor,sitecontactorId);
			    System.out.println(site);
			   // return ResponseEntity.of(Optional.of(site));
			    return ResponseEntity.status(HttpStatus.CREATED).body(site);
			
		} catch (Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		//return sitecontactor;
		
		
	}
	
	// delete the course
	@DeleteMapping("/deletesitecontactor/{sitecontactorId}")  //**
	public ResponseEntity <String> deleteContractor(@PathVariable int sitecontactorId){
		//	HttpStatus  responce = null;
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("Record", SiteCmplist);
//		m.put("status", true);
//		m.put("msg", "Showing all data");
//		System.out.println("site record  "+m);
//		return new ResponseEntity<Map>(m,HttpStatus.OK);
		
		
		 ResponseEntity response = null;
		 String Msg = null;
	    try{
	    //	courseId = null;     
	       Optional<Sitecontract> site = sitecontractService.getoneContractor(sitecontactorId);
			
	       if(site == null){
	    	  // Msg = "ID does not Exist";
	    	   m.put("status", false);
	    	   m.put("msg", "Cannot DELETE data");
	    	   response = new ResponseEntity<>(m,HttpStatus.NOT_FOUND);
	    	 //  response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	       }
	       else {
		       this.sitecontractService.deleteContractor(sitecontactorId);
		      // Msg = "DELETE successful";
		       m.put("status", true);
		       m.put("msg", "DELETE successful");
		       response = new ResponseEntity<>(m,HttpStatus.OK);
		      // response = new ResponseEntity<>(HttpStatus.OK);
		      // return new ResponseEntity<>(HttpStatus.OK);
	        }
	   }catch(Exception e){
		//   Msg = "Cannot DELETE data";
		//	m.put("Record", site);
			m.put("status", false);
			m.put("msg", "Cannot DELETE data");
		  // System.out.println(e + "  ERRORRSSS");
		  // response =  new ResponseEntity<>(Msg,HttpStatus.INTERNAL_SERVER_ERROR);
		   response =  new ResponseEntity<>(m,HttpStatus.INTERNAL_SERVER_ERROR);
	       // return new ResponseEntity<>(Msg,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	//	return new ResponseEntity<>(HttpStatus.values(courseId));
		return response;
	//	 return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getsitenametran")  // **
	public MappingJacksonValue getallSitename()
	{		
		List<Sitecontract> siteC =  sitecontractService.getContractor();
		
		//invoking static method filterOutAllExcept()  
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("sitename");  
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilterSc",filter);  
		//constructor of MappingJacksonValue class that has list as constructor argument  
		MappingJacksonValue mapping = new MappingJacksonValue(siteC);  
		//configuring filter  
		mapping.setFilters(filters);  
		System.out.println(mapping+"\n"+filters);
		return mapping;  
		

	}
	
//	************
	@GetMapping("/getcontracomp/{sitename}")  // **
	public MappingJacksonValue getContraCompbySite(@PathVariable String sitename)
	{
		Map<String, Object> m = new HashMap<String, Object>();
		// return this.sitecontractService.getContractor();
	//	List<Sitemanagement> siteC =  sitecontractService.findByCompanyname("ABCD");
	//	siteC.forEach(e-> System.out.println("Hello "+ e.getCompanyname()));
		
		List<Sitecontract> siteC =  sitecontractService.getContraCompbySite(sitename);
//		siteC.forEach(e-> m.put("msg1",e.getSitename())		
//		);
		
		List<Company_transaction> sitetran =  sitecontractService.getAvailamt(sitename);
//		sitetran.forEach(e-> m.put("msg2",e.getLedgername())
//		);
		
		// available_balance  contra
		
		//invoking static method filterOutAllExcept()  
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("companyname","contra_mat");  
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilterSc",filter);  
		
//		SimpleBeanPropertyFilter filterCt = SimpleBeanPropertyFilter.filterOutAllExcept("transactionvalue");  
//		FilterProvider filtersCt=new SimpleFilterProvider().addFilter("SomeBeanFilterCt",filterCt);  
		//constructor of MappingJacksonValue class that has list as constructor argument  
		MappingJacksonValue mapping = new MappingJacksonValue(siteC);  
//		MappingJacksonValue mappingCt = new MappingJacksonValue(sitetran);  
		//configuring filter  
		mapping.setFilters(filters); 
//		mappingCt.setFilters(filtersCt); 
		System.out.println(mapping+"\n"+filters);
		
		 m.put("msg",mapping);
//		 m.put("msgCt",mappingCt);
		// return m;
		return mapping;  
		
		
	}
//	***************
	@GetMapping("/gettransvalues/{contra_mat}")  // **
	public MappingJacksonValue getfortrans(@PathVariable String contra_mat)
	{
		Map<String, Object> m=new HashMap<String, Object>();
		// return this.sitecontractService.getContractor();
	//	List<Sitemanagement> siteC =  sitecontyyyyyyyyyyyyyyyyyyyyyyyyyyyyractService.findByCompanyname("ABCD");
	//	siteC.forEach(e-> System.out.println("Hello "+ e.getCompanyname()));
		
		List<Sitecontract> siteC =  sitecontractService.gettransvalues(contra_mat);
		siteC.forEach(e-> m.put("msg",e.getSitename())
		);
		
		List<Sitemanagement> sitemang =  sitecontractService.getallSite();
		sitemang.forEach(e-> m.put("msg",e.getSitename())
		);
		
//		//invoking static method filterOutAllExcept()  
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("sitefixamt");  
//		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilterSc",filter);  
//		SimpleBeanPropertyFilter filterS = SimpleBeanPropertyFilter.filterOutAllExcept("sitefixamt");  
//		FilterProvider filtersS=new SimpleFilterProvider().addFilter("SomeBeanFilterSm",filter);  
//		//constructor of MappingJacksonValue class that has list as constructor argument  
//		MappingJacksonValue mapping = new MappingJacksonValue(siteC);  
//		MappingJacksonValue mappingS = new MappingJacksonValue(sitemang);  
//		//configuring filter  
//	    mapping.setFilters(filters); 
//		mappingS.setFilters(filters); 
//		System.out.println(mapping.toString()+"\n"+filters);
//		 m.put("msg",mapping);
//		 m.put("msgS",mappingS);
		//return mapping;  
		 return (MappingJacksonValue) m;
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	
	
	@GetMapping("/sitemanagment")  // **
	public List<Sitemanagement> getallSite()
	{
	
		// return this.sitecontractService.getContractor();
	//	List<Sitemanagement> siteC =  sitecontractService.findByCompanyname("ABCD");
	//	siteC.forEach(e-> System.out.println("Hello "+ e.getCompanyname()));
		
		List<Sitemanagement> siteC =  sitecontractService.getallSite();
		//siteC.forEach(e-> System.out.println("Hello "+ e.getCompanyname()));
		
		return siteC;
		
//		    List<Sitecontract> list = sitecontractService.getContractor();
//		    if(list.size()<=0){
//		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		    }
//		    return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@GetMapping("/getcompanyname")  // **
	public MappingJacksonValue getallCompanyname()
	{		
		List<Sitemanagement> siteC =  sitecontractService.getallSite();
		
		//invoking static method filterOutAllExcept()  
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("companyname");  
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilterSm",filter);  
		//constructor of MappingJacksonValue class that has list as constructor argument  
		MappingJacksonValue mapping = new MappingJacksonValue(siteC);  
		//configuring filter  
		mapping.setFilters(filters);  
		System.out.println(mapping+"\n"+filters);
		return mapping;  
		

	}
	
	
	@GetMapping("/sitecomp/{companyname}")  // **
	public MappingJacksonValue getSitebyComp(@PathVariable String companyname)
	{
		Map<String, Object> m=new HashMap<String, Object>();
		// return this.sitecontractService.getContractor();
	//	List<Sitemanagement> siteC =  sitecontractService.findByCompanyname("ABCD");
	//	siteC.forEach(e-> System.out.println("Hello "+ e.getCompanyname()));
		
		List<Sitemanagement> siteC =  sitecontractService.getByCompanyname(companyname);
		siteC.forEach(e-> m.put("msg",e.getSitename())
				
		);
		
		//invoking static method filterOutAllExcept()  
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("sitename");  
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilterSm",filter);  
		//constructor of MappingJacksonValue class that has list as constructor argument  
		MappingJacksonValue mapping = new MappingJacksonValue(siteC);  
		//configuring filter  
		mapping.setFilters(filters);  
		System.out.println(mapping+"\n"+filters);
		return mapping;  
		
		
		//return m;
		//return siteC;
		//System.out.println("Hello "+ e.getCompanyname()+" "+e.getSitename())
//		    List<Sitecontract> list = sitecontractService.getContractor();
//		    if(list.size()<=0){
//		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		    }
//		    return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	@GetMapping("/getContractorValue")
	public ResponseEntity<Map> getContractorValue(@PathVariable String contra_mat){
		System.out.println("*********************");
		List<Sitecontract> ContValList = new ArrayList<Sitecontract>();
		ContValList = this.sitecontractService.getContractorValue(contra_mat);
		System.out.println("contractor wise value  "+ContValList);
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("Record", ContValList);
		m.put("status", true);
		m.put("msg", "All Values contractor wise");
		System.out.println("Values contractor wise  "+m);
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}	
	
}

