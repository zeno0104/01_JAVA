package edu.kh.model.dto;

import java.util.Objects;
import java.util.Set;

public class Toy implements Comparable<Toy> {
	private String name;
	private int age;
	private int price;
	private String color;
	private int year;
	private Set<String> ingredient;

	public Toy() {
	}

	public Toy(String name, int age, int price, String color, int year, Set<String> ingredient) {
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

	public Set<String> getIngredient() {
		return ingredient;
	}

	public void setIngredient(Set<String> ingredient) {
		this.ingredient = ingredient;
	}

	public void printIngredient(Set<String> ingredient) {
		for (int i = 0; i < ingredient.size(); i++) {
			if (i == ingredient.size() - 1) {
				System.out.print(ingredient);
			} else {
				System.out.println(ingredient + ", ");
			}
		}
	}

	@Override
	public String toString() {
		String ingredientStr = String.join(", ", ingredient); // 문자열로 합치기 -> ,로

		return String.format(". 이름 : %s / 가격 : %d / 색상 : %s /" + " 사용가능연령 : %d / " + "제조년월일 : %d / 재료 : %s", name,
				price, color, age, year, ingredientStr);
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, color, ingredient, name, price, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		return age == other.age && Objects.equals(color, other.color) && Objects.equals(ingredient, other.ingredient)
				&& Objects.equals(name, other.name) && price == other.price && year == other.year;
	}

	@Override
	public int compareTo(Toy o) {
		// TODO Auto-generated method stub
		return this.year - o.year;
	}

	public int compareTo(int index) {
		return this.age - age;
	}

}
