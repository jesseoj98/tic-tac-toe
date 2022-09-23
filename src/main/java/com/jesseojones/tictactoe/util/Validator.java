package com.jesseojones.tictactoe.util;

public class Validator {

	public boolean isUserInputPlayingCharacterValid(char userInput) {
		return userInput == 'x' || userInput == 'X' || userInput == 'o' || userInput == 'O';
	}

	public boolean isUserInputLetCpuGoFirstValid(char userInput) {
		return userInput == 'y' || userInput == 'Y' || userInput == 'n' || userInput == 'N';
	}

	public boolean isUserInputGameBoardTypeValid(char userInput) {
		return userInput == 's' || userInput == 'S' || userInput == 'c' || userInput == 'C';
	}

	public boolean isUserInputValid(int userInput) {
		return userInput == 1 || userInput == 2 || userInput == 3 || userInput == 4 || userInput == 5 || userInput == 6
				|| userInput == 7 || userInput == 8 || userInput == 9;
	}

	public boolean isUserInputCoordinatesValid(int userInput) {
		return userInput == 1 || userInput == 2 || userInput == 3;
	}

	public boolean allGameBoardSpacesFilled(char[] simpleGameBoard) {
		return false;
	}

	public boolean ticTacToe(char[] simpleGameBoard) {
		return false;
	}

	public boolean allGameBoardSpacesFilled(char[][] coordinateGameBoard) {
		return false;
	}

	public boolean ticTacToe(char[][] coordinateGameBoard) {
		return false;
	}

}
