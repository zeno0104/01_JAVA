package edu.kh.control.loop;

import java.util.Scanner;

// 기능 제공용
public class ForExample {
	Scanner sc = new Scanner(System.in);

	public void ex1() {
		// 1~10까지 콘솔에 출력하기
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}

	public void ex2() {
		// 영어 알파벳 A부터 Z까지 한줄로 출력

		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print((char) i); // 강제 형변환
		}

		System.out.println("\n=======================");

		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.print(c);

		}
	}

	public void ex3() {
		// 1부터 입력받은 수 까지 1씩 증가하며 출력
		System.out.print("번호 입력 : ");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			System.out.print(i + " ");
		}
	}

	public void ex4() {
		// 정수 5개를 입력받아서 합계 구하기
		int sum = 0; // 합계

		for (int i = 1; i <= 5; i++) {
			System.out.printf("입력 %d : ", i);
			int num = sc.nextInt();
			sum += num;
		}
		System.out.printf("합계 : %d\n", sum);
	}

	public void ex5() {
		// 1부터 20까지 1씩 증가하면서 출력
		// 단, 입력받은 수의 배수는 양쪽에 () 표시

		// [실행화면]
		// 괄호를 표시할 배수 : 3
		// 1 2 (3) 4 5 (6) 7 8 (9) ... 20
		System.out.print("괄호를 표시할 배수 : ");
		int num = sc.nextInt();

		for (int i = 1; i <= 20; i++) {
			if (i % num == 0) {
				System.out.printf("(%d) ", i);
			} else {
				System.out.print(i + " ");
			}
		}
	}

	public void ex6() {
		// 구구단 출력
		// 2 ~ 9 사이 수 를 하나 입력받아
		// 해당 단을 출력
		// 단, 입력받은 수가 2~9사이 숫자가 아니라면
		// "잘못 입력하셨습니다" 출력
		/*
		 * 단 입력 : 5 5 X 1 = 5 5 X 2 = 10 ... 5 X 9 = 45 ==================== 단 입력 : -5
		 * 잘못 입력하셨습니다.
		 */

		System.out.print("단 입력 : ");
		int num = sc.nextInt();

		if (num < 0) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d X %d = %d\n", num, i, num * i);
			}
		}

	}

	public void ex7() {
		// 숫자 세기 count

		// 1부터 20까지 1씩 증가하면서
		// 입력받은 수의 배수의 총 개수 출력
		// 입력받은 수의 배수의 합계 출력

		// 배수 입력 : 3
		// 3 6 9 12 15 18 : 6개
		// 3의 배수 합계 : 63
		int count = 0;
		int sum = 0;
		String result = "";

		System.out.print("배수 입력 : ");
		int num = sc.nextInt();

		for (int i = 1; i <= 20; i++) {
			if (i % num == 0) {
				count += 1;
				result += i + " ";
				sum += i;
			}
		}
		System.out.println(result + " : " + count + "개");
		System.out.println(num + "의 배수 합계 : " + sum);
	}

	public void ex8() {
		// 구구단 모두 출력하기

		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d X %d = %2d  ", i, j, i * j);
			}
			System.out.println();
		}
	}
}
