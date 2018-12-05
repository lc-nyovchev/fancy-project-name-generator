package nyo.fancy.namegenerator;

import nyo.fancy.namegenerator.service.GeneratorService;
import nyo.fancy.namegenerator.service.LetterSwitchingAdjectiveAnimalGeneratorService;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		GeneratorService generatorService = new LetterSwitchingAdjectiveAnimalGeneratorService();
		for (int i = 0; i < 100; i++) {
			System.out.println(generatorService.getProjectName('k'));
		}
	}
}
