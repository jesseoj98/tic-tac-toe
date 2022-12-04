package com.jesseojones.tictactoe.util;

import java.util.List;

import com.jesseojones.tictactoe.domain.Coordinate;

public class Validator {

	private static final int GAME_BOARD_DIMENSIONS = 3;

	private static final int GAME_BOARD_SPACES = 9;

	private static final Generator generator = new Generator();
	private static final Helper helper = new Helper();

	private static final List<List<Integer>> winningSimpleCoordinates = generator.generateSimpleWinningCoordinates();
	private static final List<List<Coordinate>> winningCoordinates = generator.generateWinningCoordinates();

	public boolean isUserInputPlayingCharacterValid(char userInput) {
		return userInput == 'x' || userInput == 'X' || userInput == 'o' || userInput == 'O';
	}

	public boolean isUserInputValid(char userInput) {
		return userInput == 'y' || userInput == 'Y' || userInput == 'n' || userInput == 'N';
	}

	public boolean playAgain(char userInput) {
		return userInput == 'y' || userInput == 'Y';
	}

	public boolean letCpuGoFirst(char userInput) {
		return userInput == 'y' || userInput == 'Y';
	}

	public boolean isUserInputGameBoardTypeValid(char userInput) {
		return userInput == 's' || userInput == 'S' || userInput == 'c' || userInput == 'C';
	}

	public boolean isUserInputValid(int userInput) {
		return userInput == 1 || userInput == 2 || userInput == 3 || userInput == 4 || userInput == 5 || userInput == 6
				|| userInput == 7 || userInput == 8 || userInput == 9;
		// return userInput > 0 && userInput < 10;
		// return userInput >= 1 && userInput <= 9;
	}

	public boolean isUserInputCoordinatesValid(int userInput) {
		return userInput == 1 || userInput == 2 || userInput == 3;
		// return userInput > 0 && userInput < 4;
		// return userInput >= 1 && userInput <= 3;
	}

	public boolean allGameBoardSpacesFilled(char[] simpleGameBoard) {
		for (int i = 0; i < GAME_BOARD_SPACES; i++) {
			if (!helper.isSpaceAlreadyOccupied(simpleGameBoard[i])) {
				return false;
			}
		}
		return true;
	}

	public boolean ticTacToeSimple(List<Integer> positions) {
		for (List<Integer> coordinate : winningSimpleCoordinates) {
			if (coordinate.containsAll(positions)) {
				return true;
			}
		}
		return false;
	}

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

	public boolean ticTacToe(char[][] coordinateGameBoard) {
		return false;
	}

	public boolean ticTacToeCoordinate(List<Coordinate> positions) {
		for (List<Coordinate> coordinate : winningCoordinates) {
			if (coordinate.containsAll(positions)) {
				return true;
			}
		}
		return false;
	}

}
