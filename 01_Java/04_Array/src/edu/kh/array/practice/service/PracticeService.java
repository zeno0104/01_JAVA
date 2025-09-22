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
		String residentId = sc.next();
		char[] arr = new char[residentId.length()];

		for (int i = 0; i < residentId.length(); i++) {
			if (i >= 8) {
				arr[i] = '*';
			} else {
				arr[i] = residentId.charAt(i);
			}
		}

		for (char c : arr) {
			System.out.print(c);
		}

	}

	public void practice8() {
		boolean flag = false;
		int num = 0;

		while (!flag) {
			System.out.print("정수 : ");
			num = sc.nextInt();

			if (num % 2 == 0 || num < 3) {
				System.out.println("다시 입력하세요!");
			} else {
				break;
			}
		}

		int[] arr = new int[num];
		int curr = 1;

		// curr이 전위 연산자로 쓰일 때는 0부터 해야함
		for (int i = 0; i < arr.length; i++) {
			if (num / 2 <= i) {
				arr[i] = curr--;
			} else {
				arr[i] = curr++;
			}

		}

		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
	}

	public void practice9() {
		int[] arr = new int[10];
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);
		}

		for (int num : arr) {
			result += num + " ";
		}

		System.out.println("발생한 난수 : " + result);
	}

	public void practice10() {
		int[] arr = new int[10];
		int min = 10;
		int max = 1;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);
		}

		for (int num : arr) {
			if (min > num) {
				min = num;
			}
			if (max < num) {
				max = num;
			}
		}

		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println("\n최대값 : " + max);
		System.out.println("최소값 : " + min);

	}

	public void practice11() {
		int[] arr = new int[10];

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
			System.out.print(arr[i] + " ");
		}
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
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
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

		char[] filteredResult = new char[str.length()];

		int curr = 0;

		for (int i = 0; i < str.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (filteredResult[j] == str.charAt(i)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				filteredResult[curr] = str.charAt(i);
				count++;
				curr++;
			}
		}

		char[] trimmed = Arrays.copyOf(filteredResult, curr);

		for (int i = 0; i < trimmed.length; i++) {
			if (i == trimmed.length - 1) {
				result += trimmed[i];
			} else {
				result += trimmed[i] + ", ";
			}
		}

		System.out.print("문자열에 있는 문자 : " + result);
		System.out.print("\n문자 개수 : " + count);
	}

	public void practice14() {
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		// nextInt -> \n가 입력 버퍼에 남음
		// \n는 입력버퍼에서 제거하는 것은 nextLine()을 해줘야함
		sc.nextLine();

		String[] arr = new String[size];

		for (int i = 0; i < arr.length; i++) {
			System.out.print((i + 1) + "번째 문자열 : ");
			arr[i] = sc.nextLine();
		}

		while (true) {
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			String yesOrNo = sc.next();

			int newSize = 0;
			// eualsIgnoreCase() : 대소문자 구분없이 비교
			if (yesOrNo.equalsIgnoreCase("Y")) {
				System.out.print("더 입력하고 싶은 개수 : ");
				newSize = sc.nextInt();
				sc.nextLine(); // 입력버퍼에 남은 개행문자 제거
			} else if (yesOrNo.equalsIgnoreCase("N")) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			// 기존 배열 크기 + 추가 입력 갯수 만큼의 배열 만들기
			String[] newArr = new String[newSize + arr.length];
			// null이 들어감 -> jvm이 넣어줌

			for (int i = 0; i < newArr.length; i++) {
				if (i < arr.length) {
					newArr[i] = arr[i]; // 인덱스의 값이 기존 배열보다 작을 경우 깊은 복사
				} else {
					// 인덱스의 값이 기존 배열보다 클 경우 (새로운 값 입력받기)
					System.out.print((i + 1) + "번째 문자열 : ");
					newArr[i] = sc.nextLine();
				}

			}
			// 기존 배열 공간을 참조하던 변수 arr에
			// 새로운 배열 공간의 주소를 가진 newArr대입(얕은 복사)
			arr = newArr;
		}
		System.out.println(Arrays.toString(arr));
	}
}
