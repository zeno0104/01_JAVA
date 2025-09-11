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
