package kh.edu.model.dto;

import java.util.List;

public class Member {
	private String name;
	private int age;
	private String job;
	private String address;
	private char gender;
	private List<String> favorite;
	private boolean isVoted;

	public Member() {
	}


	public Member(String name, int age, String job, String address, char gender, List<String> favorite,
			boolean isVoted) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
		this.address = address;
		this.gender = gender;
		this.favorite = favorite;
		this.isVoted = isVoted;
	}


	public boolean getIsVoted() {
		return isVoted;
	}


	public void setIsVoted(boolean isVoted) {
		this.isVoted = isVoted;
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public List<String> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<String> favorite) {
		this.favorite = favorite;
	}

	@Override
	public String toString() {
		String strFavorite = String.join(", ", favorite);
		return String.format("%s(%d, %s, %s) | 취미: %s", name, age, job, address, strFavorite);
	}
}
