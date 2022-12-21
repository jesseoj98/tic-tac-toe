package com.jesseoj98.tictactoe.util;

import java.util.List;

import com.jesseoj98.tictactoe.domain.Coordinate;
import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.domain.Result;

/**
 * Printer class defines several functions to help with printing state of game
 * boards
 */
public class Printer {

	/** Instantation of helper class */
	private static final Helper helper = new Helper();

	/**
	 * Prints a simple sample coordinates game board
	 */
	public void printSimpleCoordinateSampleGameBoard() {
		System.out.println("\nSimple Game Board");
		System.out.println("\nEnter a single digit to place your move\n");
		printSimpleCoordinateGameBoardDivider();
		for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
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
		for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
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
		for (int i = 0; i < GameBoard.GAME_BOARD_DIMENSION; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < GameBoard.GAME_BOARD_DIMENSION; j++) {
				if (helper.isSpaceAlreadyOccupied(gameBoard[i][j])) {
					System.out.print("| " + gameBoard[i][j] + " ");
				} else {
					System.out.print("|" + (j + 1) + "," + (i + 1));
				}
			}
			System.out.println("| " + (i + 1));
			if (i != GameBoard.GAME_BOARD_DIMENSION - 1) {
				printCoordinatesGameBoardDivider();
			}
		}
		printBottomOfCoordinatesGameBoard();
	}

	/**
	 * Prints a sample coordinates game board
	 */
	public void printCoordinatesSampleGameBoard() {
		System.out.println("\nCoordinates Game Board");
		System.out.println("\nEnter an x coordinate and a y coordinate to place your move\n");
		printSimpleCoordinateGameBoardDivider();
		for (int i = 0; i < GameBoard.GAME_BOARD_DIMENSION; i++) {
			for (int j = 0; j < GameBoard.GAME_BOARD_DIMENSION; j++) {
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
		return index != GameBoard.GAME_BOARD_DIMENSION - 1;
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
			System.out.print("Congratulations! You won with positions ");
		} else {
			System.out.print("Too bad! Cpu won with positions ");
		}
		if (result.getWinningSimpleCoordinates() != null) {
			System.out.print(printPositions(result.getWinningSimpleCoordinates()));
		} else {
			System.out.print(printCoordinates(result.getWinningCoordinates()));
		}
	}

	/**
	 * Prints out the winning integer positions
	 * 
	 * @param positions the winning integer positions
	 * 
	 * @return the winning integer positions as a String
	 */
	private String printPositions(List<Integer> positions) {
		final StringBuilder spots = new StringBuilder();
		for (int i = 0; i < positions.size(); i++) {
			if (i != positions.size() - 1) {
				spots.append(Integer.toString(positions.get(i) + 1) + ", ");
			} else {
				spots.append(Integer.toString(positions.get(i) + 1));
			}
		}
		return spots.toString();

	}

	/**
	 * Prints out the winning coordinate positions
	 * 
	 * @param coordinates the winning coordinate positions
	 * 
	 * @return the winning coordinate positions as a String
	 */
	private String printCoordinates(List<Coordinate> coordinates) {
		final StringBuilder spots = new StringBuilder();
		for (int i = 0; i < coordinates.size(); i++) {
			if (i != coordinates.size() - 1) {
				spots.append(
						"[" + (coordinates.get(i).getX() + 1) + ", " + (coordinates.get(i).getY() + 1) + "]" + ", ");
			} else {
				spots.append("[" + (coordinates.get(i).getX() + 1) + ", " + (coordinates.get(i).getY() + 1) + "]");
			}
		}
		return spots.toString();
	}

}
