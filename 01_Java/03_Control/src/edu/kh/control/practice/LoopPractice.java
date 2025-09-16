package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);

	public void practice1() {
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if (num < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for (int i = 1; i <= num; i++) {
				System.out.print(i + " ");
			}
		}

	}

	public void practice2() {
		System.out.print("1이상의 숫자를 입력하세요 : ");

		int num = sc.nextInt();

		if (num < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for (int i = num; i > 0; i--) {
				System.out.print(i + " ");
			}
		}

	}

	public void practice3() {
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		String result = "";

		for (int i = 1; i <= num; i++) {
			if (i == num) { // 마지막 턴
				result += i;
			} else { // 마지막이 아닌 턴
				result += i + " + ";
			}
			sum += i;
		}
		System.out.print(result + " = " + sum);
	}

	public void practice4() {
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();

		if (num1 < 1 || num2 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			if (num1 > num2) {
				int temp = 0;
				temp = num1;
				num1 = num2;
				num2 = temp;
			}
			for (int i = num1; i <= num2; i++) {
				System.out.print(i + " ");
			}
		}

	}

	public void practice5() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();

		System.out.println("===== " + num + "단 =====");
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d X %d = %d\n", num, i, num * i);
		}
	}

	public void practice6() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();

		if (num > 9 || num < 2) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
		} else {
			for (int i = num; i <= 9; i++) {
				System.out.println("====== " + i + "단 ======");
				for (int j = 1; j <= 9; j++) {
					System.out.printf("%d X %d = %d\n", i, j, i * j);
				}
			}
		}
	}

	public void practice7() {
		System.out.print("자연수 하나를 입력하세요 : ");
		int num = sc.nextInt();
		int count = 0;

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0 || i % 3 == 0) {
				System.out.print(i + " ");
				if (i % 2 == 0 && i % 3 == 0) {
					count++;
				}
			}

		}
		System.out.println("\ncount : " + count);
	}
}
