package com.jesseoj98.tictactoe.util.helper.handler;

import com.jesseoj98.tictactoe.domain.Result;
import com.jesseoj98.tictactoe.util.helper.retriever.ResultRetriever;
import com.jesseoj98.tictactoe.util.printer.result.ResultPrinter;

public class ResultHandler {

	private static final ResultPrinter resultPrinter = new ResultPrinter();
	private static final ResultRetriever resultRetriever = new ResultRetriever();

	public void handleResult(boolean playerWon, boolean cpuWon, char[] gameBoard, char userPlayingCharacter,
			char cpuPlayingCharacter) {
		if (!playerWon && !cpuWon) {
			System.out.println("Tie!");
		} else {
			final Result result = new Result(playerWon, cpuWon,
					resultRetriever.retrieveWinningPositions(gameBoard, playerWon ? userPlayingCharacter : cpuPlayingCharacter),
					null);
			resultPrinter.printResult(result);
			System.out.println();
		}
	}

	public void handleResult(boolean playerWon, boolean cpuWon, char[][] gameBoard, char userPlayingCharacter,
			char cpuPlayingCharacter) {
		if (!playerWon && !cpuWon) {
			System.out.println("Tie!");
		} else {
			final Result result = new Result(playerWon, cpuWon, null,
					resultRetriever.retrieveWinningPositions(gameBoard, playerWon ? userPlayingCharacter : cpuPlayingCharacter));
			resultPrinter.printResult(result);
			System.out.println();
		}
	}

}
