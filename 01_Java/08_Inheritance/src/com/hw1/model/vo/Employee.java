package com.hw1.model.vo;

public class Employee extends Person{
	private int salary;
	private String dept;
	
	public static int curr = 0;
	// static은 클래스 변수라서, 모든 인스턴스가 하나의 메모리 공간을 공유해서
	// 즉, 객체마다 따로따로 카운트가 되는 게 아니라, 클래스 전체에서 몇 개의 
	// 객체가 생성되었는지를 한눈에 알 수 있음.
	public Employee() {
		
	}

	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(age, height, weight);
		this.name = name; // 부모 Person에 작성된 필드 중 protected 접근제한자 name
		this.salary = salary;
		this.dept = dept;
	}
	
	public String information() {
		return super.information() + String.format(" / 급여 : %d / 부서 : %s", salary, dept);
	}
}
