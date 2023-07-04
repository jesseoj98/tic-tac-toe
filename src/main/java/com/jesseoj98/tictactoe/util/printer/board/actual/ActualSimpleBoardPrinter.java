package com.jesseoj98.tictactoe.util.printer.board.actual;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.helper.validator.printer.PrinterValidator;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;
import com.jesseoj98.tictactoe.util.printer.space.SpacePrinter;

public class ActualSimpleBoardPrinter {

    private static final BoardStructurePrinter bsp = new BoardStructurePrinter();

    private static final PrinterValidator pv = new PrinterValidator();

    private static final SpacePrinter sp = new SpacePrinter();

    public void printActualBoardSequence(char[] gameBoard) {
        bsp.printBoardDivider(0, 3);
        printActualBoard(gameBoard);
    }

    private void printActualBoard(char[] gameBoard) {
        for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
            if (pv.endOfSimpleRowMatch(i)) {
                System.out.println(" " + sp.printSpace(gameBoard[i], i) + " |");
                bsp.printBoardDivider(0, 3);
            } else {
                if (i % 3 != 0) {
                    System.out.print(sp.printSpace(gameBoard[i], i) + " |");
                } else {
                    System.out.print("| " + sp.printSpace(gameBoard[i], i) + " | ");
                }
            }
        }
    }
}
