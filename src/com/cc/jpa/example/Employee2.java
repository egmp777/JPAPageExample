package com.cc.jpa.example;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;
/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@Table(name="EMPLOYEE2")
@NamedQuery (
        name="findPersonByLastName",
        query="select OBJECT(e) from Employee2 e where e.LastName = :LastName")
public class Employee2 implements Serializable {

	//@ManyToOne
	//Department department;
	@Id //@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long Id;
	@Column(name = "FIRSTNAME")
	private String FirstName;
	@Column(name = "LASTNAME")
	private String LastName;
	@Column(name = "EMAIL")
	private String email;
	private static final long serialVersionUID = 1L;
	
	
	
	public Employee2() {
		//super();
	}   
	public Employee2(String firstName2, String lastName2, String email2) {
		super();
		this.FirstName = firstName2;
		this.LastName = lastName2;
		this.email = email2;

	}
	public long getId() {
		return this.Id;
	}

	public void setId(long Id) {
		this.Id = Id;
	}   
	public String getFirstName() {
		return this.FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}   
	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
