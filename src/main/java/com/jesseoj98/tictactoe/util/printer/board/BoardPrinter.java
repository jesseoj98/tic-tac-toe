package com.jesseoj98.tictactoe.util.printer.board;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;
import com.jesseoj98.tictactoe.util.helper.validator.printer.PrinterValidator;
import com.jesseoj98.tictactoe.util.printer.board.structure.BoardStructurePrinter;
import com.jesseoj98.tictactoe.util.printer.space.SpacePrinter;

public class BoardPrinter {

    private static final BoardStructurePrinter bsp = new BoardStructurePrinter();

    private static final BoardOccupier bo = new BoardOccupier();

    private static final PrinterValidator pv = new PrinterValidator();

    private static final SpacePrinter sp = new SpacePrinter();

    public void printSimpleCoordinateGameBoard(char[] gameBoard) {
        bsp.printBoardDivider(0, 3);
        printSimpleBoard(gameBoard);
    }

    private void printSimpleBoard(char[] gameBoard) {
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

    public void printCoordinates(char[][] gameBoard) {
        bsp.printNumbers(4, 3);
        printCoordinatesGameBoard(gameBoard);
        bsp.printNumbers(4, 3);
    }

    private void printCoordinatesGameBoard(char[][] gameBoard) {
        bsp.printBoardDivider(0, 3);
        for (int i = 0; i < GameBoard.GAME_BOARD_DIMENSION; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < GameBoard.GAME_BOARD_DIMENSION; j++) {
                if (bo.isSpaceOccupied(gameBoard[i][j])) {
                    System.out.print("| " + gameBoard[i][j] + " ");
                } else {
                    System.out.print("|" + (j + 1) + "," + (i + 1));
                }
            }
            System.out.println("| " + (i + 1));
            if (i != GameBoard.GAME_BOARD_DIMENSION - 1) {
                bsp.printBoardDivider(0, 3);
            }
        }
        bsp.printBoardDivider(0, 3);
    }

}
