package nyo.fancy.namegenerator.service;

import java.io.IOException;

public class LetterSwitchingAdjectiveAnimalGeneratorService {

    private final AnimalService animalService;
    private final AdjectiveService adjectiveService;

    public LetterSwitchingAdjectiveAnimalGeneratorService() throws IOException {
        this.animalService = new AnimalService();
        this.adjectiveService = new AdjectiveService();
    }
}
