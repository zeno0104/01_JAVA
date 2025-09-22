package edu.kh.oop.abstraction.model.service;

import edu.kh.oop.abstraction.model.vo.People;

// service : 특정 기능(비즈니스 로직)을 제공하는 패키지
// (비밀번호 암호화, 파일 검사...)
public class AbstractionService {
	// 속성
	// 기능
	public void ex1() {
		// People 클래스를 이용해서 국민 객체 만들기
		People p1 = new People();
		// People p1 : People 객체의 주소를 저장하여 참조하는 변수 p1 (== 참조변수)
		// new People() : 새로운 People 객체를 Heap 영역에 생성

		// 캡슐화
		// 1. 한군데에 비슷한 속성, 기능등을 모아둠
		// 2. 외부로부터의 직접접근 보호

		/*
		 * p1.name = "홍길동"; // private일 경우 -> The field People.name is not visible
		 * p1.gender = '남'; p1.pNo = "123456-1234567"; p1.address = "서울시 중구 남대문로 120";
		 * p1.phone = "010-1234-1234"; p1.age = 20;
		 * 
		 * p1.tax(); p1.vote();
		 * 
		 * System.out.println("p1의 name : " + p1.name);
		 * System.out.println("p1의 gender : " + p1.gender);
		 * System.out.println("p1의 pNo : " + p1.pNo);
		 * System.out.println("p1의 address : " + p1.address);
		 * System.out.println("p1의 phone : " + p1.phone);
		 * System.out.println("p1의 age : " + p1.age);
		 */
		// 값을 호출한 자리로 얻어온다 == getter
		p1.getName(); // 메소드의 호출

		// 전달한 값을 객체의 필드에 세팅한다 == setter
		p1.setName("홍길동");
		// "홍길동" : 전달인자
		p1.setGender('남');
		p1.setPno("123456-1234567");
		p1.setAddress("서울시 중구 남대문로");
		p1.setPhone("010-1234-1234");
		p1.setAge(20);

		// p1에 저장된 데이터 불러오기
		System.out.println(p1.getName());
		System.out.println(p1.getGender());
		System.out.println(p1.getPno());
		System.out.println(p1.getAddress());
		System.out.println(p1.getPhone());
		System.out.println(p1.getAge());

		// 본인 객체
		// People 클래스 이용하여 본인 이름 객체 생성하기
		// 본인의 정보 setter 값 대입
		// 본인의 정보 getter 이용하여 콘솔창 출력
		System.out.println("-----------------------");
		People myInfo = new People();

		myInfo.setName("안재훈");
		myInfo.setGender('남');
		myInfo.setPno("970104-1231233");
		myInfo.setAddress("서울시 강북구 노해로 23길 133");
		myInfo.setPhone("010-2071-2715");
		myInfo.setAge(28);

		System.out.println(myInfo.getName());
		System.out.println(myInfo.getGender());
		System.out.println(myInfo.getPno());
		System.out.println(myInfo.getAddress());
		System.out.println(myInfo.getPhone());
		System.out.println(myInfo.getAge());
	}
}
