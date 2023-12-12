package com.jesseoj98.tictactoe.util.printer.board.structure;

public class BoardStructurePrinter {
	
	public void printHorizontalEdgeIndices(int indices) {
		System.out.print("  ");
		for (int i = 1; i <= indices; i++) {
			System.out.print(i);
			if (i == indices) { // just to not append useless spaces
				break;
			}
			System.out.print("   ");
		}
		System.out.println();
	}

	public void printGameBoardDivider(int columns) {
		System.out.println();
		for (int i = 1; i <= columns; i++) {
			System.out.print("|---");
			if (i == columns) {
				System.out.print("|");
			}
		}
		System.out.println();
	}

}
