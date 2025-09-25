package com.hw1.run;

import com.hw1.model.vo.Employee;

public class Run {
	public static void main(String[] args) {
		// 객체 배열 생성
		Employee[] emp = new Employee[3];
		
		// 각 배열에 객체 생성 -> 기본 생성자 및 매개변수 생성자로 생성 -> 각 데이터들을 Heap에 할당
		emp[0] = new Employee();
		emp[1] = new Employee(1, "홍길동", 19, 'M', "01022223333", "서울 잠실");
		emp[2] = new Employee(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡");
		

		for(int i = 0; i < emp.length; i++) {
			System.out.println(emp[i].information());
		}
//		System.out.println(emp[0].information());
//		System.out.println(emp[1].information());
//		System.out.println(emp[2].information());
		// 위 3줄을 for문으로 대체
		
		
		System.out.println("============================================================");
		// setter를 통해서 값을 할당
		// 이때, new를 써서 하지말고 setter로 하라고 한 이유
		// 메모리 누수?
		// -> 결론적으로는 x
		// new를 사용할 때마다 Heap에 새로운 메모리를 생성하는데
		// JVM에 있는 가비지 컬렉터(GC)가 메모리를 참조하고 있지 않다고 판단하면 자동으로 정리해줌
		// 즉, 처음 객체를 생성해서 값을 할당할 땐 new를 사용
		// 이후에 값을 수정할 때는 setter를 사용
		emp[0].setEmpNo(0);
		emp[0].setEmpName("김말똥");
		emp[0].setDept("영업부");
		emp[0].setJob("팀장");
		emp[0].setAge(30);
		emp[0].setGender('M');
		emp[0].setSalary(3000000);
		emp[0].setBonusPoint(0.2);
		emp[0].setPhone("01055559999");
		emp[0].setAddress("전라도 광주");
	
		emp[1].setEmpNo(1);
		emp[1].setEmpName("홍길동");
		emp[1].setDept("기획부");
		emp[1].setJob("부장");
		emp[1].setGender('M');
		emp[1].setSalary(4000000);
		emp[1].setBonusPoint(0.3);
		
		System.out.println(emp[0].information());
		System.out.println(emp[1].information());
		System.out.println("============================================================");
		
		int sum = 0;
		
		for(int i = 0; i < emp.length; i++) {
			int salary = (int)(emp[i].getSalary() + (emp[i].getSalary() * emp[i].getBonusPoint())) * 12;
			System.out.println(emp[i].getEmpName() + "의 연봉 : " + salary);
			sum += salary;
		}
		System.out.println("============================================================");
		System.out.println("직원들의 연봉의 평균 : " + (sum / 3) + "원");
	}
}
