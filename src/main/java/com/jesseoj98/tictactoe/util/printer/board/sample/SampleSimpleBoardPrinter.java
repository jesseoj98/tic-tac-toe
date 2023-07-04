package com.jesseoj98.tictactoe.util.printer.board.sample;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.helper.validator.printer.PrinterValidator;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;

public class SampleSimpleBoardPrinter implements SampleBoardPrinter {

    private static final BoardStructurePrinter boardStructurePrinter = new BoardStructurePrinter();

    private static final PrinterValidator printerValidator = new PrinterValidator();

    @Override
    public void printSampleBoardSequence() {
        printInstructions();
        boardStructurePrinter.printBoardDivider(0, 3);
        printSampleBoard();
    }

    private void printSampleBoard() {
        for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
            if (printerValidator.endOfSimpleRowMatch(i)) {
                System.out.println(" " + (i + 1) + " |");
                boardStructurePrinter.printBoardDivider(0, 3);
            } else {
                if (i % 3 != 0) {
                    System.out.print((i + 1) + " |");
                } else {
                    System.out.print("| " + (i + 1) + " | ");
                }
            }
        }
    }

    private void printInstructions() {
        System.out.println("\nSimple Game Board");
        System.out.println("\nEnter a single digit to place your move\n");
    }
}
