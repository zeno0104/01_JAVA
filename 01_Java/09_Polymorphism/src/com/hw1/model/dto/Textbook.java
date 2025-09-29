package com.hw1.model.dto;

public class Textbook extends Book{
	private String subject;
	
	public Textbook() {
		
	}

	public Textbook(String title, String author, String subject) {
		super(title, author);
		this.subject = subject;
	}

	@Override
	public void displayInfo() {
		System.out.println("[전문 서적] 제목 : " + this.getTitle() + " / " + "저자 : " + 
				this.getAuthor() + " / " + "과목 : " + this.getSubject());
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}
