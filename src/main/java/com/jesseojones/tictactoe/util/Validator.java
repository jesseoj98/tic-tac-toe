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
	 * Checks whether the input playing character is valid
	 * 
	 * @param input the input
	 * @return whether the input playing character is valid
	 */
	public boolean isUserInputPlayingCharacterValid(char input) {
		return input == 'x' || input == 'X' || input == 'o' || input == 'O';
	}

	/**
	 * Checks whether the input is valid
	 * 
	 * @param input the input
	 * @return whether the input is valid
	 */
	public boolean isUserInputValid(char input) {
		return input == 'y' || input == 'Y' || input == 'n' || input == 'N';
	}

	/**
	 * Checks whether the play again character is valid
	 * 
	 * @param input the input
	 * @return whether the play again character is valid
	 */
	public boolean playAgain(char input) {
		return input == 'y' || input == 'Y';
	}

	/**
	 * Checks whether the cpu go first character is valid
	 * 
	 * @param input the input
	 * @return whether the cpu go first character is valid
	 */
	public boolean letCpuGoFirst(char input) {
		return input == 'y' || input == 'Y';
	}

	/**
	 * Checks whether the input game board type is valid
	 * 
	 * @param input the input
	 * @return whether the input game board type is valid
	 */
	public boolean isUserInputGameBoardTypeValid(char input) {
		return input == 's' || input == 'S' || input == 'c' || input == 'C';
	}

	/**
	 * Checks whether the input is valid
	 * 
	 * @param input the input
	 * @return whether the input is valid
	 */
	public boolean isUserInputValid(int input) {
		return input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 6 || input == 7
				|| input == 8 || input == 9;
		// return input > 0 && input < 10;
		// return input >= 1 && input <= 9;
	}

	/**
	 * Checks whether the input coordinate is valid
	 * 
	 * @param input the input
	 * @return whether the input coordinate is valid
	 */
	public boolean isUserInputCoordinatesValid(int input) {
		return input == 1 || input == 2 || input == 3;
		// return input > 0 && input < 4;
		// return input >= 1 && input <= 3;
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
