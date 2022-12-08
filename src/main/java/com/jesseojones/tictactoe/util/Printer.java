package com.jesseojones.tictactoe.util;

import java.util.List;

import com.jesseojones.tictactoe.domain.Coordinate;
import com.jesseojones.tictactoe.domain.Result;

/**
 * Printer class defines several functions to help with printing state of game
 * boards
 */
public class Printer {

	/** The constant for a game board dimension */
	private static final int GAME_BOARD_DIMENSIONS = 3;

	/** The constant for the number of game board spaces */
	private static final int GAME_BOARD_SPACES = 9;

	/** Instantation of helper class */
	private static Helper helper = new Helper();

	/**
	 * Prints a simple sample coordinates game board
	 */
	public void printSimpleCoordinateSampleGameBoard() {
		System.out.println("\nSimple Game Board");
		System.out.println("\nEnter a single digit to place your move\n");
		printSimpleCoordinateGameBoardDivider();
		for (int i = 0; i < GAME_BOARD_SPACES; i++) {
			if (endOfSimpleRowMatch(i)) {
				System.out.println(" " + (i + 1) + " |");
				printSimpleCoordinateGameBoardDivider();
			} else {
				if (i % 3 != 0) {
					System.out.print((i + 1) + " |");
				} else {
					System.out.print("| " + (i + 1) + " | ");
				}
			}
		}
	}

	/**
	 * Prints a simple coordinates game board
	 * 
	 * @param gameBoard the simple game board
	 */
	public void printSimpleCoordinateGameBoard(char[] gameBoard) {
		printSimpleCoordinateGameBoardDivider();
		for (int i = 0; i < GAME_BOARD_SPACES; i++) {
			if (endOfSimpleRowMatch(i)) {
				System.out.println(" " + printGameBoardSpace(gameBoard[i], i) + " |");
				printSimpleCoordinateGameBoardDivider();
			} else {
				if (i % 3 != 0) {
					System.out.print(printGameBoardSpace(gameBoard[i], i) + " |");
				} else {
					System.out.print("| " + printGameBoardSpace(gameBoard[i], i) + " | ");
				}
			}
		}
	}

	/**
	 * Prints a coordinates game board
	 * 
	 * @param gameBoard the coordinates game board
	 */
	public void printCoordinatesGameBoard(char[][] gameBoard) {
		printTopOfCoordinatesGameBoard();
		for (int i = 0; i < GAME_BOARD_DIMENSIONS; i++) {
			printGameBoardRow(gameBoard, i);
			if (endOfRowMatch(i)) {
				printCoordinatesGameBoardDivider();
			}
		}
		printBottomOfCoordinatesGameBoard();
	}

	/**
	 * Prints a game board row
	 * 
	 * @param gameBoard the coordinates game board
	 * @param rowNumber the row number
	 */
	private void printGameBoardRow(char[][] gameBoard, int rowNumber) {
		System.out.print((rowNumber + 1) + " |");
		for (int i = 0; i < GAME_BOARD_DIMENSIONS; i++) {
			if (endOfRowMatch(i)) {
				System.out.print(" " + printGameBoardSpace(gameBoard[rowNumber][i], i) + " |");
			} else {
				System.out.println(" " + printGameBoardSpace(gameBoard[rowNumber][i], i));
			}
		}
		System.out.println(" | " + (rowNumber + 1));
	}

	/**
	 * Prints a sample coordinates game board
	 */
	public void printCoordinatesSampleGameBoard() {
		System.out.println("\nCoordinates Game Board");
		System.out.println("\nEnter an x coordinate and a y coordinate to place your move\n");
		printSimpleCoordinateGameBoardDivider();
		for (int i = 0; i < GAME_BOARD_DIMENSIONS; i++) {
			for (int j = 0; j < GAME_BOARD_DIMENSIONS; j++) {
				System.out.print("|" + (j + 1) + "," + (i + 1));
				if (!endOfRowMatch(j)) {
					System.out.println("|");
					printSimpleCoordinateGameBoardDivider();
				}
			}
		}
	}

