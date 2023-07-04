package com.jesseoj98.tictactoe.util.helper.validator.tictactoe;

public class TicTacToeValidator {

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

}
