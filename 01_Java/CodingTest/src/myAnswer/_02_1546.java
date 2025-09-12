package myAnswer;

import java.util.Scanner;

public class _02_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] numArr = new int[n];

		for (int i = 0; i < n; i++) {
			numArr[i] = sc.nextInt();
		}

		long sum = 0;
		long max = 0;

		for (int i = 0; i < n; i++) {
			if (numArr[i] > max)
				max = numArr[i];
			sum = sum + numArr[i];
		}
		System.out.println(sum * 100.0 / max / n);
	}
}
