package com.hw2.model.run;


import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Prisoner;
import com.hw2.model.service.Company;
import com.hw2.model.service.ManagementSystem;
import com.hw2.model.service.Prison;

public class Run {
	public static void main(String[] args) {
		ManagementSystem company = new Company(10);
		ManagementSystem prison = new Prison(10);
		
		company.addPerson(new Employee("EMP001", "유재석", "기획팀"));
		company.addPerson(new Employee("EMP002", "정형돈", "개발팀"));
		company.displayAllPersons();
		
		System.out.println("======================================");
		
		prison.addPerson(new Prisoner("1205", "정준하", "밥도둑"));
		prison.addPerson(new Prisoner("0705", "박명수", "웃음연쇄살인"));
		prison.displayAllPersons();
		System.out.println("======================================");
		
		company.removePerson("EMP001");
		prison.removePerson("1205");
		System.out.println("======================================");

		company.displayAllPersons();
		prison.displayAllPersons();
	}
}
