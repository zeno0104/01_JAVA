package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice {
	Scanner sc = new Scanner(System.in);

	public void practice1() {
		System.out.print("인원 수 : ");
		int people = sc.nextInt();

		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();

		System.out.printf("1인당 사탕 개수 : %d\n", candy / people);
		System.out.printf("남는 사탕 개수 : %d\n", candy % people);

		System.out.println("--------------------------------");
	}

	public void practice2() {

		System.out.print("이름 : ");
		String name = sc.next();

		System.out.print("학년(정수만) : ");
		int grade = sc.nextInt();

		System.out.print("반(정수만) : ");
		int classNum = sc.nextInt();

		System.out.print("번호(정수만) : ");
		int num = sc.nextInt();

		sc.nextLine(); // 입력버퍼에 남은 개행문자 제거해줌

		System.out.print("성별(남학생/여학생) : ");
		String gender = sc.nextLine();

		System.out.print("성적(소수점 아래 둘째 자리까지) : ");
		double score = sc.nextDouble();

		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다.\n", grade, classNum, num, name, gender, score);
		System.out.println("--------------------------------");

	}

	public void practice3() {

		System.out.print("국어 : ");
		int kor = sc.nextInt();

		System.out.print("영어 : ");
		int eng = sc.nextInt();

		System.out.print("수학 : ");
		int math = sc.nextInt();

		int total = kor + eng + math;
		double avg = total / 3.0;

		System.out.printf("합계 : %d\n", total);
		System.out.printf("평균 : %.1f\n", avg);

		// 각 과목이 40점 이상이고,
		// 평균 60점 이상이어야 합격
		// 그 외 불합격 출력

		boolean result = (kor >= 40 && eng >= 40 && math >= 40) && (avg >= 60);
		System.out.println(result ? "합격" : "불합격");
	}

	public void practice4() {

		System.out.print("당신의 나이는 ? : ");
		int age = sc.nextInt();

		String result = age >= 20 ? "저는 성인 입니다." : "저는 미성년 입니다.";

		System.out.println(result);
		boolean isTeenager = (age >= 13) && (age <= 19) ? true : false;
		System.out.println("청소년 입니까? " + isTeenager);

		boolean isSeniorOrChild = (age >= 65 || age <= 12) ? true : false;
		System.out.println("노인이거나 어린이 입니까? " + isSeniorOrChild);
	}

	public void practice5() {

		System.out.print("가격을 입력하세요: ");
		int price = sc.nextInt();

		System.out.print("멤버십 있으세요? ");
		boolean isMember = sc.nextBoolean();

		double discount = isMember ? ((price * 0.1)) : (price * 0.05);
		System.out.println("할인가격 : " + discount);
		System.out.println("할인을 포함한 최종금액 : " + (price - discount) + "원");
	}

	public void practice6() {

		System.out.print("출금할 금액 입력 : ");
		int amount = sc.nextInt();

		int fiftyTh = amount / 50000; // 5만원짜리 지폐 개수

		amount %= 50000; // 5만원짜리 지폐를 거르고 난 뒤 나머지 금액
//		나머지 값을 amount 변수에 재대입해야 아래 다음 지폐에서 재사용할 수 있음.

		int tenTh = amount / 10000; // 1만짜리 지폐 개수
		amount %= 10000;

		int fiveTh = amount / 5000; // 5천원짜리 지폐 갯수
		amount %= 5000;

		int oneTh = amount / 1000; // 1천원짜리 지폐 갯수

		System.out.println("50000원 : " + fiftyTh);
		System.out.println("10000원 : " + tenTh);
		System.out.println("5000원 : " + fiveTh);
		System.out.println("1000원 : " + oneTh);

//		System.out.println("50000원: " + money / 50000);
//		money = money - (money / 50000) * 50000;
//		System.out.println("10000원: " + money / 10000);
//		money = money - (money / 10000) * 10000;
//		System.out.println("5000원: " + money / 5000);
//		money = money - (money / 5000);
//		System.out.println("1000원: " + money / 1000);
	}

	public void practice7() {

		System.out.print("첫 번째 수 : ");
		int num1 = sc.nextInt();

		System.out.print("두 번째 수 : ");
		int num2 = sc.nextInt();

		String result = num1 % num2 == 0 ? "배수입니다" : "배수가 아닙니다.";
		System.out.println(result);
	}

}