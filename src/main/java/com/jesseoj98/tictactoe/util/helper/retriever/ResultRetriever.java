package com.jesseoj98.tictactoe.util.helper.retriever;

import java.util.ArrayList;
import java.util.List;

import com.jesseoj98.tictactoe.domain.Coordinate;

public class ResultRetriever {

	public List<Integer> retrieveWinningPositions(char[] gameBoard, char playingCharacter) {
		final List<Integer> winningPositions = new ArrayList<>();
		final String ticTacToe = String.valueOf(playingCharacter) + playingCharacter +
				playingCharacter;

		final String topRow = String.valueOf(gameBoard[0]) + gameBoard[1] + gameBoard[2];
		final String middleRow = String.valueOf(gameBoard[3]) + gameBoard[4] + gameBoard[5];
		final String bottomRow = String.valueOf(gameBoard[6]) + gameBoard[7] + gameBoard[8];
		final String leftColumn = String.valueOf(gameBoard[0]) + gameBoard[3] + gameBoard[6];
		final String middleColumn = String.valueOf(gameBoard[1]) + gameBoard[4] + gameBoard[7];
		final String rightColumn = String.valueOf(gameBoard[2]) + gameBoard[5] + gameBoard[8];
		final String backwardDiagonal = String.valueOf(gameBoard[0]) + gameBoard[4] +
				gameBoard[8];
		final String forwardDiagonal = String.valueOf(gameBoard[2]) + gameBoard[4] +
				gameBoard[6];

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

	public List<Coordinate> retrieveWinningPositions(char[][] gameBoard, char playingCharacter) {
		final List<Coordinate> winningPositions = new ArrayList<>();
		final String ticTacToe = String.valueOf(playingCharacter) + playingCharacter +
				playingCharacter;

		final String topRow = String.valueOf(gameBoard[0][0]) + gameBoard[1][0] +
				gameBoard[2][0];
		final String middleRow = String.valueOf(gameBoard[0][1]) + gameBoard[1][1] +
				gameBoard[2][1];
		final String bottomRow = String.valueOf(gameBoard[0][2]) + gameBoard[1][2] +
				gameBoard[2][2];
		final String leftColumn = String.valueOf(gameBoard[0][0]) + gameBoard[0][1] +
				gameBoard[0][2];
		final String middleColumn = String.valueOf(gameBoard[1][0]) + gameBoard[1][1] +
				gameBoard[1][2];
		final String rightColumn = String.valueOf(gameBoard[2][0]) + gameBoard[2][1] +
				gameBoard[2][2];
		final String backwardDiagonal = String.valueOf(gameBoard[0][0]) + gameBoard[1][1] +
				gameBoard[2][2];
		final String forwardDiagonal = String.valueOf(gameBoard[2][0]) + gameBoard[1][1] +
				gameBoard[0][2];

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
