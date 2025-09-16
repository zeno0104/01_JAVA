package _01_Greedy;

import java.util.Scanner;

public class _01_거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 500, 100, 50, 10 };

		int money = sc.nextInt();
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			count += money / arr[i];
			money %= arr[i];
		}
		System.out.println(count);
	}
}
