package com.jesseoj98.tictactoe.util.helper.retriever;

import java.util.ArrayList;
import java.util.List;

import com.jesseoj98.tictactoe.domain.Coordinate;

/**
 * Results retriever class defines implementations for retrieving game results
 */
public class ResultsRetriever {

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

}