	/**
	 * Prints the top of the coordinates game board
	 */
	private void printTopOfCoordinatesGameBoard() {
		System.out.println("    1   2   3");
		printCoordinatesGameBoardDivider();
	}

	/**
	 * Prints a simple coordinate game board divider
	 */
	private void printSimpleCoordinateGameBoardDivider() {
		System.out.println("|---|---|---|");
	}

	/**
	 * Prints a coordinates game board divider
	 */
	private void printCoordinatesGameBoardDivider() {
		System.out.println("  |---|---|---|");
	}

	/**
	 * Prints the bottom of a coordinates game board
	 */
	private void printBottomOfCoordinatesGameBoard() {
		printCoordinatesGameBoardDivider();
		System.out.println("    1   2   3");
	}

	/**
	 * Determines if there is a match at the end of a simple row
	 * 
	 * @param index the index to check
	 * 
	 * @return whether there is a match at the end of a simple row
	 */
	private boolean endOfSimpleRowMatch(int index) {
		return index == 2 || index == 5 || index == 8;
	}

	/**
	 * Determines if there is a match at the end of a coordinates row
	 * 
	 * @param index the index to check
	 * 
	 * @return whether there is a match at the end of a coordinates row
	 */
	private boolean endOfRowMatch(int index) {
		return index != GAME_BOARD_DIMENSIONS - 1;
	}

	/**
	 * Prints a game board space
	 * 
	 * @param gameBoardSpace the game board space to print
	 * @param index          the index to check
	 * 
	 * @return the game board space to print
	 */
	private String printGameBoardSpace(char gameBoardSpace, int index) {
		if (!helper.isSpaceAlreadyOccupied(gameBoardSpace)) {
			switch (index) {
			case 0:
				return "1";
			case 1:
				return "2";
			case 2:
				return "3";
			case 3:
				return "4";
			case 4:
				return "5";
			case 5:
				return "6";
			case 6:
				return "7";
			case 7:
				return "8";
			case 8:
				return "9";
			default:
				return " ";
			}
		} else {
			return Character.toString(gameBoardSpace);
		}
	}

	/**
	 * Handles the result of the game by printing out the winning message
	 * 
	 * @param result the result of the game
	 */
	public void handleResult(Result result) {
		if (result.isPlayerWon()) {
			System.out.println("Congratulations! You won with positions ");
		} else {
			System.out.println("Too bad! Cpu won with positions ");
		}
		if (!result.getWinningSimpleCoordinates().isEmpty()) {
			System.out.print(printPositions(result.getWinningSimpleCoordinates()));
		} else {
			System.out.print(printCoordinates(result.getWinningCoordinates()));
		}
	}

	/**
	 * Prints out the winning integer positions
	 * 
	 * @param positions the winning integer positions
	 * @return the winning integer positions as a String
	 */
	private String printPositions(List<Integer> positions) {
		StringBuilder spots = new StringBuilder();
		int count = 0;
		for (Integer position : positions) {
			if (count == 2) {
				spots.append(spots + Integer.toString(position));
			}
			spots.append(spots + Integer.toString(position) + ", ");
			count++;
		}
		return spots.toString();
	}

	/**
	 * Prints out the winning coordinate positions
	 * 
	 * @param coordinates the winning coordinate positions
	 * @return the winning coordinate positions as a String
	 */
	private String printCoordinates(List<Coordinate> coordinates) {
		StringBuilder spots = new StringBuilder();
		int count = 0;
		for (Coordinate position : coordinates) {
			if (count == 2) {
				spots.append(spots + "[" + position.getX() + ", " + position.getY() + "]");
			}
			spots.append(spots + "[" + position.getX() + ", " + position.getY() + "]" + ", ");
			count++;
		}
		return spots.toString();
	}

}
