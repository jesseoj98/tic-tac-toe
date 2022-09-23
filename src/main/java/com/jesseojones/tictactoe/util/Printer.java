package com.jesseojones.tictactoe.util;

public class Printer {

	private static final int BOARD_SPACE_DIMENSION = 9;
	private static final int GAME_BOARD_DIMENSION = 3;

	public void printSimpleCoordinateSampleGameBoard(char[] gameBoard) {
		printCoordinatesGameBoardDivider();
		for (int i = 0; i < BOARD_SPACE_DIMENSION; i++) {
			if (i == 2 || i == 5 || i == 8) {
				System.out.print(" " + printGameBoardSpace(gameBoard[i]) + " |");
			} else {
				System.out.println(" " + printGameBoardSpace(gameBoard[i]));
			}
		}
		printCoordinatesGameBoardDivider();
	}

	public void printCoordinatesGameBoard(char[][] gameBoard) {
		printTopOfCoordinatesGameBoard();
		for (int i = 0; i < GAME_BOARD_DIMENSION; i++) {
			printGameBoardRow(gameBoard, i);
			if (endOfRowMatch(i)) {
				printCoordinatesGameBoardDivider();
			}
		}
		printBottomOfCoordinatesGameBoard();
	}

	private void printGameBoardRow(char[][] gameBoard, int rowNumber) {
		System.out.print((rowNumber + 1) + " |");
		for (int i = 0; i < GAME_BOARD_DIMENSION; i++) {
			if (endOfRowMatch(i)) {
				System.out.print(" " + printGameBoardSpace(gameBoard[rowNumber][i]) + " |");
			} else {
				System.out.println(" " + printGameBoardSpace(gameBoard[rowNumber][i]));
			}
		}
		System.out.println(" | " + (rowNumber + 1));
	}

	public void printCoordinatesSampleGameBoard() {
		printSimpleCoordinateGameBoardDivider();
		printSimpleCoordinateGameBoardDivider();
	}

	private void printTopOfCoordinatesGameBoard() {
		System.out.println("    1   2   3");
		printCoordinatesGameBoardDivider();
	}

	private void printSimpleCoordinateGameBoardDivider() {
		System.out.println("|---|---|---|");
	}

	private void printCoordinatesGameBoardDivider() {
		System.out.println("  |---|---|---|");
	}

	private void printBottomOfCoordinatesGameBoard() {
		printCoordinatesGameBoardDivider();
		System.out.println("    1   2   3");
	}

	private boolean endOfRowMatch(int index) {
		return index != GAME_BOARD_DIMENSION - 1;
	}

	private char printGameBoardSpace(char gameBoardSpace) {
		return gameBoardSpace != ' ' ? gameBoardSpace : ' ';
	}

}
