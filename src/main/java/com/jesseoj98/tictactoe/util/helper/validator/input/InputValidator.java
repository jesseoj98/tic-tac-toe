package com.jesseoj98.tictactoe.util.helper.validator.input;

/**
 * Input validator class provides implementations to validate user or cpu game
 * inputs
 */
public class InputValidator implements GameInputValidator {

	/**
	 * Checks whether the input playing character is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the input playing character is valid
	 */
	@Override
	public boolean isValidPlayingCharacter(char input) {
		return input == 'x' || input == 'X' || input == 'o' || input == 'O';
	}

	/**
	 * Checks whether the input is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the input is valid
	 */
	@Override
	public boolean isYesOrNo(char input) {
		return input == 'y' || input == 'Y' || input == 'n' || input == 'N';
	}

	/**
	 * Checks whether the play again character is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the play again character is valid
	 */
	@Override
	public boolean isYes(char input) {
		return input == 'y' || input == 'Y';
	}

	/**
	 * Checks whether the input game board type is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the input game board type is valid
	 */
	@Override
	public boolean isValidBoardType(char input) {
		return input == 's' || input == 'S' || input == 'c' || input == 'C';
	}

	/**
	 * Checks whether the input is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the input is valid
	 */
	@Override
	public boolean isValidBoardSpace(int input) {
		return input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 6 || input == 7
				|| input == 8 || input == 9;
	}

	/**
	 * Checks whether the input coordinate is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the input coordinate is valid
	 */
	@Override
	public boolean isValidCoordinatesSpace(int input) {
		return input == 1 || input == 2 || input == 3;
	}

}
