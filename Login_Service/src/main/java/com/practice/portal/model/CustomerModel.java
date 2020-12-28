package com.practice.portal.model;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



public class CustomerModel {
	
	  private long id;
	  private String firstName;
	  private String lastName;
	  private String emailId;
	  private String country;
	  private String gender;
	  private HashMap<String,String> passwords=new HashMap<String,String>();
	  
	  
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public HashMap<String, String> getPasswords() {
		return passwords;
	}
	public void setPasswords(HashMap<String, String> passwords) {
		this.passwords = passwords;
	}
	
	  
}

