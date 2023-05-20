package com.jesseoj98.tictactoe.util;

import java.util.ArrayList;
import java.util.List;

import com.jesseoj98.tictactoe.domain.Coordinate;
import com.jesseoj98.tictactoe.domain.Result;

/**
 * Validator class provides several validation methods
 */
public class Validator {

	/** Instantiation of classes */
	private static final Printer printer = new Printer();

	/**
	 * Checks whether a tic tac toe has occured
	 * 
	 * @param gameBoard        the simple game board
	 * @param playingCharacter the playing character
	 * @return whether or not a tic tac toe occurs
	 */
	public boolean ticTacToe(char[] gameBoard, char playingCharacter) {
		final String ticTacToe = new StringBuilder().append(playingCharacter).append(playingCharacter)
				.append(playingCharacter).toString();

		final String topRow = new StringBuilder().append(gameBoard[0]).append(gameBoard[1]).append(gameBoard[2])
				.toString();
		final String middleRow = new StringBuilder().append(gameBoard[3]).append(gameBoard[4]).append(gameBoard[5])
				.toString();
		final String bottomRow = new StringBuilder().append(gameBoard[6]).append(gameBoard[7]).append(gameBoard[8])
				.toString();
		final String leftColumn = new StringBuilder().append(gameBoard[0]).append(gameBoard[3]).append(gameBoard[6])
				.toString();
		final String middleColumn = new StringBuilder().append(gameBoard[1]).append(gameBoard[4]).append(gameBoard[7])
				.toString();
		final String rightColumn = new StringBuilder().append(gameBoard[2]).append(gameBoard[5]).append(gameBoard[8])
				.toString();
		final String backwardDiagonal = new StringBuilder().append(gameBoard[0]).append(gameBoard[4])
				.append(gameBoard[8]).toString();
		final String forwardDiagonal = new StringBuilder().append(gameBoard[2]).append(gameBoard[4])
				.append(gameBoard[6]).toString();

		return ticTacToe.equals(topRow) || ticTacToe.equals(middleRow) || ticTacToe.equals(bottomRow)
				|| ticTacToe.equals(leftColumn) || ticTacToe.equals(middleColumn) || ticTacToe.equals(rightColumn)
				|| ticTacToe.equals(backwardDiagonal) || ticTacToe.equals(forwardDiagonal);
	}

	/**
	 * Checks whether a tic tac toe has occured
	 * 
	 * @param gameBoard        the coordinates game board
	 * @param playingCharacter the playing character
	 * @return whether or not a tic tac toe occurs
	 */
	public boolean ticTacToe(char[][] gameBoard, char playingCharacter) {
		final String ticTacToe = new StringBuilder().append(playingCharacter).append(playingCharacter)
				.append(playingCharacter).toString();

		final String topRow = new StringBuilder().append(gameBoard[0][0]).append(gameBoard[0][1])
				.append(gameBoard[0][2]).toString();
		final String middleRow = new StringBuilder().append(gameBoard[1][0]).append(gameBoard[1][1])
				.append(gameBoard[1][2]).toString();
		final String bottomRow = new StringBuilder().append(gameBoard[2][0]).append(gameBoard[2][1])
				.append(gameBoard[2][2]).toString();
		final String leftColumn = new StringBuilder().append(gameBoard[0][0]).append(gameBoard[1][0])
				.append(gameBoard[2][0]).toString();
		final String middleColumn = new StringBuilder().append(gameBoard[0][1]).append(gameBoard[1][1])
				.append(gameBoard[2][1]).toString();
		final String rightColumn = new StringBuilder().append(gameBoard[0][2]).append(gameBoard[1][2])
				.append(gameBoard[2][2]).toString();
		final String backwardDiagonal = new StringBuilder().append(gameBoard[0][0]).append(gameBoard[1][1])
				.append(gameBoard[2][2]).toString();
		final String forwardDiagonal = new StringBuilder().append(gameBoard[2][0]).append(gameBoard[1][1])
				.append(gameBoard[0][2]).toString();

		return ticTacToe.equals(topRow) || ticTacToe.equals(middleRow) || ticTacToe.equals(bottomRow)
				|| ticTacToe.equals(leftColumn) || ticTacToe.equals(middleColumn) || ticTacToe.equals(rightColumn)
				|| ticTacToe.equals(backwardDiagonal) || ticTacToe.equals(forwardDiagonal);
	}

