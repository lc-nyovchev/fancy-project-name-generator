package nyo.fancy.namegenerator;

import nyo.fancy.namegenerator.service.AdjectiveAnimalGeneratorService;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		AdjectiveAnimalGeneratorService generatorService = new AdjectiveAnimalGeneratorService();
		for (int i = 0; i < 100; i++) {
			System.out.println(generatorService.getProjectName('B'));
		}
	}
}
