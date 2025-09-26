package edu.kh.inheritance.run;

import com.kh.inheritance.model.dto.BasicPhone;
import com.kh.inheritance.model.dto.SmartPhone;

public class Run {
	public static void main(String[] args) {
		
		SmartPhone smartPhone = new SmartPhone("Samsung", "Galaxy S20", 2020, 1200000, "Android", 128);
		BasicPhone basicPhone = new BasicPhone("Nokia", "3310", 2000, 100000, true);
		
		smartPhone.printInfo();
		System.out.println("==================================");
		
		basicPhone.printInfo();
		basicPhone.checkKeyboard();
	}
}
