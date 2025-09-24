package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Hero;

public class HeroService {
	public void practice() {
		Hero hero1 = new Hero("이구역짱", "전사", 200, 20, 1, 0);
		Hero hero2 = new Hero("Zi존위자드", "마법사", 100, 100, 1, 0);

		System.out.println("=============" + hero1.getNickname() + " 시점" + "=============");
		hero1.attack(100.0);
		hero1.attack(50.5);
		hero1.attack(49.5);
		hero1.dash();
		hero1.dash();
		hero1.dash();
		System.out.println(hero1.toString());

		System.out.println("=============" + hero2.getNickname() + " 시점" + "=============");
		hero2.attack(300.0);
		hero2.dash();
		hero2.attack(300.0);
		hero2.attack(300.0);
		System.out.println(hero2.toString());

	}
}
