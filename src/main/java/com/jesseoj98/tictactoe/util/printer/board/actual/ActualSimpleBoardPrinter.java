package com.jesseoj98.tictactoe.util.printer.board.actual;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.helper.validator.printer.PrinterValidator;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;
import com.jesseoj98.tictactoe.util.printer.space.SpacePrinter;

public class ActualSimpleBoardPrinter {

    private static final BoardStructurePrinter boardStructurePrinter = new BoardStructurePrinter();

    private static final PrinterValidator printerValidator = new PrinterValidator();

    private static final SpacePrinter spacePrinter = new SpacePrinter();

    public void printActualBoardSequence(char[] gameBoard) {
        boardStructurePrinter.printBoardDivider(0, 3);
        printActualBoard(gameBoard);
    }

    private void printActualBoard(char[] gameBoard) {
        for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
            if (printerValidator.endOfSimpleRowMatch(i)) {
                System.out.println(" " + spacePrinter.printSpace(gameBoard[i], i) + " |");
                boardStructurePrinter.printBoardDivider(0, 3);
            } else {
                if (i % 3 != 0) {
                    System.out.print(spacePrinter.printSpace(gameBoard[i], i) + " |");
                } else {
                    System.out.print("| " + spacePrinter.printSpace(gameBoard[i], i) + " | ");
                }
            }
        }
    }
}
