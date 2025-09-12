package edu.kh.variable.practice;

public class Practice6 {

	public static void main(String[] args) {
		final int PRICE = 5000;
		int count = 3;
		int total = PRICE * count;
		System.out.printf("물건 가격:%d원, 개수:%d개, 총액:%d원\n", PRICE, count, total);
	}
}
