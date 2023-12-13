package com.jesseoj98.tictactoe.util.printer.board.sample;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;

public class SampleSimpleBoardPrinter implements SampleBoardPrinter {

	private static final BoardStructurePrinter boardStructurePrinter = new BoardStructurePrinter();

	@Override
	public void printSampleBoardSequence() {
		printInstructions();
		printSampleBoard();
	}

	private void printSampleBoard() {
		boardStructurePrinter.printGameBoardDivider(3);
		for (int i = 1; i <= GameBoard.GAME_BOARD_SPACES; i++) {
			System.out.print("| " + i + " ");
			if (i % GameBoard.GAME_BOARD_DIMENSION == 0) {
				System.out.print("|");
				if (i != GameBoard.GAME_BOARD_SPACES) {
					boardStructurePrinter.printGameBoardDivider(3);
				}
			}
		}
		boardStructurePrinter.printGameBoardDivider(3);
	}

	private void printInstructions() {
		System.out.println();
		System.out.print("Simple Game Board");
		System.out.println();
		System.out.println();
		System.out.print("Enter a single digit to place your move");
		System.out.println();
	}
}
