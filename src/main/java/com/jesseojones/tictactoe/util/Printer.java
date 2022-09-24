package com.jesseojones.tictactoe.util;

public class Printer {

	private static final int BOARD_SPACE_DIMENSION = 9;
	private static final int GAME_BOARD_DIMENSION = 3;

	public void printSimpleCoordinateSampleGameBoard() {
		System.out.println("\nSample Simple Coordinate Game Board:\n");
		printSimpleCoordinateGameBoardDivider();
		for (int i = 0; i < BOARD_SPACE_DIMENSION; i++) {
			if (i == 2 || i == 5 || i == 8) {
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
		System.out.println("\nSample Coordinates Game Board:\n");
		printSimpleCoordinateGameBoardDivider();
		for (int i = 0; i < GAME_BOARD_DIMENSION; i++) {
			for (int j = 0; j < GAME_BOARD_DIMENSION; j++) {
				System.out.print("|" + (j + 1) + "," + (i + 1));
				if (j == GAME_BOARD_DIMENSION - 1) {
					System.out.println("|");
					printSimpleCoordinateGameBoardDivider();
				}
			}
		}
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
