package com.jesseoj98.tictactoe.util;

import com.jesseoj98.tictactoe.domain.Result;
import com.jesseoj98.tictactoe.util.helper.retriever.ResultsRetriever;

/**
 * Validator class provides several validation methods
 */
public class Validator {

	/** Instantiation of classes */
	private static final Printer printer = new Printer();

	private static final ResultsRetriever rv = new ResultsRetriever();

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
					rv.retrieveWinningPositions(gameBoard, playerWon ? userPlayingCharacter : cpuPlayingCharacter),
					null);
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
					rv.retrieveWinningPositions(gameBoard, playerWon ? userPlayingCharacter : cpuPlayingCharacter));
			printer.printResult(result);
			System.out.println();
		}
	}

}
