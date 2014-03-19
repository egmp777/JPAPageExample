package com.cc.jpa.example;

public interface CreateEntityIf {
	public abstract void createDepartment(String departmentName);
    public abstract Employee2 createEmployee(String firstName, String lastName, String email);
    public abstract void addEmployeeToDept(Employee2 employee, String departmentName);

}
