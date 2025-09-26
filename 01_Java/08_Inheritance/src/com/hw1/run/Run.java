package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Student[] student = new Student[3];
		
		student[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
		student[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
		student[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");
		for(Student std : student) {
			System.out.println(std.information());
		}
		
		
		System.out.println("==============================");
		
		// 향상된 for문
				/*
				 * 자바에서 배열, 컬렉션과 같은 데이터를 순차적으로
				 * 간단하게 반복할 수 있는 구조를 제공
				 * 
				 * 일반적인 for문보다 코드가 더 간결하고 가독성이 좋아서
				 * 반복 작업을 더 쉽게 작성할 수 있다.
				 * for(자료형 변수명 : 배열 또는 컬렉션){
				 * 		// 반복해서 실행할 코드
				 * }
				 * */
		
	
		
		
		Employee[] emp = new Employee[10];
		
		
		
		while(true) {
			System.out.print("이름 : ");
			String name = sc.next();
			
			System.out.print("나이 : ");
			int age = sc.nextInt();
			
			System.out.print("신장 : ");
			double height = sc.nextDouble();
			
			System.out.print("몸무게 : ");
			double weight = sc.nextDouble();
			
			System.out.print("급여 : ");
			int salary = sc.nextInt();
			
			System.out.print("부서 : ");
			String dept = sc.next();
			
			emp[Employee.curr] = new Employee(name, age, height, weight, salary, dept);
			Employee.curr++;
			
			if(Employee.curr == 10) {
				break;
			}
			System.out.print("계속 추가하시겠습니까? (y/n): ");
			String yesOrNo = sc.next();
			
			// String.toUpperCase() " 소문자 -> 대문자
			// String.toLowerCase() " 대문자 -> 소문자
			
			// 방법 1) if(str.equals("N") || str.equals("n"))
			// 방법 2) toUpperCase() / toLowerCase() 사용
			
			
			// 방법 3) equalsIgnoreCase() : 문자열 비교 메서드,
			// 대소문자를 구분하지 않고 두 문자열이 같은지 비교
			// if(str.equalsIgnoreCase("n")) break;
			
			if(yesOrNo.equalsIgnoreCase("n")) {
				break;
			}
			
			if(yesOrNo.equalsIgnoreCase("y")) {
				System.out.println("추가가 불가능합니다.(정원초과)");
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
		
		for(Employee em : emp) {
			if(em == null) { // NullPointerException 방지
				break;
			}
			System.out.println(em.information());
		}
	}
}
