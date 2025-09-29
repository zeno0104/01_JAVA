package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem{
	private Employee[] employees;
	private int employeeCount;
	
	public Company(int size) {
		employees = new Employee[size];
		employeeCount = 0;
	}
	
	@Override
	public void addPerson(Person person) {
		if(person instanceof Employee &&  employeeCount == employees.length) {
			System.out.println("인원이 모두 충원되었습니다.");
			return;
		} 
		employees[employeeCount] = (Employee) person;
		
		System.out.println("직원이 추가되었습니다 - " + employees[employeeCount].getInfo());
		employeeCount++;
	}

	@Override
	public void removePerson(String id) {
		for(int i = 0; i < employees.length; i++) {
			if(employees[i] == null) {
				continue;
			}
			if(employees[i].getId().equals(id)) {
				System.out.println("직원이 삭제되었습니다 - " + employees[i].getInfo());
				employees[i] = null;
				employeeCount--;
			}
		}
	}

	@Override
	public void displayAllPersons() {
		// TODO Auto-generated method stub
		System.out.println("전체 직원 명단 : ");
		for(int i = 0; i < employees.length; i++) {
			if(employees[i] == null) {
				continue;
			}
			System.out.println(employees[i].getInfo());
		}
	}
	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	

}
