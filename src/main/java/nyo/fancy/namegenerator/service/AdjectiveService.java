package nyo.fancy.namegenerator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import nyo.fancy.namegenerator.domain.Adjective;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.ClassLoader.getSystemResourceAsStream;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class AdjectiveService {

    private static final String ADJECTIVES_LOCATION = "adjectives.json";

    private final ObjectMapper mapper;
    private final Map<Character, List<Adjective>> adjectivesDictionary;

    public AdjectiveService() throws IOException {

        mapper = new ObjectMapper();
        adjectivesDictionary = new HashMap<>();

        String adjectiveBlob = IOUtils.toString(getSystemResourceAsStream(ADJECTIVES_LOCATION), UTF_8);

        List<String> adjectiveList = mapper.readValue(adjectiveBlob, List.class);

        for (String adjectiveName : adjectiveList) {
            Character startingLetter = adjectiveName.charAt(0);
            if (!adjectivesDictionary.containsKey(startingLetter)) {
                adjectivesDictionary.put(startingLetter, new ArrayList<>());
            }
            adjectivesDictionary.get(startingLetter).add(new Adjective(adjectiveName));
        }
    }

    public Adjective getAdjectiveStartingWith(Character character) {
        Character lowerCased = Character.toLowerCase(character);

        List<Adjective> allAdjectivesStartingWithThatCharacter = getAllAdjectivesStartingWith(lowerCased);
        return allAdjectivesStartingWithThatCharacter.get(
                nextInt(0, allAdjectivesStartingWithThatCharacter.size())
        );
    }

    private List<Adjective> getAllAdjectivesStartingWith(Character character) {
        return adjectivesDictionary.get(character);
    }
}
