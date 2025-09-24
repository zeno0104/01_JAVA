package edu.kh.oop.method.run;

import edu.kh.oop.method.model.service.MemberService;
import edu.kh.oop.method.model.service.MethodExample;
import edu.kh.oop.method.model.vo.Member;

public class MethodRun {
	public static void main(String[] args) {
		MethodExample ex = new MethodExample();

//		method.method1();

		// |
		// |method2()
		// |method1()
		// | main()
		// ----------
		// stack 구조 호출 순서

		MemberService memberService = new MemberService();
		// new MemberService(); -> 기본 생성자 부르기
		// 기본생성자를 생성해주지 않는다면, 컴파일러가 자동으로 만들어줌
//		memberService.displayMenu();

		Member member = new Member("user01", "pass01", "홍길동", 20);
		System.out.println(member);
		// member.toString()을 자동으로 호출함
		// 객체를 출력하고 싶을 때, 특정 문자열로 출력하려면
		// toString을 오버라이딩을 해주면 된다.

	}

}
