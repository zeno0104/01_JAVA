package edu.kh.inheritance.model.dto;

/* 
 * Object
 * 	  ㄴ  Person
 * 			ㄴ  Student
 * 
 * */

// 자식  extends   부모
public class Student extends Person {
	// Student 클래스에 Person 클래스 내용을 확장한다/연장한다
	// == Student 클래스에 Person 클래스의 필드, 메서드를 추가하여 확장한다.

//	private String name; // 이름
//	private int age; // 나이
//	private String nationality;
	private int grade; // 학년
	private int classroom; // 반

	

//	public Student(String name, int age, String nationality, int grade, int classroom) {
//		super(name, age, nationality);
////		super(매개변수1, 매개변수2) -> 부모의 매개변수 생성자 호출
//		
//		
////		this.name = name;
////		this.age = age;
////		this.nationality = nationality;
//		// 위 3가지 변수는 없음
//		// this.는 Student, 해당 변수는 Person의 필드
//		// 그래서 에러가 발생
//		this.grade = grade;
//		this.classroom = classroom;
//		
//		// 기본생성자에서 super()를 통해서 부모 클래스의 객체를 자식 클래스 Heap메모리에 할당
//		// 그리고, super를 통해서 값을 자식 객체 클래스 메모리에 할당함.
//	}
	public Student() {
		// super(); 컴파일러가 자동으로 super()를 추가해준다.
	}
	public Student(String name, int age, String nationality, int grade, int classroom) {
		// this.name = name;
		// this.age = age;
		// this.nationality = nationality;
		// 왜 안될까?
		// -> this 참조변수는 본인 자신만을 의미함
		// 부모의 고유 필드인 name, age, nationality는 
		// this가 참조하고 있는 주소의 필드가 아니기 때문에
		// this 참조변수를 이용하여 직접 접근 불가!
		
		
		super(name, age, nationality); // 부모의 매개변수 생성자
		// super() 생성자 작성 시 생성자 메서드 내 반드시 첫 번째 줄에 작성
		/*
		 * setName(name);
		 * setAge(age);
		 * setNationality(nationality)
		 * setter 메소드를 이용하여 초기화 가능은 하나 비효율적
		 * -> 그래서 고안해낸 것이 super()
		 * */
		
		this.grade = grade;
		this.classroom = classroom;
	}

	public Student(int grade, int classroom) {
		super(); // 부모의 name, age, nationality => JVM 기본값으로만 만들겠다.
		// std,getName(null), std.getAge(0), std.getNationality(null)는 각각 JVM 기본값이 들어감
		
		// gradem classroom -> 전달받은 값으로 초기화 함
		this.grade = grade;
		this.classroom = classroom;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassroom() {
		return classroom;
	}

	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	@Override
	public String toString() {
		// super. : super 참조변수
		// -> 상속관계에서 부모객체를 가리키는 참조변수
		return super.toString() + " / " + grade + " / " + classroom ;
	}
}






















