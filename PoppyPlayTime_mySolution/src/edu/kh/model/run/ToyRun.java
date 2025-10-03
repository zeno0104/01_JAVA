package edu.kh.model.run;

import edu.kh.model.service.ToyFactory;

public class ToyRun {
	public static void main(String[] args) {
		ToyFactory toyFactory = new ToyFactory();
		
		toyFactory.displayMenu();
	}
}
