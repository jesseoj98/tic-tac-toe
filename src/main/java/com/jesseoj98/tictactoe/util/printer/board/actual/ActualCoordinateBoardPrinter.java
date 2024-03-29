package com.jesseoj98.tictactoe.util.printer.board.actual;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;

public class ActualCoordinateBoardPrinter {

	private static final BoardStructurePrinter boardStructurePrinter = new BoardStructurePrinter();

	public void printActualBoard(char[][] gameBoard) {
		boardStructurePrinter.printGameBoardDivider(GameBoard.GAME_BOARD_DIMENSION);
		for (int i = 0; i < GameBoard.GAME_BOARD_DIMENSION; i++) {
			for (int j = 0; j < GameBoard.GAME_BOARD_DIMENSION; j++) {
				if (gameBoard[i][j] == 'X' || gameBoard[i][j] == 'O') {
					System.out.print("| " + gameBoard[i][j] + " ");
				} else {
					System.out.print("|" + (j + 1) + "," + (i + 1));
				}
			}
			System.out.print("| " + (i + 1));
			if (i != GameBoard.GAME_BOARD_DIMENSION - 1) {
				boardStructurePrinter.printGameBoardDivider(GameBoard.GAME_BOARD_DIMENSION);
			}
		}
		boardStructurePrinter.printGameBoardDivider(GameBoard.GAME_BOARD_DIMENSION);
		boardStructurePrinter.printHorizontalEdgeIndices(GameBoard.GAME_BOARD_DIMENSION);
	}
}
