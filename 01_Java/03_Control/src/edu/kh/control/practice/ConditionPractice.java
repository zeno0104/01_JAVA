package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {
	Scanner sc = new Scanner(System.in);

	public void practice1() {

		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();

		if (num < 0)
			System.out.println("양수만 입력해주세요.");
		else if (num % 2 == 0)
			System.out.println("짝수입니다.");
		else
			System.out.println("홀수입니다.");
	}

	public void practice2() {

		System.out.print("국어 점수 : ");
		int kor = sc.nextInt();

		System.out.print("수학 점수 : ");
		int math = sc.nextInt();

		System.out.print("영어 점수 : ");
		int eng = sc.nextInt();

		int total = kor + math + eng;
		double avg = total / 3.0;

		if (kor >= 40 && math >= 40 && eng >= 40) {
			if (avg >= 60) {
				System.out.println("국어 : " + kor);
				System.out.println("수학 : " + math);
				System.out.println("영어 : " + eng);
				System.out.println("합계 : " + total);
				System.out.println("평균 : " + avg);
				System.out.println("축하합니다, 합격입니다!");
			} else
				System.out.println("불합격입니다.");
		} else
			System.out.println("불합격입니다.");
	}

	public void practice3() {
		// 1월: 31일
		// 2월: 28일
		// 3월: 31일
		// 4월: 30일
		// 5월: 31일
		// 6월: 30일
		// 7월: 31일
		// 8월: 31일
		// 9월: 30일
		// 10월: 31일
		// 11월: 30일
		// 12월: 31일
		System.out.println("1~12 사이의 정수 입력 : ");
		int num = sc.nextInt();

		switch (num) {
		case 1:
			System.out.println(num + "월은 31일까지 있습니다.");
			break;
		case 2:
			System.out.println(num + "월은 28일까지 있습니다.");
			break;
		case 3:
			System.out.println(num + "월은 31일까지 있습니다.");
			break;
		case 4:
			System.out.println(num + "월은 30일까지 있습니다.");
			break;
		case 5:
			System.out.println(num + "월은 31일까지 있습니다.");
			break;
		case 6:
			System.out.println(num + "월은 30일까지 있습니다.");
			break;
		case 7:
			System.out.println(num + "월은 31일까지 있습니다.");
			break;
		case 8:
			System.out.println(num + "월은 31일까지 있습니다.");
			break;
		case 9:
			System.out.println(num + "월은 30일까지 있습니다.");
			break;
		case 10:
			System.out.println(num + "월은 31일까지 있습니다.");
			break;
		case 11:
			System.out.println(num + "월은 30일까지 있습니다.");
			break;
		case 12:
			System.out.println(num + "월은 31일까지 있습니다.");
			break;
		default:
			System.out.println(num + "월은 잘못 입력된 달입니다.");
		}

	}

	public void practice4() {
		System.out.println("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();

		System.out.println("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();

		String result;
		double bmi = weight / (height * height);

		if (bmi < 18.5)
			result = "저체중";
		else if (bmi >= 18.5 && bmi < 23)
			result = "정상체중";
		else if (bmi >= 23 && bmi < 25)
			result = "과체중";
		else if (bmi >= 25 && bmi < 30)
			result = "비만";
		else
			result = "고도 비만";

		System.out.println("BMI 지수 : " + bmi);
		System.out.println(result);
	}

	public void practice5() {
		System.out.print("중간 고사 점수 : ");
		double midTerm = sc.nextDouble();

		System.out.print("기말 고사 점수 : ");
		double finalTerm = sc.nextDouble();

		System.out.print("과제 점수 : ");
		double exam = sc.nextDouble();

		System.out.print("출석 점수 : ");
		int check = sc.nextInt();

		double midScore = midTerm * 0.2;
		double finalScore = finalTerm * 0.3;
		double examScore = exam * 0.3;
		double checkScore = (check) * 0.2 * 5;

		double total = midScore + finalScore + examScore + checkScore;

		System.out.println("=================결과=================");

		if (total >= 70) {
			System.out.println("중간 고사 점수(20) : " + midScore);
			System.out.println("기말 고사 점수(30) : " + finalScore);
			System.out.println("과제 점수\t(30) : " + examScore);
			System.out.println("출석 점수\t(20) : " + checkScore);
			System.out.println("총점 : " + total);
			System.out.println("PASS");
		} else if (20 - (20 * 0.3) > check) {
			System.out.printf("Fail [출석 횟수 부족 (%d/%d)]", check, 20);
		} else {
			System.out.println("중간 고사 점수(20) : " + midScore);
			System.out.println("기말 고사 점수(30) : " + finalScore);
			System.out.println("과제 점수\t(30) : " + examScore);
			System.out.println("출석 점수\t(20) : " + checkScore);
			System.out.println("총점 : " + total);
			System.out.println("Fail [점수 미달]");
		}

	}
}
