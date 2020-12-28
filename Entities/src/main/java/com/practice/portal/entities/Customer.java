package com.practice.portal.entities;

import javax.persistence.JoinColumn;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Customer",
uniqueConstraints= {
@UniqueConstraint(columnNames = {"emailid"})		
}
)
public class Customer {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id", nullable=false)
  private long id;
  @Column(name="firstname")
  private String firstName;
  
  @Column(name="lastname")
  private String lastName;
  
  @Column(name="emailid")
  private String emailId;
  
  @Column(name="country")
  private String country;
  
  @Column(name="gender")
  private String gender;
  
  @Column(name="password")
  private String password;
  
  @Column(name="confpassword")
  private String confpassword;
  
  
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(
		  name="user_roles",
		  joinColumns=@JoinColumn(name="cust_id"),
		  inverseJoinColumns=@JoinColumn(name="role_id")
		  )
  private Set<Role> roles=new HashSet<>();
  
 public Customer() {
	 
 }
 public Customer(String firstName, String lastName, String emailId, String country, String gender,
			String password, String confpassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.country = country;
		this.gender = gender;
		this.password = password;
		this.confpassword = confpassword;
	}
  

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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfpassword() {
	return confpassword;
}
public void setConfpassword(String confpassword) {
	this.confpassword = confpassword;
}

	
	
}
