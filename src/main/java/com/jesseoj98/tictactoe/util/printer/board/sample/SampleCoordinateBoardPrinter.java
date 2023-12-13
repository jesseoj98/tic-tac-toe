package com.jesseoj98.tictactoe.util.printer.board.sample;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;

public class SampleCoordinateBoardPrinter implements SampleBoardPrinter {

	private static final BoardStructurePrinter boardStructurePrinter = new BoardStructurePrinter();

	@Override
	public void printSampleBoardSequence() {
		printInstructions();
		printSampleBoard();
	}

	private void printSampleBoard() {
		boardStructurePrinter.printGameBoardDivider(GameBoard.GAME_BOARD_DIMENSION);
		for (int i = 1; i <= GameBoard.GAME_BOARD_DIMENSION; i++) {
			for (int j = 1; j <= GameBoard.GAME_BOARD_DIMENSION; j++) {
				System.out.print("|" + j + "," + i);
				if (j % GameBoard.GAME_BOARD_DIMENSION == 0) {
					System.out.print("|");
				}
			}
			if (i != GameBoard.GAME_BOARD_DIMENSION) {
				boardStructurePrinter.printGameBoardDivider(GameBoard.GAME_BOARD_DIMENSION);
			}
		}
		boardStructurePrinter.printGameBoardDivider(GameBoard.GAME_BOARD_DIMENSION);
	}

	private void printInstructions() {
		System.out.println();
		System.out.print("Coordinates Game Board");
		System.out.println();
		System.out.println();
		System.out.print("Enter an x coordinate and a y coordinate to place your move");
		System.out.println();
	}

}
