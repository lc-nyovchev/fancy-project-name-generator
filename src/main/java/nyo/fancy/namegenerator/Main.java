package nyo.fancy.namegenerator;

import nyo.fancy.namegenerator.service.AnimalGeneratorService;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		AnimalGeneratorService generatorService = new AnimalGeneratorService();
		for (int i = 0; i < 100; i++) {
			System.out.println(generatorService.getProjectName('G'));
		}


	}
}
