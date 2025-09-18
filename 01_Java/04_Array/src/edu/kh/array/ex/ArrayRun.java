package edu.kh.array.ex;

public class ArrayRun {
	public static void main(String[] args) {
		ArrayExample1 arrayExample1 = new ArrayExample1();
		// new ArrayExample1 -> heap영역에 생성
//		arrayExample1.ex1();
//		arrayExample1.ex2();
//		arrayExample1.ex3();
//		arrayExample1.ex4();
//		arrayExample1.ex5();
//		arrayExample1.ex6();
//		arrayExample1.ex7();
//		arrayExample1.ex8();
		// -----------------------------
		ArrayExample2 arrayExample2 = new ArrayExample2();
//		arrayExample2.shallowCopy();
//		arrayExample2.deepCopy();
		arrayExample2.createLottoNumber();
	}
}