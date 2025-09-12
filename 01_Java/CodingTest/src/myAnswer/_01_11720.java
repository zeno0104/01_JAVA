package myAnswer;
import java.util.Scanner;

public class _01_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String num = sc.next();
		String[] newNum = num.split("");

		int result = 0;

		for (int i = 0; i < newNum.length; i++) {
			result += Integer.parseInt(newNum[i]);
		}
		System.out.println(result);
	}
}

// 1초 -> 1억번  
// O(n) -> 100
// toCharArray() -> "54321"을 배열 각각으로 5, 4, 3, 2, 1로 나눠줌
// char를 int로 변환 -> 아스키코드로 
// 문자 "1", 1은 48 차이가 난다.
// -> 즉, '1' - 48 = 1
