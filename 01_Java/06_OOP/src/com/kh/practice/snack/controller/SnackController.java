package com.kh.practice.snack.controller;

import com.kh.practice.snack.model.vo.Snack;

public class SnackController {
	private Snack s = null;

	public SnackController() {

	}

	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		s = new Snack(kind, name, flavor, numOf, price);
		return "저장 완료되었습니다.";
	}

	public String confirmData() {
		return s.information();
	}
}
