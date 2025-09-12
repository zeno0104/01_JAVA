package edu.kh.variable.practice;

public class Practice7 {

	public static void main(String[] args) {
		int kor = 95;
		int eng = 87;
		int math = 90;
		int total = kor + eng + math;
		double avg = (total) / 3.0;
		System.out.printf("국어:%d, 영어:%d, 수학:%d\n", kor, eng, math);
		System.out.printf("총점:%d, 평균:%.2f\n", total, avg);
	}
}
