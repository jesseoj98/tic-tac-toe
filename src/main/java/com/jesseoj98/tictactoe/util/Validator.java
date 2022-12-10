package com.jesseoj98.tictactoe.util;

import java.util.Collections;
import java.util.List;

import com.jesseoj98.tictactoe.domain.Coordinate;
import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.domain.Result;

/**
 * Validator class provides several validation methods
 */
public class Validator {

	/** Instantiation of classes */
	private static final Generator generator = new Generator();
	private static final Helper helper = new Helper();

	/** Declaration of variables */
	private static final List<List<Integer>> winningSimpleCoordinates = generator.generateSimpleWinningCoordinates();
	private static final List<List<Coordinate>> winningCoordinates = generator.generateWinningCoordinates();

	/**
	 * Checks whether the input playing character is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the input playing character is valid
	 */
	public boolean isInputPlayingCharacterValid(char input) {
		return input == 'x' || input == 'X' || input == 'o' || input == 'O';
	}

	/**
	 * Checks whether the input is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the input is valid
	 */
	public boolean isInputValid(char input) {
		return input == 'y' || input == 'Y' || input == 'n' || input == 'N';
	}

	/**
	 * Checks whether the play again character is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the play again character is valid
	 */
	public boolean playAgain(char input) {
		return input == 'y' || input == 'Y';
	}

	/**
	 * Checks whether the cpu go first character is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the cpu go first character is valid
	 */
	public boolean letCpuGoFirst(char input) {
		return input == 'y' || input == 'Y';
	}

	/**
	 * Checks whether the input game board type is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the input game board type is valid
	 */
	public boolean isInputGameBoardTypeValid(char input) {
		return input == 's' || input == 'S' || input == 'c' || input == 'C';
	}

	/**
	 * Checks whether the input is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the input is valid
	 */
	public boolean isInputValid(int input) {
		return input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 6 || input == 7
				|| input == 8 || input == 9;
		// return input > 0 && input < 10;
		// return input >= 1 && input <= 9;
	}

	/**
	 * Checks whether the input coordinate is valid
	 * 
	 * @param input the input
	 * 
	 * @return whether the input coordinate is valid
	 */
	public boolean isInputCoordinatesValid(int input) {
		return input == 1 || input == 2 || input == 3;
		// return input > 0 && input < 4;
		// return input >= 1 && input <= 3;
	}

	/**
	 * Checks whether all spaces are filled on a simple game board
	 * 
	 * @param simpleGameBoard the simple game board
	 * 
	 * @return whether all spaces are filled on a simple game board
	 */
	public boolean allGameBoardSpacesFilled(char[] simpleGameBoard) {
		for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
			if (!helper.isSpaceAlreadyOccupied(simpleGameBoard[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks whether tic tac toe happened on a simple game board
	 * 
	 * @param positions the positions to check
	 * 
	 * @return whether tic tac toe happened on a simple game board
	 */
	public boolean ticTacToeSimple(List<Integer> positions) {
		for (List<Integer> coordinate : winningSimpleCoordinates) {
			if (coordinate.containsAll(positions)) {
				return true;
			}
		}
		return false;
	}

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

		final String firstRow = new StringBuilder().append(gameBoard[0]).append(gameBoard[1]).append(gameBoard[2])
				.toString();
		final String secondRow = new StringBuilder().append(gameBoard[3]).append(gameBoard[4]).append(gameBoard[5])
				.toString();
		final String thirdRow = new StringBuilder().append(gameBoard[6]).append(gameBoard[7]).append(gameBoard[8])
				.toString();
		final String firstColumn = new StringBuilder().append(gameBoard[0]).append(gameBoard[3]).append(gameBoard[6])
				.toString();
		final String secondColumn = new StringBuilder().append(gameBoard[1]).append(gameBoard[4]).append(gameBoard[7])
				.toString();
		final String thirdColumn = new StringBuilder().append(gameBoard[2]).append(gameBoard[5]).append(gameBoard[8])
				.toString();
		final String backwardDiagonal = new StringBuilder().append(gameBoard[0]).append(gameBoard[4])
				.append(gameBoard[8]).toString();
		final String forwardDiagonal = new StringBuilder().append(gameBoard[2]).append(gameBoard[4])
				.append(gameBoard[6]).toString();

		return ticTacToe.equals(firstRow) || ticTacToe.equals(secondRow) || ticTacToe.equals(thirdRow)
				|| ticTacToe.equals(firstColumn) || ticTacToe.equals(secondColumn) || ticTacToe.equals(thirdColumn)
				|| ticTacToe.equals(backwardDiagonal) || ticTacToe.equals(forwardDiagonal);
	}

	/**
	 * Checks whether all spaces are filled on a coordinate game board
	 * 
	 * @param coordinateGameBoard the coordinate game board
	 * 
	 * @return whether all spaces are filled on a coordinate game board
	 */
	public boolean allGameBoardSpacesFilled(char[][] coordinateGameBoard) {
		for (int i = 0; i < GameBoard.GAME_BOARD_DIMENSION; i++) {
			for (int j = 0; j < GameBoard.GAME_BOARD_DIMENSION; j++) {
				if (!helper.isSpaceAlreadyOccupied(coordinateGameBoard, i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Checks whether tic tac toe happened on a coordinate game board
	 * 
	 * @param positions the positions to check
	 * 
	 * @return whether tic tac toe happened on a coordinate game board
	 */
	public boolean ticTacToeCoordinate(List<Coordinate> positions) {
		for (List<Coordinate> coordinate : winningCoordinates) {
			if (coordinate.containsAll(positions)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retrieves the winning integer positions
	 * 
	 * @param positions the positions to check
	 * @return the winning positions
	 */
	private List<Integer> retrieveWinningPositions(List<Integer> positions) {
		for (List<Integer> coordinate : winningSimpleCoordinates) {
			if (coordinate.containsAll(positions)) {
				return coordinate;
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Retrieves the winning coordinate positions
	 * 
	 * @param positions the positions to check
	 * @return the winning positions
	 */
	private List<Coordinate> retrieveWinningCoordinatePositions(List<Coordinate> positions) {
		for (List<Coordinate> coordinate : winningCoordinates) {
			if (coordinate.containsAll(positions)) {
				return coordinate;
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Retrieves the game results
	 * 
	 * @param playerPositions the player positions to check
	 * @param cpuPositions    the cpu positions to check
	 * @return the results of the game
	 */
	public Result getGameResults(List<Integer> playerPositions, List<Integer> cpuPositions) {
		final boolean playerWon = ticTacToeSimple(playerPositions);
		final List<Integer> winningPositions = playerWon ? retrieveWinningPositions(playerPositions)
				: retrieveWinningPositions(cpuPositions);
		return new Result(playerWon, !playerWon, winningPositions, null);
	}

	/**
	 * Retrieves the game results
	 * 
	 * @param playerPositions the player positions to check
	 * @param cpuPositions    the cpu positions to check
	 * @return the results of the game
	 */
	public Result getCoordinateGameResults(List<Coordinate> playerPositions, List<Coordinate> cpuPositions) {
		final boolean playerWon = ticTacToeCoordinate(playerPositions);
		final List<Coordinate> winningPositions = playerWon ? retrieveWinningCoordinatePositions(playerPositions)
				: retrieveWinningCoordinatePositions(cpuPositions);
		return new Result(playerWon, !playerWon, null, winningPositions);
	}

}
