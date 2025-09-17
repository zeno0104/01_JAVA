package edu.kh.control.branch;

import java.util.Scanner;

public class BranchExample {
	Scanner sc = new Scanner(System.in);

	public void ex1() {
		// 1부터 10까지 1씩 증가하며 출력하는 반복문 작성
		// 단, 5를 출력하면 반복문 종료
		// 1 2 3 4 5

		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");

			if (i == 5) {
				break;
			}
		}
	}

	public void ex2() {
		// 입력받은 모든 문자열을 누적
		// 단, "exit@" 입력시 문자열 누적을 종료하고 결과 출력

		String result = "";

		while (true) {
			System.out.print("문자열 입력(exit@) 입력 시 종료) : ");
			String input = sc.nextLine();
			// next() : 다음 한 단어 (공백 포함x)
			// nextLine() : 다음 한 줄 (공백 포함o)

			// 자바에서 문자열(String) 비교는 == 연산자 사용 불가!
			// 비교연산자(==)는 보통 기본자료형끼리의 연산에서만 사용 가능
			// String 은 기본자료형이 아닌 참조형!!!

			// equals() 메서드
			// 문자열1.equals(문자열2);
			// -> 문자열1과 문자열2가 같으면 true / 같지 않으면 false 반환

			if (input.equals("exit@")) {
				break;
			}
			result += input + "\n";
		} // while문 중괄호 닫는 것
		System.out.println("-----------------------");
		System.out.println(result);
	}

	public void ex3() {
		// continue : 다음 반복으로 넘어감

		// 1 ~ 10 까지 1씩 증가하며 출력
		// 단, 3의 배수 제외
		// 1 2 4 5 7 8 10

		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0)
				continue;
			System.out.print(i + " ");
		}
	}

	public void ex4() {
		// 1 ~ 100까지 1씩 증가하며 출력하는 반복문
		// 단, 5의 배수는 건너뛰고
		// 증가하는 값이 40이 되었을 때 반복 멈춤

		for (int i = 1; i <= 100; i++) {
			if (i == 40) {
				break;
			}
			if (i % 5 == 0) {
				continue;
			}
			// 40은 5의 배수, break를 안해주면 계속감

			System.out.println(i);
		}
	}

	public void RSPGame() {
		// 가위바위보 게임
		// [가위 바위 보 게임~!!!]
		// 몇 판할지 입력받음
		// 입력받은 판 수 만큼 반복

		// 컴퓨터 : Math.random() : 0.0 ~ 1.0 사이 난수 생성
		// 1 ~ 3 사이 난수 생성
		// 1이면 가위, 2이면 바위, 3이면 보
		// 컴퓨터와 플레이어 가위바위보 판별
		// 플레이어 승! / 졌습니다 ㅠㅠ / 비겼습니다
		// 매판마다 - 현재 기록 : 2승 1무 0패

		System.out.println("[가위 바위 보 게임~!]");
		System.out.print("몇 판? : ");

		int round = sc.nextInt();

		// 승패 기록용 변수
		int win = 0;
		int draw = 0;
		int lose = 0;

		for (int i = 1; i <= round; i++) { // 입력받은 판 수 만큼 반복
			System.out.println("\n" + i + "번째 게임");
			System.out.print("가위/바위/보 중 하나 입력 : ");
			String input = sc.next();

			int random = (int) (Math.random() * 3 + 1);
			// Math.random() : 0.0 ~ 1.0 사이
			// 0.0 <= x < 1.0
			// 0.0 <= x * 3 < 3.0
			// 1.0 <= x * 3 + 1 < 4.0
			// 1 <= (int)x * 3 + 1 < 4
			// 1이상 4 미만 정수 랜덤으로 출력 -> 1 2 3

			// switch로 random값을 문자열로 바꾸기
			String com = null;
			// null : 아무것도 참조하고 있지 않음.

			switch (random) {
			case 1:
				com = "가위";
				break;
			case 2:
				com = "바위";
				break;
			case 3:
				com = "보";
				break;
			}

			System.out.printf("컴퓨터는 [%s]를 선택했습니다.\n", com);

			// 컴퓨터와 플레이어 가위바위보 판별
			if (input.equals(com)) { // 비긴 경우
				System.out.println("비겼습니다.");
				draw++;
			} else { // 이기거나 진 경우
				boolean win1 = input.equals("가위") && com.equals("보");
				boolean win2 = input.equals("바위") && com.equals("가위");
				boolean win3 = input.equals("보") && com.equals("바위");

				if (win1 || win2 || win3) {
					System.out.println("플레이어 승!");
					win++;
				} else {
					System.out.println("졌습니다ㅜㅜ");
					lose++;
				}
			}
			System.out.printf("현재 기록 : %d승 %d무 %d패\n", win, draw, lose);
		}

	}

	public void atm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===ATM 프로그램 시작===");
		int money = 10000;
		int deposit = 0;
		int withdraw = 0;

		while (true) {
			System.out.println("메뉴를 선택하세요:");
			System.out.println("1.입금하기");
			System.out.println("2.출금하기");
			System.out.println("3.잔액조회");
			System.out.println("4.종료");
			System.out.print(">>");
			int selectNum = sc.nextInt();

			switch (selectNum) {
			case 1:
				System.out.print("\n입금할 금액을 입력하세요:");
				deposit = sc.nextInt();
				money += deposit;
				System.out.println("입금 완료! 현재 잔액:" + money + "원\n");
			case 2:
				System.out.print("\n출금할 금액을 입력하세요:");
				withdraw = sc.nextInt();

				if (money - withdraw <= 0) {
					System.out.println("잔액 부족! 현재 잔액은 " + money + "원입니다.\n");
				} else {
					money -= withdraw;
					System.out.println("출금 완료! 현재 잔액: " + money + "원\n");
				}
				break;
			case 3:
				System.out.println("\n현재 잔액은 " + money + "원입니다.\n");
				break;
			case 4:
				System.out.println("\n프로그램을 종료합니다. 이용해주셔서 감사합니다!");
				break;
			default:
				System.out.println("\n잘못된 입력입니다. 1~4번 중에서 선택하세요.\n");
			}
			if (selectNum == 4)
				break;
		}
	}

	public void dice() {
		System.out.println("===주사위 맞히기 게임 시작===");
		System.out.println("1~6 사이 숫자를 맞혀보세요. (종료를 원하면 \"종료\" 입력)\n");

		int input = 0;
		boolean flag = false;
		int count = 0;
		int win = 0;

		while (true) {
			int answer = (int) (Math.random() * 6) + 1;
			System.out.println("answer = " + answer);
			while (true) {
				System.out.print("숫자 입력 >> ");

				if (sc.hasNextInt()) {
					input = sc.nextInt();
				} else {
					String str = sc.next();
					flag = true;
					break;
				}

				if (answer > input) {
					System.out.println("틀렸습니다. 더 큰 수를 입력하세요.\n");
				} else if (answer < input) {
					System.out.println("틀렸습니다. 더 작은 수를 입력하세요.\n");
				} else {
					System.out.println("정답입니다!");
					System.out.println("새로운 주사위 숫자가 생성되었습니다.\n");
					answer = (int) Math.random() * 6 + 1;
					win++;
				}
				count++;

			}
			if (flag) {
				break;
			}

		}
		if (count == 0) {
			System.out.println("\n===게임종료===");
			System.out.println("총 시도 횟수: " + count + "번");
			System.out.println("정답 횟수: " + win + "번");
			System.out.println("게임을 플레이하지 않았습니다.");
		} else {
			System.out.println("게임을 종료합니다.\n");
			System.out.println("총 시도 횟수:" + count + "번");
			System.out.println("정답 횟수:" + win + "번");
			System.out.println("정답률:" + (win * 100) / count + "%");
		}
	}
}
