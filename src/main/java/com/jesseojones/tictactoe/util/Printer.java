package com.jesseojones.tictactoe.util;

public class Printer {

	private static final int GAME_BOARD_DIMENSIONS = 3;

	private static final int GAME_BOARD_SPACES = 9;

	private static Helper helper = new Helper();

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

	private boolean endOfSimpleRowMatch(int index) {
		return index == 2 || index == 5 || index == 8;
	}

	private boolean endOfRowMatch(int index) {
		return index != GAME_BOARD_DIMENSIONS - 1;
	}

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

}