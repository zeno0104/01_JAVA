package edu.kh.io.pack4.run;

import edu.kh.io.pack4.model.service.CharacterService;

public class Run {
	public static void main(String[] args) {
		CharacterService characterService = new CharacterService();
		// characterService.fileInput();
		characterService.fileOutput();
	}
}
