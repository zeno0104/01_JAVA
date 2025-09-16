package myAnswer;

import java.util.Scanner;

public class _04_2018_수들의_합_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int start = 0;
		int end = 0;

		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = i + 1;
		}
		int sum = 0;
		int answer = 0;

		while (true) {
			System.out.printf("start = %d, end = %d ", start, end);
			if (start == num)
				break;
			sum += arr[end];

			if (sum == num) {
				sum -= arr[start];
				start++;
				answer++;
			} else if (sum < num) {
				end++;
			} else if (sum > num) {
				sum -= arr[start];
				start++;
			}
			System.out.printf(" sum = %d, answer = %d\n ", sum, answer);

		}
		System.out.println();
		System.out.println(answer);
	}
}