	/**
	 * Retrieves the winning simple positions of a tic-tac-toe
	 * 
	 * @param gameBoard        the simple game board
	 * @param playingCharacter the playing character
	 * 
	 * @return the list of winning simple positions
	 */
	public List<Integer> retrieveWinningPositions(char[] gameBoard, char playingCharacter) {
		final List<Integer> winningPositions = new ArrayList<>();
		final String ticTacToe = new StringBuilder().append(playingCharacter).append(playingCharacter)
				.append(playingCharacter).toString();

		final String topRow = new StringBuilder().append(gameBoard[0]).append(gameBoard[1]).append(gameBoard[2])
				.toString();
		final String middleRow = new StringBuilder().append(gameBoard[3]).append(gameBoard[4]).append(gameBoard[5])
				.toString();
		final String bottomRow = new StringBuilder().append(gameBoard[6]).append(gameBoard[7]).append(gameBoard[8])
				.toString();
		final String leftColumn = new StringBuilder().append(gameBoard[0]).append(gameBoard[3]).append(gameBoard[6])
				.toString();
		final String middleColumn = new StringBuilder().append(gameBoard[1]).append(gameBoard[4]).append(gameBoard[7])
				.toString();
		final String rightColumn = new StringBuilder().append(gameBoard[2]).append(gameBoard[5]).append(gameBoard[8])
				.toString();
		final String backwardDiagonal = new StringBuilder().append(gameBoard[0]).append(gameBoard[4])
				.append(gameBoard[8]).toString();
		final String forwardDiagonal = new StringBuilder().append(gameBoard[2]).append(gameBoard[4])
				.append(gameBoard[6]).toString();

		if (ticTacToe.equals(topRow)) {
			winningPositions.add(0);
			winningPositions.add(1);
			winningPositions.add(2);
		}
		if (ticTacToe.equals(middleRow)) {
			winningPositions.add(3);
			winningPositions.add(4);
			winningPositions.add(5);
		}
		if (ticTacToe.equals(bottomRow)) {
			winningPositions.add(6);
			winningPositions.add(7);
			winningPositions.add(8);
		}
		if (ticTacToe.equals(leftColumn)) {
			winningPositions.add(0);
			winningPositions.add(3);
			winningPositions.add(6);
		}
		if (ticTacToe.equals(middleColumn)) {
			winningPositions.add(1);
			winningPositions.add(4);
			winningPositions.add(7);
		}
		if (ticTacToe.equals(rightColumn)) {
			winningPositions.add(2);
			winningPositions.add(5);
			winningPositions.add(8);
		}
		if (ticTacToe.equals(backwardDiagonal)) {
			winningPositions.add(0);
			winningPositions.add(4);
			winningPositions.add(8);
		}
		if (ticTacToe.equals(forwardDiagonal)) {
			winningPositions.add(2);
			winningPositions.add(4);
			winningPositions.add(6);
		}
		return winningPositions;
	}

