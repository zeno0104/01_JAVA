package edu.kh.collection.pack1.run;

import edu.kh.collection.pack1.model.service.StudentService;

public class StudentRun {
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
//		studentService.ex();
		studentService.displayMenu();
	}
}
