package com.practice.portal.entities;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.practice.portal.models.ERole;


@Entity
@Table(name="role")
public class Role {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;


@Enumerated(EnumType.STRING)
private ERole role;

@ManyToMany(mappedBy="roles")
private Set<Customer> customers=new HashSet<>();

public Set<Customer> getCustomers() {
	return customers;
}
public void setCustomers(Set<Customer> customers) {
	this.customers = customers;
}
public Role() {}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public ERole getRole() {
	return role;
}

public void setRole(ERole role) {
	this.role = role;
}





}
