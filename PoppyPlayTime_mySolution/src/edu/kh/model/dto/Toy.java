package edu.kh.model.dto;

import java.util.Map;

public class Toy {
	private String name;
	private int age;
	private int price;
	private String color;
	private int year;
	private Map<Integer, String> ingredient;
	
	
	public Toy() {
	}


	public Toy(String name, int age, int price, String color, int year, Map<Integer, String> ingredient) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
		this.color = color;
		this.year = year;
		this.ingredient = ingredient;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public Map<Integer, String> getIngredient() {
		return ingredient;
	}


	public void setIngredient(Map<Integer, String> ingredient) {
		this.ingredient = ingredient;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("이름 : %s / 가격 : %d / 색상 : %s /"
				+ " 사용가능연령 : %d / 제조년월일 : %d / 재료 : %s", 
				name, price, color, age, year, ingredient);
	}
	
	
	
	
}
