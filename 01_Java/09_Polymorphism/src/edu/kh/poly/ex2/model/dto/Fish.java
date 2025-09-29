package edu.kh.poly.ex2.model.dto;

public class Fish extends Animal{
	// The type Fish must implement the inherited abstract method Animal.move()
	// 해당 에러는 오버라이딩을 하지 않았기 때문에 발생하는 것.
	// -> 반드시 구현해야만 하는 상속받은 추상메서드가 있다.
	// -> Animal이 가진 추상메서드 eat(), breath(), move()를 전부
	// 상속받은 Person이 본인에게 맞게끔 오버라이딩(재정의) 해라! (강제화)
	
	
	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fish(String type, String eatType) {
		super(type, eatType);
	}

	@Override
	public void eat() {
		System.out.println("입을 뻐끔거리며 먹는다");
	}

	@Override
	public void breath() {
		System.out.println("아가미 호흡을 한다");
	}

	@Override
	public void move() {
		System.out.println("꼬리로 헤엄치며 움직인다");
	}
	
	@Override
	public String toString() {
		return "Fish : " + super.toString();
	}

}
