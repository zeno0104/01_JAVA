package _01_Greedy;

import java.util.Scanner;

public class _02_1이_될때까지 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int answer = 0;

		while (n != 1) {
			if (n % k != 0) {
				n -= 1;
			} else {
				n /= k;

			}
			answer++;
		}
		System.out.println(answer);
	}
}
