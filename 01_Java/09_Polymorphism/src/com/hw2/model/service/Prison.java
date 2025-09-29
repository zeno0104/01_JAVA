package com.hw2.model.service;

import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem{

	private Prisoner[] prisoners;
	private int prisonerCount;
	
	public Prison(int size) {
		prisoners = new Prisoner[size];
		prisonerCount = 0;
	}
	
	@Override
	public void addPerson(Person person) {
		if(prisonerCount == 10) {
			System.out.println("수감자가 모두 충원되었습니다.");
			return;
		} 
		prisoners[prisonerCount] = (Prisoner) person;
		
		System.out.println("수감자가 추가되었습니다 - " + prisoners[prisonerCount].getInfo());
		prisonerCount++;
	}

	@Override
	public void removePerson(String id) {
		for(int i = 0; i < prisoners.length; i++) {
			if(prisoners[i] == null) {
				continue;
			}
			if(prisoners[i].getId().equals(id)) {
				System.out.println("수감자가 삭제되었습니다 - " + prisoners[i].getInfo());
				prisoners[i] = null;
				
			}
		}
	}

	@Override
	public void displayAllPersons() {
		System.out.println("전체 수감자 명단 : ");
		for(int i = 0; i < prisoners.length; i++) {
			if(prisoners[i] == null) {
				continue;
			}
			System.out.println(prisoners[i].getInfo());
		}
	}
	

	public void setPrisoners(Prisoner[] prisoners) {
		this.prisoners = prisoners;
	}

	public int getPrisonerCount() {
		return prisonerCount;
	}

	public void setPrisonerCount(int prisonerCount) {
		this.prisonerCount = prisonerCount;
	}
	

}
