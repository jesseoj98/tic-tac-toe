package com.jesseoj98.tictactoe.util.printer.board.actual;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;
import com.jesseoj98.tictactoe.util.printer.space.SpacePrinter;

public class ActualSimpleBoardPrinter {

	private static final BoardStructurePrinter boardStructurePrinter = new BoardStructurePrinter();

	private static final SpacePrinter spacePrinter = new SpacePrinter();

	public void printActualBoardSequence(char[] gameBoard) {
		boardStructurePrinter.printGameBoardDivider(3);
		System.out.println();
		printActualBoard(gameBoard);
		boardStructurePrinter.printGameBoardDivider(3);
		System.out.println();
	}

	private void printActualBoard(char[] gameBoard) {
		for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
			System.out.print("| " + spacePrinter.printSpace(gameBoard[i], i) + " ");
			if ((i + 1) % 3 == 0) {
				System.out.print("|");
				System.out.println();
				if ((i + 1) != gameBoard.length) {
					boardStructurePrinter.printGameBoardDivider(3);
					System.out.println();
				}
			}
		}
	}
}
