package nyo.fancy.namegenerator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import nyo.fancy.namegenerator.domain.Animal;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.ClassLoader.getSystemResourceAsStream;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class AnimalService {

	private static final String ANIMALS_LOCATION = "animals.json";

	private final ObjectMapper mapper;
	private final Map<Character, List<Animal>> animalsDictionary;

	public AnimalService() throws IOException {

		mapper = new ObjectMapper();
		animalsDictionary = new HashMap<>();

		String animalBlob = IOUtils.toString(getSystemResourceAsStream(ANIMALS_LOCATION), UTF_8);

		List<String> animalList = mapper.readValue(animalBlob, List.class);

		for(String animalName : animalList){
			Character startingLetter = animalName.charAt(0);
			if (!animalsDictionary.containsKey(startingLetter)){
				animalsDictionary.put(startingLetter, new ArrayList<>());
			}
			animalsDictionary.get(startingLetter).add(new Animal(animalName));
		}
	}

	public Animal getAnimalStartingWith(Character character) {
		Character lowerCased = Character.toLowerCase(character);

		List<Animal> allAnimalsStartingWithThatCharacter = getAllAnimalsStartingWith(lowerCased);
		return allAnimalsStartingWithThatCharacter.get(
			nextInt(0, allAnimalsStartingWithThatCharacter.size())
		);
	}

	private List<Animal> getAllAnimalsStartingWith(Character character) {
		return animalsDictionary.get(character);
	}
}
