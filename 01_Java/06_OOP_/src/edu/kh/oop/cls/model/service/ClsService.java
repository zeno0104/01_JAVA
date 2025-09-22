package edu.kh.oop.cls.model.service;

import edu.kh.oop.cls.model.vo.Student;
import edu.kh.oop.cls.model.vo.TestVO;

// ClsService와 Student/TestVO는 패키지가 다름
public class ClsService {
	public void ex1() {
		// 클래스 접근제한자 확인하기
		Student dtd = new Student();

		TestVO test = new TestVO();
	}
}
