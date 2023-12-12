package com.jesseoj98.tictactoe.util.printer.board.sample;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;

public class SampleCoordinateBoardPrinter implements SampleBoardPrinter {

    private static final BoardStructurePrinter boardStructurePrinter = new BoardStructurePrinter();

    @Override
    public void printSampleBoardSequence() {
		System.out.println();
        printInstructions();
		System.out.println();
		boardStructurePrinter.printGameBoardDivider(3);
		System.out.println();
        printSampleBoard();
		boardStructurePrinter.printGameBoardDivider(3);
		System.out.println();
    }

    private void printSampleBoard() {
    	for (int i = 1; i <= GameBoard.GAME_BOARD_DIMENSION; i++) {
			for (int j = 1; j <= GameBoard.GAME_BOARD_DIMENSION; j++) {
				System.out.print("|" + j + "," + i);
				if (j % 3 == 0) {
					System.out.print("|");
					System.out.println();
				}
			}
			if (i != GameBoard.GAME_BOARD_DIMENSION) {
				boardStructurePrinter.printGameBoardDivider(3);
				System.out.println();
			}
		}
    }

    private void printInstructions() {
        System.out.print("Coordinates Game Board");
		System.out.println();
		System.out.println();
        System.out.print("Enter an x coordinate and a y coordinate to place your move");
		System.out.println();
    }

}
