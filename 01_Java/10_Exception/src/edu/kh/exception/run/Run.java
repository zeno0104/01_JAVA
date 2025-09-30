package edu.kh.exception.run;

import edu.kh.exception.model.service.ExceptionService;
import edu.kh.exception.model.service.UserException;

public class Run {
	public static void main(String[] args) {
		ExceptionService exceptionService = new ExceptionService();
		// new ExceptionService().ex1();
		// exceptionService.ex1();
		// exceptionService.ex2();
		// exceptionService.ex3();
		// exceptionService.ex4();
		 try {
			exceptionService.ex5();
		} catch (UserException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
