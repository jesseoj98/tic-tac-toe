package com.jesseoj98.tictactoe.util.printer.board.sample;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.helper.validator.printer.PrinterValidator;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;

public class CoordinateBoardPrinter implements SampleBoardPrinter {

    private static final BoardStructurePrinter bsp = new BoardStructurePrinter();

    private static final PrinterValidator pv = new PrinterValidator();

    @Override
    public void printSampleBoardSequence() {
        printInstructions();
        bsp.printBoardDivider(4, 3);
        printSampleBoard();
    }

    private void printSampleBoard() {
        for (int i = 0; i < GameBoard.GAME_BOARD_DIMENSION; i++) {
            for (int j = 0; j < GameBoard.GAME_BOARD_DIMENSION; j++) {
                System.out.print("|" + (j + 1) + "," + (i + 1));
                if (!pv.endOfRowMatch(j)) {
                    System.out.println("|");
                    bsp.printBoardDivider(4, 3);
                }
            }
        }
    }

    private void printInstructions() {
        System.out.println("\nCoordinates Game Board");
        System.out.println("\nEnter an x coordinate and a y coordinate to place your move\n");
    }

}
