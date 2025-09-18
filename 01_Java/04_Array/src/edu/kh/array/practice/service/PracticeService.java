package edu.kh.array.practice.service;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {
	Scanner sc = new Scanner(System.in);

	public void practice1() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (i % 2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println("\n짝수 번째 인덱스 합 : " + sum);

	}

	public void practice2() {
		int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (i % 2 == 1) {
				sum += arr[i];
			}
		}
		System.out.println("\n홀수 번째 인덱스 합 : " + sum);
	}

	public void practice3() {
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();
		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = i + 1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public void practice4() {
		int[] arr = new int[5];
		boolean flag = false;

		for (int i = 0; i < arr.length; i++) {
			System.out.print("입력 " + i + " : ");
			int num = sc.nextInt();
			arr[i] = num;
		}

		System.out.print("검색할 값 : ");
		int target = sc.nextInt();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				System.out.println("인덱스 : " + i);
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}

	public void practice5() {
		System.out.print("문자열 : ");
		String str = sc.next();

		System.out.print("문자 : ");
		char target = sc.next().charAt(0);

		char[] ch = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);
		}
		int count = 0;
		String result = "";

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == target) {
				result += i + " ";
				count++;
			}
		}
		System.out.println("application에 i가 존재하는 위치(인덱스) : " + result);
		System.out.println(target + "  개수 : " + count);

	}

	public void practice6() {
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		int sum = 0;
		String result = "";
		for (int i = 0; i < num; i++) {
			System.out.print("배열 " + i + " 번째 인덱스에 넣을 값 : ");
			int input = sc.nextInt();
			arr[i] = input;
			sum += input;
			result += input + " ";
		}

		System.out.println(result);
		System.out.println("총 합 : " + sum);
	}

	public void practice7() {
		System.out.print("주민등록번호(-포함) : ");
		String info = sc.next();
		String result = "";
		for (int i = 0; i < info.length(); i++) {
			if (i >= 8) {
				result += "*";
			} else {
				result += info.charAt(i);
			}
		}
		System.out.println(result);

	}

	public void practice8() {
		boolean flag = false;
		int num = 0;
		while (!flag) {
			System.out.print("정수 : ");
			num = sc.nextInt();

			if (num % 2 == 0 || num < 3) {
				System.out.println("다시 입력하세요.");
				continue;
			} else {
				break;
			}
		}
		int[] arr = new int[num];

		String result = "";

		int curr = 1;

		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				result += curr--;
			} else if (num / 2 <= i) {
				result += curr-- + ", ";
			} else {
				result += curr++ + ", ";
			}

		}
		System.out.println(result);
	}

	public void practice9() {
		int[] arr = new int[10];
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);
			result += arr[i] + " ";
		}
		System.out.println("발생한 난수 : " + result);
	}

	public void practice10() {
		int[] arr = new int[10];
		int min = 10;
		int max = 1;
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);

			result += arr[i] + " ";

			if (min > arr[i]) {
				min = arr[i];
			}
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("발생한 난수 : " + result);
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);

	}

	public void practice11() {
		int[] arr = new int[10];
		String result = "";

		for (int i = 0; i < arr.length; i++) {
			int randomValue = (int) (Math.random() * 10 + 1);
			arr[i] = randomValue;

			for (int j = 0; j < i; j++) {
				if (arr[j] == randomValue) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			result += arr[i] + " ";
		}
		System.out.println(result);
	}

	public void practice12() {
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			int randomValue = (int) (Math.random() * 45 + 1);
			lotto[i] = randomValue;

			for (int j = 0; j < i; j++) {
				if (lotto[j] == randomValue) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(lotto);
		String result = "";
		for (int i = 0; i < lotto.length; i++) {
			result += lotto[i] + " ";
		}
		System.out.println(result);
	}

	public void practice13() {
		String result = "";

		int count = 0;
		System.out.print("문자열 : ");
		String str = sc.next();

		char[] ch = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);
		}

//		for (int i = 0; i < ch.length; i++) {
//			if (i != ch.length - 1) {
//				result += ch[i] + ", ";
//
//			} else {
//				result += ch[i];
//			}
//		}
		char[] filteredResult = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (filteredResult[j] == str.charAt(i)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				if (i != str.length()) {
					filteredResult[i] = str.charAt(i);
					result += str.charAt(i) + ", ";
				} else {
					result += str.charAt(i);
				}
				count++;
			}
		}

		System.out.print("문자열에 있는 문자 : " + result);
		System.out.print("\n문자 개수 : " + count);
	}

	public void practice14() {
		int curr = 1;
		String[] answer;

		String add = "";
		int num = 0;
		while (true) {
			System.out.print("배열의 크기를 입력하세요 : ");
			num = sc.nextInt();
			answer = new String[num];

			for (int i = 0; i < num; i++) {
				System.out.print(curr + "번째 문자열 : ");
				String str = sc.nextLine();
				curr++;
				add += str + ",";
//				answer[curr] = 
			}
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			String yesOrNO = sc.next();

			if (yesOrNO == "y") {
				System.out.print("더 입력하고 싶은 개수 : ");
				num = sc.nextInt();
				continue;
			} else {
				break;
			}
		}
		System.out.println(add);

	}
}