	/**
	 * Checks whether a tic tac toe has occured at a position
	 * 
	 * @param gameBoard        the simple game board
	 * @param playingCharacter the playing character
	 * @param position         the position to check for tic tac toe
	 * @return whether or not a tic tac toe occurs
	 */
	public boolean ticTacToe(char[][] gameBoard, char playingCharacter, int position) {
		final String ticTacToe = new StringBuilder().append(playingCharacter).append(playingCharacter)
				.append(playingCharacter).toString();

		final String topRow = new StringBuilder().append(gameBoard[0][0]).append(gameBoard[1][0])
				.append(gameBoard[2][0]).toString();
		final String middleRow = new StringBuilder().append(gameBoard[0][1]).append(gameBoard[1][1])
				.append(gameBoard[2][1]).toString();
		final String bottomRow = new StringBuilder().append(gameBoard[0][2]).append(gameBoard[1][2])
				.append(gameBoard[2][2]).toString();
		final String leftColumn = new StringBuilder().append(gameBoard[0][0]).append(gameBoard[0][1])
				.append(gameBoard[0][2]).toString();
		final String middleColumn = new StringBuilder().append(gameBoard[1][0]).append(gameBoard[1][1])
				.append(gameBoard[1][2]).toString();
		final String rightColumn = new StringBuilder().append(gameBoard[2][0]).append(gameBoard[2][1])
				.append(gameBoard[2][2]).toString();
		final String backwardDiagonal = new StringBuilder().append(gameBoard[0][0]).append(gameBoard[1][1])
				.append(gameBoard[2][2]).toString();
		final String forwardDiagonal = new StringBuilder().append(gameBoard[2][0]).append(gameBoard[1][1])
				.append(gameBoard[0][2]).toString();

		switch (position) {
		case 0:
			return ticTacToe.equals(topRow) || ticTacToe.equals(leftColumn) || ticTacToe.equals(backwardDiagonal);
		case 1:
			return ticTacToe.equals(topRow) || ticTacToe.equals(middleColumn);
		case 2:
			return ticTacToe.equals(topRow) || ticTacToe.equals(rightColumn) || ticTacToe.equals(forwardDiagonal);
		case 3:
			return ticTacToe.equals(middleRow) || ticTacToe.equals(leftColumn);
		case 4:
			return ticTacToe.equals(middleRow) || ticTacToe.equals(middleColumn) || ticTacToe.equals(backwardDiagonal)
					|| ticTacToe.equals(forwardDiagonal);
		case 5:
			return ticTacToe.equals(middleRow) || ticTacToe.equals(rightColumn);
		case 6:
			return ticTacToe.equals(bottomRow) || ticTacToe.equals(leftColumn) || ticTacToe.equals(forwardDiagonal);
		case 7:
			return ticTacToe.equals(bottomRow) || ticTacToe.equals(middleColumn);
		case 8:
			return ticTacToe.equals(bottomRow) || ticTacToe.equals(rightColumn) || ticTacToe.equals(backwardDiagonal);
		default:
			return false;
		}
	}

