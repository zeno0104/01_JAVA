package chap_07;

public class _10_AccessModifier {
	public static void main(String[] args) {
		// 캡슐화(Encapsulation)
		// 서로 연관된 것들끼리만 하나의 캡슐에 담는다는 의미
		// 변수, 메서드를 블랙박스에 관련된것만 넣는다라는 예시

		// 정보은닉(Information hiding)
		// 올바르지 않은 값을 직접적인 접근을 막고 객체에서 허용하는 메서드를 통해서만 접근하게 하는 방법
		// ex) private, protected

		// 접근 제어자
		// private : 해당 클래스 내에서만 접근 가능
		// public : 모든 클래스에서 접근 가능
		// default : (아무것도 적지 않았을 때) 같은 패키지 내에서만 접근 가능
		// protected : 같은 패키지 내에서, 다른 패키지인 경우 자식 클래스에서 접근 가능

		BlackBoxRefurbish b1 = new BlackBoxRefurbish();
		b1.modelName = "까망이";
		b1.setPrice(200000);
		b1.color = "블랙";

		// 할인 행사
		b1.setPrice(-5000);
		System.out.println("가격 : " + b1.getPrice() + "원");

		// 고객 문의
		System.out.println("해상도 : " + b1.resolution);

		System.out.println("--------------------");

		BlackBoxRefurbish b2 = new BlackBoxRefurbish();
		b2.setModelName("하양이");
		b2.setPrice(-5000);
		b2.setColor("화이트");

		System.out.println("가격 : " + b2.getPrice() + " 원");
		System.out.println("해상도 : " + b2.getResolution());

	}
}
