package com.jesseojones.tictactoe.util;

import java.util.List;

import com.jesseojones.tictactoe.domain.Coordinate;

/**
 * Validator class provides several validation methods
 */
public class Validator {

	/** The constant for a game board dimension */
	private static final int GAME_BOARD_DIMENSIONS = 3;

	/** The constant for the number of game board spaces */
	private static final int GAME_BOARD_SPACES = 9;

	/** Instantiation of classes */
	private static final Generator generator = new Generator();
	private static final Helper helper = new Helper();

	/** Declaration of variables */
	private static final List<List<Integer>> winningSimpleCoordinates = generator.generateSimpleWinningCoordinates();
	private static final List<List<Coordinate>> winningCoordinates = generator.generateWinningCoordinates();

	/**
	 * Checks whether the user input playing character is valid
	 * 
	 * @param userInput the user input
	 * @return whether the user input playing character is valid
	 */
	public boolean isUserInputPlayingCharacterValid(char userInput) {
		return userInput == 'x' || userInput == 'X' || userInput == 'o' || userInput == 'O';
	}

	/**
	 * Checks whether the user input is valid
	 * 
	 * @param userInput the user input
	 * @return whether the user input is valid
	 */
	public boolean isUserInputValid(char userInput) {
		return userInput == 'y' || userInput == 'Y' || userInput == 'n' || userInput == 'N';
	}

	/**
	 * Checks whether the play again character is valid
	 * 
	 * @param userInput the user input
	 * @return whether the play again character is valid
	 */
	public boolean playAgain(char userInput) {
		return userInput == 'y' || userInput == 'Y';
	}

	/**
	 * Checks whether the cpu go first character is valid
	 * 
	 * @param userInput the user input
	 * @return whether the cpu go first character is valid
	 */
	public boolean letCpuGoFirst(char userInput) {
		return userInput == 'y' || userInput == 'Y';
	}

	/**
	 * Checks whether the user input game board type is valid
	 * 
	 * @param userInput the user input
	 * @return whether the user input game board type is valid
	 */
	public boolean isUserInputGameBoardTypeValid(char userInput) {
		return userInput == 's' || userInput == 'S' || userInput == 'c' || userInput == 'C';
	}

	/**
	 * Checks whether the user input is valid
	 * 
	 * @param userInput the user input
	 * @return whether the user input is valid
	 */
	public boolean isUserInputValid(int userInput) {
		return userInput == 1 || userInput == 2 || userInput == 3 || userInput == 4 || userInput == 5 || userInput == 6
				|| userInput == 7 || userInput == 8 || userInput == 9;
		// return userInput > 0 && userInput < 10;
		// return userInput >= 1 && userInput <= 9;
	}

	/**
	 * Checks whether the user input coordinate is valid
	 * 
	 * @param userInput the user input
	 * @return whether the user input coordinate is valid
	 */
	public boolean isUserInputCoordinatesValid(int userInput) {
		return userInput == 1 || userInput == 2 || userInput == 3;
		// return userInput > 0 && userInput < 4;
		// return userInput >= 1 && userInput <= 3;
	}

	/**
	 * Checks whether all spaces are filled on a simple game board
	 * 
	 * @param simpleGameBoard the simple game board
	 * @return whether all spaces are filled on a simple game board
	 */
	public boolean allGameBoardSpacesFilled(char[] simpleGameBoard) {
		for (int i = 0; i < GAME_BOARD_SPACES; i++) {
			if (!helper.isSpaceAlreadyOccupied(simpleGameBoard[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks whether tic tac toe happened on a simple game board
	 * 
	 * @param positions the positions to check
	 * @return whether tic tac toe happened on a simple game board
	 */
	public boolean ticTacToeSimple(List<Integer> positions) {
		for (List<Integer> coordinate : winningSimpleCoordinates) {
			if (coordinate.containsAll(positions)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether all spaces are filled on a coordinate game board
	 * 
	 * @param coordinateGameBoard the coordinate game board
	 * @return whether all spaces are filled on a coordinate game board
	 */
	public boolean allGameBoardSpacesFilled(char[][] coordinateGameBoard) {
		for (int i = 0; i < GAME_BOARD_DIMENSIONS; i++) {
			for (int j = 0; j < GAME_BOARD_DIMENSIONS; j++) {
				if (!helper.isSpaceAlreadyOccupied(coordinateGameBoard, i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Checks whether tic tac toe happened on a coordinate game board
	 * 
	 * @param positions the positions to check
	 * @return whether tic tac toe happened on a coordinate game board
	 */
	public boolean ticTacToeCoordinate(List<Coordinate> positions) {
		for (List<Coordinate> coordinate : winningCoordinates) {
			if (coordinate.containsAll(positions)) {
				return true;
			}
		}
		return false;
	}

}
