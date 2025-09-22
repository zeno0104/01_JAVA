package edu.kh.oop.cls.model.service;

import edu.kh.oop.cls.model.vo.Student;

public class ClsService /* extends Student */ {
	// 부모로 Student 클래스를 상속받음
	// ClsService(자식) <- Student(부모)
	public void ex1() {
		// 클래스 접근 제한자 확인하기
		Student std = new Student();
		// TestVO test = new TestVO();
		// 다른 패키지라 import 불가능

		// 필드 접근제한자 확인하기
		// 상속 관계에서 직접 접근 가능 범위 테스트
		// 상속받으면 부모의 것도 마치 내것처럼 사용!
//		System.out.println(v1); // public이라 가능 -> 상속 받았기 때문
//		System.out.println(v2); // protected라 가능
		// System.out.println(v3); // (default) 다른 패키지에선 x
		// System.out.println(v4); // 해당 클래스 내부가 아닌 다른 클래스라서 안됌

		// 상속을 받지 않았다면
		System.out.println(std.v1); // public이라 직접접근 가능
//		System.out.println(std.v2); // 상속을 받지 못했고, 같은 패키지도 아님, 해당 클래스 내부도 아님
//		System.out.println(std.v3); // default인데, 같은 패키지 내에서 가능
//		System.out.println(std.v4); // private이기 때문
	}
}
