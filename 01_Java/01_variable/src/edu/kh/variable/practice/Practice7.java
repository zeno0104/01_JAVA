package edu.kh.variable.practice;

public class Practice7 {

	public static void main(String[] args) {
		int korean = 95;
		int en = 87;
		int math = 90;
		int total = korean + en + math;
		System.out.printf("국어:%d, 영어:%d, 수학:%d\n", korean, en, math);
		System.out.printf("총점:%d, 평균:%.2f\n", total, (double) total / 3);
	}

}
