package nyo.fancy.namegenerator.service;

public class CharacterValidatorService {

	/**
	 * This will return true if the specified character is a letter, and false otherwise
	 *
	 * @param input
	 * @return
	 * @throws NullPointerException if input is null
	 */
	public boolean isLetter(Character input) {
		// instead of the return false, please implement the method
		boolean isletter = Character.isLetter(input);
		return isletter;
	}

	/**
	 * This will return true if the specified character is a number, and false otherwise
	 *
	 * @param input
	 * @return
	 * @throws NullPointerException if input is null
	 */
	public boolean isNumber(Character input) {
		// instead of the return false, please implement the method
		boolean isNumber = Character.isDigit(input);
		return Character.isDigit(input);
	}


}
