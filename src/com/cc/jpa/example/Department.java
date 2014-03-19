package com.cc.jpa.example;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;


//import javax.persistence.*;


//import org.hibernate.jpa.*;
//import static javax.persistence.AccessType.FIELD;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
/**
 * Entity implementation class for Entity: Department
 * @param <Employee2>
 *
 */
@Entity
@Table(name="DEPARTMENT")
@NamedQuery(
        name="findDepartmentByName",
        query="select OBJECT(d) from Department d where d.name = :name")

    
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id  //@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name = "DEPT_ID")
	private long dept_id;
	@Column(name = "NAME", unique=true)
	private String name;
	
	
	

	public Department() {
		super();
	}   
	public Department(String name) {
        this.name = name;
    }
	
	
	public long getDept_id() {
		return this.dept_id;
	}

	public void setDept_id(long dept_id) {
		this.dept_id = dept_id;
	}   
	public String getName() {
		return this.name;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	 @JoinTable(name = "DEPARTMENT_EMPLOYEE", joinColumns = {
		        @JoinColumn(name = "department_DEPT_ID", referencedColumnName = "DEPT_ID")
		    }, inverseJoinColumns = {
		        @JoinColumn(name = "employees_ID", referencedColumnName="ID", unique=true)})
	private List<Employee2> employees;
	
	public List<Employee2> getEmployees() {
	       return employees;
	    }
	    public void setEmployees(List<Employee2> employees) {
	        this.employees = employees;
	    }
	    	
}
