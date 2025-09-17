package edu.kh.control.branch;

import java.util.Scanner;

public class RSPGameByMe {
	Scanner sc = new Scanner(System.in);

	public void RSPGame() {
		System.out.println("[가위 바위 보 게임~!]");
		System.out.print("몇 판? : ");

		int round = sc.nextInt();

		String player = null;
		int win = 0;
		int draw = 0;
		int lose = 0;

		for (int i = 1; i <= round; i++) {
			System.out.println(i + "번째 게임");
			System.out.print("가위/바위/보 중 하나 입력: ");

			player = sc.next();

			int random = (int) (Math.random() * 3 + 1);
			String com = null;

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

			if (player.equals(com)) {
				win++;
			} else {
				boolean win1 = player.equals("가위") && com.equals("보");
				boolean win2 = player.equals("바위") && com.equals("가위");
				boolean win3 = player.equals("보") && com.equals("바위");
				if (win1 || win2 || win3) {
					System.out.println("플레이어 승!");
					win++;
				} else {
					System.out.println("졌습니다ㅜㅜ");
					lose++;
				}
			}
			System.out.printf("현재 기록 : %d승 %d무 %d패\n\n", win, draw, lose);

		}
	}
}
