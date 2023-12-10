package com.jesseoj98.tictactoe.util.helper.validator.input;

public class InputValidator {

	public boolean isValidPlayingCharacter(char input) {
		return input == 'x' || input == 'X' || input == 'o' || input == 'O';
	}

	public boolean isYesOrNo(char input) {
		return input != 'y' && input != 'Y' && input != 'n' && input != 'N';
	}

	public boolean isYes(char input) {
		return input == 'y' || input == 'Y';
	}

	public boolean isValidBoardType(char input) {
		return input == 's' || input == 'S' || input == 'c' || input == 'C';
	}

	public boolean isValidBoardSpace(int input) {
		return input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 6 || input == 7
				|| input == 8 || input == 9;
	}

	public boolean isValidCoordinatesSpace(int input) {
		return input == 1 || input == 2 || input == 3;
	}

}
