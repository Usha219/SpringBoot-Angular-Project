package com.practice.portal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.MapKeyType;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.portal.entities.Customer;
import com.practice.portal.model.CustomerModel;
import com.practice.portal.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/customers")
public class LoginController {

	GsonBuilder builder=new GsonBuilder();
	Gson gson=builder.create();
	
    @Autowired
	private CustomerRepository custrepo; 
    
    @PostMapping(value="/save")
    public String postCustomer(@RequestBody CustomerModel cust) {
    String response="Submitted Successfully";
    System.out.println("PostMapping Started");
    Customer _cust=custrepo.save(new Customer(cust.getFirstName(),cust.getLastName(),cust.getEmailId(),cust.getCountry(),cust.getGender(),cust.getPasswords().get("passwd"),cust.getPasswords().get("confpassword")));	
    System.out.println("PostMapping completed");
    return gson.toJson(response);
    	
    }
    
    
    public List<String> getAllEmail() {
    	List<String> em=custrepo.getAllEmail();
    	
		return em;
    	
}
    @GetMapping(value="/find/email/{emailId}")
    public String searchEmail(@PathVariable String emailId) {
    	List<String> email=getAllEmail();
    	if(email.contains(emailId)) {
    		return gson.toJson("Found");
    	}
    	else {
    		return gson.toJson("Not Found");    	
    	}
		}
   
    @GetMapping(value="/validate/empass")
    public Object findByemailIdAndpassword(@RequestParam("emailId") String emailId,@RequestParam("password")String password){
    	Object epass=custrepo.findByemailIdAndpassword(emailId, password);
    	boolean var=true;
    	if(epass==null) {
    		var=false;
    		return gson.toJson("EmailId or password is incorrect");
    		
    	}
    	if(var) {
    		if(epass.equals(password))
    		return gson.toJson("success");
    		else {
    			return gson.toJson("EmailId or password is incorrect");
    		}
    	}
    	else {
    		return gson.toJson("EmailId or password is incorrect");
    	}
    	
    	
    }
	
}
    	
    	
    	
    		
        	
        	

        
    		   	
    
    	
    
    	
    	

		
    	
    


    
    	

