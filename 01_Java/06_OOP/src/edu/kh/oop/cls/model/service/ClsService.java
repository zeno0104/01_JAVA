package edu.kh.oop.cls.model.service;

import edu.kh.oop.cls.model.vo.Student;
import edu.kh.oop.cls.model.vo.User;

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

	public void ex2() {
		// static 필드 확인 예제
		Student std1 = new Student();
		Student std2 = new Student();

		System.out.println(std1.schoolName);
		System.out.println(std2.schoolName);

		// schoolName에 노란줄이 뜨는 이유(경고)
		// -> 제대로 작성을 안해서

		// *** static이 붙은 변수(필드)/메서드 는
		// '클래스명.변수명'으로 사용함 ***
		System.out.println(Student.schoolName);

		// *** static의 가장 큰 특징 :
		// 객체를 만들지 않아도 클래스 이름으로
		// 값에 바로 접근 가능 ***

		// ex)
		// 1. Math.random();
		// 2. Arrays.toString();
		// static으로 만들어졌기 때문에 바로 접근 가능했던 것!

	}

	public void ex3() {
		// 생성자 확인 테스트
		// User 클래스 이용하여
		// u1 객체 생성
		User u1 = new User();
		// 기본생성자를 개발자가 직접 만들지 않았다면
		// 컴파일러가 자동으로 기본생성자 만들어줌.

		System.out.println(u1.getUserId());
		System.out.println(u1.getUserPw());
		System.out.println(u1.getUserName());
		System.out.println(u1.getUserAge());
		System.out.println(u1.getUserGender());
		// char는 null이 아니라 0이 나오는데,
		// 유니코드 0은 공백을 의미하기 때문에, 공백이 나옴

		System.out.println("------------------------");

		User u2 = new User();
		System.out.println(u2.getUserId());
		System.out.println(u2.getUserPw());
		System.out.println(u2.getUserName());
		System.out.println(u2.getUserAge());
		System.out.println(u2.getUserGender());

		// 문제점 : u1이 참조하고있는 User 객체와
		// u2가 참조하고있는 User객체의 필드값이 모두 동일함.
		// 왜? 같은 기본 생성자로 User객체를 생성하고 있기 때문에
		// 기본 생성자에 작성된 코드가 똑같이 수행됨..

		System.out.println("-------------------------------");
		// 해결방법 1 : setter를 이용해서 새로운 값 재대입
		u2.setUserId("asd1234");
		u2.setUserPw("1s2d3f");
		u2.setUserName("김영희");
		u2.setUserAge(25);
		u2.setUserGender('여');

		System.out.println(u2.getUserId());
		System.out.println(u2.getUserPw());
		System.out.println(u2.getUserName());
		System.out.println(u2.getUserAge());
		System.out.println(u2.getUserGender());

		System.out.println("-------------------------------");

		// 해결방법 2 : 매개변수 생성자를 이용해서
		// 객체가 생성될 때 부터 다른값으로 필드를 초기화

		User u3 = new User("test3", "password1234");
		System.out.println(u3.getUserId());
		System.out.println(u3.getUserPw());
		System.out.println(u3.getUserName());
		System.out.println(u3.getUserAge());
		System.out.println(u3.getUserGender());
	}

	public void ex4() {
		// 매개변수 생성자 예제
		User u1 = new User(); // 기본생성자
		User u2 = new User("user02", "pass02"); // 매개변수 2개 생성자
		User u3 = new User("user03", "pass03", "김길동", 20, '남');

		// 매개변수 5개짜리 생성자 (전부 초기화)

		System.out.printf("u1 : %s / %s / %s / %d / %c\n", u1.getUserId(), u1.getUserPw(), u1.getUserName(),
				u1.getUserAge(), u1.getUserGender());
		System.out.printf("u2 : %s / %s / %s / %d / %c\n", u2.getUserId(), u2.getUserPw(), u2.getUserName(),
				u2.getUserAge(), u2.getUserGender());
		System.out.printf("u3 : %s / %s / %s / %d / %c\n", u3.getUserId(), u3.getUserPw(), u3.getUserName(),
				u3.getUserAge(), u3.getUserGender());
	}
}
