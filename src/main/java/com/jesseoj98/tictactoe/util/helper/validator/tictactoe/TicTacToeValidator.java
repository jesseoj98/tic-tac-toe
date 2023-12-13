package com.jesseoj98.tictactoe.util.helper.validator.tictactoe;

public class TicTacToeValidator {

	public boolean ticTacToe(char[] gameBoard, char playingCharacter) {
		final String ticTacToe = String.valueOf(playingCharacter) + playingCharacter + playingCharacter;

		final String topRow = String.valueOf(gameBoard[0]) + gameBoard[1] + gameBoard[2];
		final String middleRow = String.valueOf(gameBoard[3]) + gameBoard[4] + gameBoard[5];
		final String bottomRow = String.valueOf(gameBoard[6]) + gameBoard[7] + gameBoard[8];
		final String leftColumn = String.valueOf(gameBoard[0]) + gameBoard[3] + gameBoard[6];
		final String middleColumn = String.valueOf(gameBoard[1]) + gameBoard[4] + gameBoard[7];
		final String rightColumn = String.valueOf(gameBoard[2]) + gameBoard[5] + gameBoard[8];
		final String backwardDiagonal = String.valueOf(gameBoard[0]) + gameBoard[4] + gameBoard[8];
		final String forwardDiagonal = String.valueOf(gameBoard[2]) + gameBoard[4] + gameBoard[6];

		return ticTacToe.equals(topRow) || ticTacToe.equals(middleRow) || ticTacToe.equals(bottomRow)
				|| ticTacToe.equals(leftColumn) || ticTacToe.equals(middleColumn) || ticTacToe.equals(rightColumn)
				|| ticTacToe.equals(backwardDiagonal) || ticTacToe.equals(forwardDiagonal);
	}

	public boolean ticTacToe(char[][] gameBoard, char playingCharacter) {
		final String ticTacToe = String.valueOf(playingCharacter) + playingCharacter + playingCharacter;

		final String topRow = String.valueOf(gameBoard[0][0]) + gameBoard[0][1] + gameBoard[0][2];
		final String middleRow = String.valueOf(gameBoard[1][0]) + gameBoard[1][1] + gameBoard[1][2];
		final String bottomRow = String.valueOf(gameBoard[2][0]) + gameBoard[2][1] + gameBoard[2][2];
		final String leftColumn = String.valueOf(gameBoard[0][0]) + gameBoard[1][0] + gameBoard[2][0];
		final String middleColumn = String.valueOf(gameBoard[0][1]) + gameBoard[1][1] + gameBoard[2][1];
		final String rightColumn = String.valueOf(gameBoard[0][2]) + gameBoard[1][2] + gameBoard[2][2];
		final String backwardDiagonal = String.valueOf(gameBoard[0][0]) + gameBoard[1][1] + gameBoard[2][2];
		final String forwardDiagonal = String.valueOf(gameBoard[2][0]) + gameBoard[1][1] + gameBoard[0][2];

		return ticTacToe.equals(topRow) || ticTacToe.equals(middleRow) || ticTacToe.equals(bottomRow)
				|| ticTacToe.equals(leftColumn) || ticTacToe.equals(middleColumn) || ticTacToe.equals(rightColumn)
				|| ticTacToe.equals(backwardDiagonal) || ticTacToe.equals(forwardDiagonal);
	}

}
