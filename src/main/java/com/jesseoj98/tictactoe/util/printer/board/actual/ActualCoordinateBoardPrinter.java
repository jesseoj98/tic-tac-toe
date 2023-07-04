package com.jesseoj98.tictactoe.util.printer.board.actual;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;
import com.jesseoj98.tictactoe.util.helper.validator.printer.PrinterValidator;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;
import com.jesseoj98.tictactoe.util.printer.space.SpacePrinter;

public class ActualCoordinateBoardPrinter {

    private static final BoardStructurePrinter boardStructurePrinter = new BoardStructurePrinter();

    private static final BoardOccupier boardOccupier = new BoardOccupier();

    private static final PrinterValidator pv = new PrinterValidator();

    private static final SpacePrinter sp = new SpacePrinter();

    public void printActualBoardSequence(char[][] gameBoard) {
        boardStructurePrinter.printNumbers(4, 3, true);
        printActualBoard(gameBoard);
        boardStructurePrinter.printNumbers(4, 3, true);
    }

    private void printActualBoard(char[][] gameBoard) {
        boardStructurePrinter.printBoardDivider(2, 3);
        for (int i = 0; i < GameBoard.GAME_BOARD_DIMENSION; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < GameBoard.GAME_BOARD_DIMENSION; j++) {
                if (boardOccupier.isSpaceOccupied(gameBoard[i][j])) {
                    System.out.print("| " + gameBoard[i][j] + " ");
                } else {
                    System.out.print("|" + (j + 1) + "," + (i + 1));
                }
            }
            System.out.println("| " + (i + 1));
            if (i != GameBoard.GAME_BOARD_DIMENSION - 1) {
                boardStructurePrinter.printBoardDivider(2, 3);
            }
        }
        boardStructurePrinter.printBoardDivider(2, 3);
    }
}
