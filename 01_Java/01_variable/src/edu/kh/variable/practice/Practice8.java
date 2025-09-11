package edu.kh.variable.practice;

public class Practice8 {

	public static void main(String[] args) {
		String name = "영숙";
		int age = 28;
		double height = 165.7;

		System.out.printf("출연자 이름:%s\n", name);
		System.out.printf("나이:%d\n", age);
		System.out.printf("키:%.1f\n", height);

		double newAge = age;
		System.out.printf("나이:%.1f\n", newAge);

		int newHeight = (int) height;
		System.out.printf("키:%d\n", newHeight);

		int score1 = 87;
		int score2 = 92;

		double avg = ((double) score1 + (double) score2) / 2;

		System.out.printf("%s님의 매칭 점수 평균은 %.1f점입니다!", name, avg);

	}

}
