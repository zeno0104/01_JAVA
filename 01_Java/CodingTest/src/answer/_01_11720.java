package answer;

import java.util.Scanner;

public class _01_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String number = sc.next();

		char[] numArr = number.toCharArray();
		int answer = 0;

		for (int i = 0; i < numArr.length; i++) {
			answer += numArr[i] - '0';
		}

		System.out.println(answer);
	}
}
