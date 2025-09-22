package edu.kh.oop.abstraction.run;

import edu.kh.oop.abstraction.model.service.AbstractionService;

public class AbstractionRun {
	public static void main(String[] args) {
		// 서비스 클래스 객체 생성
		AbstractionService as = new AbstractionService();
		// new AbstractionService() : Heap 영역에 ex1으로 메모리 생성
		// AbstractionService as : Stack 영역에 주소값을 가진 형태로 메모리 생성

		as.ex1();
	}
}
