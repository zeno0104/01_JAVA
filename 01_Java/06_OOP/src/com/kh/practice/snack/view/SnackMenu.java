package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {
	Scanner sc = new Scanner(System.in);
	SnackController snackController = new SnackController();

	public void menu() {
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind = sc.next();

		System.out.print("이름 : ");
		String name = sc.next();

		System.out.print("맛 : ");
		String flavor = sc.next();

		System.out.print("개수 : ");
		int numOf = sc.nextInt();

		System.out.print("가격 : ");
		int price = sc.nextInt();

		System.out.println(snackController.saveData(kind, name, flavor, numOf, price));

		System.out.printf("저장한 정보를 확인하시겠습니다?(y/n) : ");
		String yesOrNo = "";

		while (!yesOrNo.equalsIgnoreCase("y") && !yesOrNo.equalsIgnoreCase("n")) {
			yesOrNo = sc.next();
			if (yesOrNo.equalsIgnoreCase("y")) {
				System.out.println(snackController.confirmData());
			} else if (yesOrNo.equalsIgnoreCase("n")) {
				return;
			} else {
				System.out.print("잘못 입력하셨습니다. 다시 입력하세요 : ");

			}
		}

	}
}
