package com.jesseoj98.tictactoe.util.printer;

import com.jesseoj98.tictactoe.domain.Result;
import com.jesseoj98.tictactoe.util.helper.retriever.ResultRetriever;
import com.jesseoj98.tictactoe.util.printer.result.ResultsPrinter;

public class ResultPrinter {

	private static final ResultsPrinter rp = new ResultsPrinter();

	private static final ResultRetriever rv = new ResultRetriever();

	public void handleResult(boolean playerWon, boolean cpuWon, char[] gameBoard, char userPlayingCharacter,
			char cpuPlayingCharacter) {
		if (!playerWon && !cpuWon) {
			System.out.println("Tie!");
		} else {
			final Result result = new Result(playerWon, cpuWon,
					rv.retrieveWinningPositions(gameBoard, playerWon ? userPlayingCharacter : cpuPlayingCharacter),
					null);
			rp.printResult(result);
			System.out.println();
		}
	}

	public void handleResult(boolean playerWon, boolean cpuWon, char[][] gameBoard, char userPlayingCharacter,
			char cpuPlayingCharacter) {
		if (!playerWon && !cpuWon) {
			System.out.println("Tie!");
		} else {
			final Result result = new Result(playerWon, cpuWon, null,
					rv.retrieveWinningPositions(gameBoard, playerWon ? userPlayingCharacter : cpuPlayingCharacter));
			rp.printResult(result);
			System.out.println();
		}
	}

}
