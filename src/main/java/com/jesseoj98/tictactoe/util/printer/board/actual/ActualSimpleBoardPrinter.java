package com.jesseoj98.tictactoe.util.printer.board.actual;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;
import com.jesseoj98.tictactoe.util.printer.space.SpacePrinter;

public class ActualSimpleBoardPrinter {

	private static final BoardStructurePrinter boardStructurePrinter = new BoardStructurePrinter();

	private static final SpacePrinter spacePrinter = new SpacePrinter();

	public void printActualBoardSequence(char[] gameBoard) {
		printActualBoard(gameBoard);
	}

	private void printActualBoard(char[] gameBoard) {
		boardStructurePrinter.printGameBoardDivider(GameBoard.GAME_BOARD_DIMENSION);
		for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
			System.out.print("| " + spacePrinter.printSpace(gameBoard[i], i) + " ");
			if ((i + 1) % 3 == 0) {
				System.out.print("|");
				if ((i + 1) != GameBoard.GAME_BOARD_SPACES) {
					boardStructurePrinter.printGameBoardDivider(GameBoard.GAME_BOARD_DIMENSION);
				}
			}
		}
		boardStructurePrinter.printGameBoardDivider(GameBoard.GAME_BOARD_DIMENSION);
	}
}
