package edu.kh.collection.pack1.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.kh.collection.pack1.model.service.StudentService;

public class StudentRun {
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
//		studentService.ex();
		studentService.displayMenu();
		
		
		/*
		List<Integer> numberList = new ArrayList<>();
		
		numberList.add(5);
		numberList.add(3);
		numberList.add(1);
		numberList.add(4);
		numberList.add(2);
		// [5, 3, 1, 4, 2]
		
		// Integer는 이미 Comparable을 상속받아 compareTo() 정의함
		Collections.sort(numberList);
		System.out.println(numberList);
		*/
	}
}
