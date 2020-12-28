package com.practice.portal.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.portal.entities.Customer;

@Repository
@Transactional
public interface CustomerRepository extends CrudRepository<Customer,Integer>{
	 @Query("select u.emailId from Customer u")
	 List<String> getAllEmail();
	 @Query("SELECT c.password from Customer c where c.emailId =:emailId AND c.password =:password")
	  Object findByemailIdAndpassword(@RequestParam("emailId") String emailId,@RequestParam("password")String password);

	

}
