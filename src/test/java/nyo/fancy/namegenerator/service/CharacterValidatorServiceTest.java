package nyo.fancy.namegenerator.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterValidatorServiceTest {

	private CharacterValidatorService characterValidatorService;

	@Before
	public void setup() {
		characterValidatorService = new CharacterValidatorService();
	}

	@Test
	public void testIsLetter() {
		assertTrue("a is a letter", characterValidatorService.isLetter('a'));
		assertTrue("U is a letter", characterValidatorService.isLetter('H'));
		assertTrue("u is a letter", characterValidatorService.isLetter('u'));
		assertTrue("Z is a letter", characterValidatorService.isLetter('Z'));
		assertFalse("- is not a letter", characterValidatorService.isLetter('-'));
		assertFalse("1 is not a letter", characterValidatorService.isLetter('1'));
		assertFalse("' is not a letter", characterValidatorService.isLetter('\''));
		assertFalse("\" is not a letter", characterValidatorService.isLetter('"'));
		assertFalse("$ is not a letter", characterValidatorService.isLetter('$'));
	}

	@Test(expected = NullPointerException.class)
	public void testIsLetterWithNullInput() {
		characterValidatorService.isLetter(null);
	}

	@Test
	public void testIsNumber() {
		assertFalse("a is not a number", characterValidatorService.isNumber('a'));
		assertFalse("H is not a number", characterValidatorService.isNumber('H'));
		assertFalse("u is not a number", characterValidatorService.isNumber('u'));
		assertFalse("Z is not a number", characterValidatorService.isNumber('Z'));
		assertFalse("- is not a number", characterValidatorService.isNumber('-'));
		assertTrue("1 is a number", characterValidatorService.isNumber('1'));
		assertFalse("' is not a number", characterValidatorService.isNumber('\''));
		assertFalse("\" is not a number", characterValidatorService.isNumber('"'));
	}

	@Test(expected = NullPointerException.class)
	public void testIsNumberWithNullInput() {
		characterValidatorService.isNumber(null);
	}
}