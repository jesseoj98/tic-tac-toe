package com.jesseoj98.tictactoe.util;

import java.util.List;

import com.jesseoj98.tictactoe.domain.Coordinate;
import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.domain.Result;
import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;

public class Printer {

	private static final BoardOccupier bo = new BoardOccupier();

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

	public void printCoordinatesGameBoard(char[][] gameBoard) {
		printTopOfCoordinatesGameBoard();
		for (int i = 0; i < GameBoard.GAME_BOARD_DIMENSION; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < GameBoard.GAME_BOARD_DIMENSION; j++) {
				if (bo.isSpaceOccupied(gameBoard[i][j])) {
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
		return index != GameBoard.GAME_BOARD_DIMENSION - 1;
	}

	private String printGameBoardSpace(char gameBoardSpace, int index) {
		if (!bo.isSpaceOccupied(gameBoardSpace)) {
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

	public void printResult(Result result) {
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

	private String printCoordinates(List<Coordinate> coordinates) {
		final StringBuilder spots = new StringBuilder();
		for (int i = 0; i < coordinates.size(); i++) {
			if (i != coordinates.size() - 1) {
				spots.append(
						"[" + (coordinates.get(i).getY() + 1) + ", " + (coordinates.get(i).getX() + 1) + "]" + ", ");
			} else {
				spots.append("[" + (coordinates.get(i).getY() + 1) + ", " + (coordinates.get(i).getX() + 1) + "]");
			}
		}
		return spots.toString();
	}

}
