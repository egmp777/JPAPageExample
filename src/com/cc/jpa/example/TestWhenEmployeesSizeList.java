package com.cc.jpa.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWhenEmployeesSizeList {

	@Test
	public final void test() {
		 CreateEntity createEntity = 
		          new CreateEntity();
		        
		        try {
		            Employee2 employee1 = createEntity.createEmployee("Albert", "Einstein", "ae@mail.com");
		            Employee2 employee2 = createEntity.createEmployee("David", "Hilbert", "dh@mail.com");
		            Employee2 employee3 = createEntity.createEmployee("Terry", "Dactyll", "td@gmail.com");
		        	Employee2 employee4 = createEntity.createEmployee("Aby", "Bell", "ab@gmail.com");
		            Employee2 employee5 = createEntity.createEmployee("Max", "Kan", "mk@gmail.com");
		        	createEntity.createDepartment("SOFTWARE");
		            createEntity.createDepartment("ACCOUNTS");
		        	createEntity.createDepartment("MARKETING");
		        	createEntity.createDepartment("FINANCE");
		        	createEntity.createDepartment("PRODUCTION");
		        	createEntity.createDepartment("SALES");
		        	createEntity.createDepartment("HHRR");

		            createEntity.addEmployeeToDept(employee1, "SOFTWARE");
		            createEntity.addEmployeeToDept(employee2, "SOFTWARE");
		            createEntity.addEmployeeToDept(employee3, "ACCOUNTS");
		            createEntity.addEmployeeToDept(employee5, "ACCOUNTS");
		        	
		        } catch (Exception e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        
		        assertEquals(4, createEntity.getEmployeesList().size() );
			}
	

}