	/**
	 * Retrieves the winning coordinate positions of a tic-tac-toe
	 * 
	 * @param gameBoard        the coordinates game board
	 * @param playingCharacter the playing character
	 * 
	 * @return the list of winning coordinate positions
	 */
	public List<Coordinate> retrieveWinningPositions(char[][] gameBoard, char playingCharacter) {
		final List<Coordinate> winningPositions = new ArrayList<>();
		final String ticTacToe = new StringBuilder().append(playingCharacter).append(playingCharacter)
				.append(playingCharacter).toString();

		final String topRow = new StringBuilder().append(gameBoard[0][0]).append(gameBoard[1][0])
				.append(gameBoard[2][0]).toString();
		final String middleRow = new StringBuilder().append(gameBoard[0][1]).append(gameBoard[1][1])
				.append(gameBoard[2][1]).toString();
		final String bottomRow = new StringBuilder().append(gameBoard[0][2]).append(gameBoard[1][2])
				.append(gameBoard[2][2]).toString();
		final String leftColumn = new StringBuilder().append(gameBoard[0][0]).append(gameBoard[0][1])
				.append(gameBoard[0][2]).toString();
		final String middleColumn = new StringBuilder().append(gameBoard[1][0]).append(gameBoard[1][1])
				.append(gameBoard[1][2]).toString();
		final String rightColumn = new StringBuilder().append(gameBoard[2][0]).append(gameBoard[2][1])
				.append(gameBoard[2][2]).toString();
		final String backwardDiagonal = new StringBuilder().append(gameBoard[0][0]).append(gameBoard[1][1])
				.append(gameBoard[2][2]).toString();
		final String forwardDiagonal = new StringBuilder().append(gameBoard[2][0]).append(gameBoard[1][1])
				.append(gameBoard[0][2]).toString();

		if (ticTacToe.equals(topRow)) {
			winningPositions.add(new Coordinate(0, 0));
			winningPositions.add(new Coordinate(1, 0));
			winningPositions.add(new Coordinate(2, 0));
		}
		if (ticTacToe.equals(middleRow)) {
			winningPositions.add(new Coordinate(0, 1));
			winningPositions.add(new Coordinate(1, 1));
			winningPositions.add(new Coordinate(2, 1));
		}
		if (ticTacToe.equals(bottomRow)) {
			winningPositions.add(new Coordinate(0, 2));
			winningPositions.add(new Coordinate(1, 2));
			winningPositions.add(new Coordinate(2, 2));
		}
		if (ticTacToe.equals(leftColumn)) {
			winningPositions.add(new Coordinate(0, 0));
			winningPositions.add(new Coordinate(0, 1));
			winningPositions.add(new Coordinate(0, 2));
		}
		if (ticTacToe.equals(middleColumn)) {
			winningPositions.add(new Coordinate(1, 0));
			winningPositions.add(new Coordinate(1, 1));
			winningPositions.add(new Coordinate(1, 2));
		}
		if (ticTacToe.equals(rightColumn)) {
			winningPositions.add(new Coordinate(2, 0));
			winningPositions.add(new Coordinate(2, 1));
			winningPositions.add(new Coordinate(2, 2));
		}
		if (ticTacToe.equals(backwardDiagonal)) {
			winningPositions.add(new Coordinate(0, 0));
			winningPositions.add(new Coordinate(1, 1));
			winningPositions.add(new Coordinate(2, 2));
		}
		if (ticTacToe.equals(forwardDiagonal)) {
			winningPositions.add(new Coordinate(2, 0));
			winningPositions.add(new Coordinate(1, 1));
			winningPositions.add(new Coordinate(0, 2));
		}
		return winningPositions;
	}

	/**
	 * Handles the result of the simple game board
	 * 
	 * @param playerWon            the indicator for if the player won
	 * @param cpuWon               the indicator for if the cpu won
	 * @param gameBoard            the simple game board
	 * @param userPlayingCharacter the user playing character
	 * @param cpuPlayingCharacter  the cpu playing character
	 */
	public void handleResult(boolean playerWon, boolean cpuWon, char[] gameBoard, char userPlayingCharacter,
			char cpuPlayingCharacter) {
		if (!playerWon && !cpuWon) {
			System.out.println("Tie!");
		} else {
			final Result result = new Result(playerWon, cpuWon,
					retrieveWinningPositions(gameBoard, playerWon ? userPlayingCharacter : cpuPlayingCharacter), null);
			printer.printResult(result);
			System.out.println();
		}
	}

	/**
	 * Handles the result of the coordinates game board
	 * 
	 * @param playerWon            the indicator for if the player won
	 * @param cpuWon               the indicator for if the cpu won
	 * @param gameBoard            the coordinates game board
	 * @param userPlayingCharacter the user playing character
	 * @param cpuPlayingCharacter  the cpu playing character
	 */
	public void handleResult(boolean playerWon, boolean cpuWon, char[][] gameBoard, char userPlayingCharacter,
			char cpuPlayingCharacter) {
		if (!playerWon && !cpuWon) {
			System.out.println("Tie!");
		} else {
			final Result result = new Result(playerWon, cpuWon, null,
					retrieveWinningPositions(gameBoard, playerWon ? userPlayingCharacter : cpuPlayingCharacter));
			printer.printResult(result);
			System.out.println();
		}
	}

}
