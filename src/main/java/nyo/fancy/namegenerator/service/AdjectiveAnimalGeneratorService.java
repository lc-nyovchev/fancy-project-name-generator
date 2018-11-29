package nyo.fancy.namegenerator.service;

import nyo.fancy.namegenerator.domain.Adjective;
import nyo.fancy.namegenerator.domain.Animal;

import java.io.IOException;

import static org.apache.commons.lang3.text.WordUtils.capitalize;

public class AdjectiveAnimalGeneratorService implements GeneratorService {

	private final AnimalService animalService;
	private final AdjectiveService adjectiveService;

	public AdjectiveAnimalGeneratorService() throws IOException {
		this.animalService = new AnimalService();
		this.adjectiveService = new AdjectiveService();
	}

	@Override
	public String getProjectName(Character character) {

		validate(character);

		Adjective adjective = getAdjectiveStartingWith(character);
		Animal animal = getAnimalStartingWith(character);

		return capitalize(adjective.getAdjective() + " " + animal.getName());
	}

	private void validate(Character character) {
		if (isInvalid(character)){
			throw new IllegalArgumentException("Character " + character + " is not a supported A-Z or a-z letter");
		}
	}

	private boolean isInvalid(Character character) {
		return false;
	}

	private Adjective getAdjectiveStartingWith(Character character) {
		return adjectiveService.getAdjectiveStartingWith(character);
	}

	private Animal getAnimalStartingWith(Character character) {
		return animalService.getAnimalStartingWith(character);
	}



}
