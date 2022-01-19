package nyo.fancy.namegenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterValidatorServiceTest {

	private CharacterValidatorService characterValidatorService;

	@BeforeEach
	public void setup() {
		characterValidatorService = new CharacterValidatorService();
	}

	@Test
	public void testIsLetter() {
		assertTrue(characterValidatorService.isLetter('a'), "a is a letter");
		assertTrue(characterValidatorService.isLetter('H'), "U is a letter");
		assertTrue(characterValidatorService.isLetter('u'), "u is a letter");
		assertTrue(characterValidatorService.isLetter('Z'), "Z is a letter");
		assertFalse(characterValidatorService.isLetter('-'), "- is not a letter");
		assertFalse(characterValidatorService.isLetter('1'), "1 is not a letter");
		assertFalse(characterValidatorService.isLetter('\''), "' is not a letter");
		assertFalse(characterValidatorService.isLetter('"'), "\" is not a letter");
		assertFalse(characterValidatorService.isLetter('$'), "$ is not a letter");
	}

	@Test
	public void testIsLetterWithNullInput() {
		assertThrows(NullPointerException.class, () -> characterValidatorService.isLetter(null));
	}

	@Test
	public void testIsNumber() {
		assertFalse(characterValidatorService.isNumber('a'), "a is not a number");
		assertFalse(characterValidatorService.isNumber('H'), "H is not a number");
		assertFalse(characterValidatorService.isNumber('u'), "u is not a number");
		assertFalse(characterValidatorService.isNumber('Z'), "Z is not a number");
		assertFalse(characterValidatorService.isNumber('-'), "- is not a number");
		assertTrue(characterValidatorService.isNumber('1'), "1 is a number");
		assertFalse(characterValidatorService.isNumber('\''), "' is not a number");
		assertFalse(characterValidatorService.isNumber('"'), "\" is not a number");
	}

	@Test
	public void testIsNumberWithNullInput() {
		assertThrows(NullPointerException.class, () -> characterValidatorService.isNumber(null));
	}
}