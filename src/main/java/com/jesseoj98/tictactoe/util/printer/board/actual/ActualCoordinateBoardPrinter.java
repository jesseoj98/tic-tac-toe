package com.jesseoj98.tictactoe.util.printer.board.actual;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;

public class ActualCoordinateBoardPrinter {

	private static final BoardOccupier boardOccupier = new BoardOccupier();

	private static final BoardStructurePrinter boardStructurePrinter = new BoardStructurePrinter();

	public void printActualBoardSequence(char[][] gameBoard) {
		printActualBoard(gameBoard);
	}

	private void printActualBoard(char[][] gameBoard) {
		boardStructurePrinter.printGameBoardDivider(3);
		for (int i = 0; i < GameBoard.GAME_BOARD_DIMENSION; i++) {
			for (int j = 0; j < GameBoard.GAME_BOARD_DIMENSION; j++) {
				if (boardOccupier.isSpaceOccupied(gameBoard[i][j])) {
					System.out.print("| " + gameBoard[i][j] + " ");
				} else {
					System.out.print("|" + (j + 1) + "," + (i + 1));
				}
			}
			System.out.print("| " + (i + 1));
			if (i != GameBoard.GAME_BOARD_DIMENSION - 1) {
				boardStructurePrinter.printGameBoardDivider(3);
			}
		}
		boardStructurePrinter.printGameBoardDivider(3);
		boardStructurePrinter.printHorizontalEdgeIndices(3);
	}
}
