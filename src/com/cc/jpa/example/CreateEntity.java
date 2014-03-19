package com.cc.jpa.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;



public class CreateEntity {

	
	public static void main(String[] args) {
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
        	createEntity.getAllEmployees();
        } catch (Exception e) {
                        e.printStackTrace();
        }
	}

	public  void createDepartment(String departmentName) {
		
		try {
            
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("punit");

           
            EntityManager entityManager = emf.createEntityManager();
            EntityTransaction entityTransaction = entityManager
                    .getTransaction();
            entityTransaction.begin();
            
            Department department = new Department(departmentName);
           
            entityManager.persist(department);

            entityTransaction.commit();
            entityManager.close();
            emf.close();
        } catch (Exception e) {
            
            e.printStackTrace();
        }     
	}

	
	public Employee2 createEmployee(String firstName, String lastName,
			String email) {
		
		try {
                        EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("punit");

            
            EntityManager entityManager = emf.createEntityManager();
            EntityTransaction entityTransaction = entityManager
                    .getTransaction();
            entityTransaction.begin();
            
            Employee2 employee = new Employee2(firstName, lastName, email); 
            entityManager.persist(employee);

            entityTransaction.commit();
            entityManager.close();
            emf.close();
            
            return employee;
        } catch (Exception e) {
           
            e.printStackTrace();
        }

		return null;
	}

	
	public void addEmployeeToDept(Employee2 employee, String departmentName) {
		
		try {
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("punit");

            
            EntityManager entityManager = emf.createEntityManager();
            EntityTransaction entityTransaction = entityManager
                    .getTransaction();
            entityTransaction.begin();
            
            Query query = 
                entityManager.createNamedQuery("findDepartmentByName");
            query.setParameter("name", departmentName);
            Department department = (Department)query.getSingleResult();
            
            Query query1 = 
                entityManager.createNamedQuery("findPersonByLastName");
            query1.setParameter("LastName", employee.getLastName());
            Employee2 employee1 = (Employee2)query1.getSingleResult();

            department.getEmployees().add(employee1);
            entityManager.merge(department);

            entityTransaction.commit();
            entityManager.close();
            emf.close();
        } catch (Exception e) {
           
            e.printStackTrace();
        }       
	}
	public void getAllEmployees(){
		try {
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("punit");

            
            EntityManager entityManager = emf.createEntityManager();
            EntityTransaction entityTransaction = entityManager
                    .getTransaction();
            entityTransaction.begin();
                    Query query =
           entityManager.createQuery("From Department");
           query.setMaxResults(3);
           
            List <Department> departments =(List<Department>) query.getResultList();
            for(Department dep:departments){
            	
            	
            
                System.out.println(
                        "Department Name: " + dep.getName()
                        + ", Department ID: " + dep.getDept_id()
                         
                       
                      );
                for (Employee2 emp:dep.getEmployees()){
                	
                	System.out.println(
                            "Employee Name: " + emp.getFirstName()
                            + ", Employee Last Name: " + emp.getLastName()
                             
                           
                          );
                }
            }
            
          

            
            entityManager.close();
            emf.close();
        } catch (Exception e) {
            
            e.printStackTrace();
        }       
	}
}
