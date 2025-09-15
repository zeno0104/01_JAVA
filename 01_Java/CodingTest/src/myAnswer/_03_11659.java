package myAnswer;

import java.util.Scanner;

public class _03_11659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// A: 5 4 3 2 1
		// S: 0 5 9 12 14 15
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] sArr = new int[n + 1];
		sArr[0] = 0;

		for (int i = 0; i < n; i++) {
			sArr[i + 1] = arr[i] + sArr[i];
		}

		for (int k = 0; k < m; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();

			System.out.println(sArr[j] - sArr[i - 1]);
		}

	}
}
