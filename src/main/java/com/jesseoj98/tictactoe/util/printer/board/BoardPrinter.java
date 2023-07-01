package com.jesseoj98.tictactoe.util.printer.board;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;
import com.jesseoj98.tictactoe.util.printer.space.SpacePrinter;

public class BoardPrinter {

    private static final BoardOccupier bo = new BoardOccupier();

    private static final SpacePrinter sp = new SpacePrinter();

    public void printSimpleSample() {
        printSimpleInstructions();
        printSimpleCoordinateGameBoardDivider();
        printSimpleDemo();
    }

    private void printSimpleDemo() {
        for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
            if (endOfSimpleRowMatch(i)) {
                System.out.println(" " + (i + 1) + " |");
                printSimpleCoordinateGameBoardDivider();
            } else {
                if (i % 3 != 0) {
                    System.out.print((i + 1) + " |");
                } else {
                    System.out.print("| " + (i + 1) + " | ");
                }
            }
        }
    }

    public void printSimpleCoordinateGameBoard(char[] gameBoard) {
        printSimpleCoordinateGameBoardDivider();
        printSimpleBoard(gameBoard);
    }

    private void printSimpleBoard(char[] gameBoard) {
        for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
            if (endOfSimpleRowMatch(i)) {
                System.out.println(" " + sp.printSpace(gameBoard[i], i) + " |");
                printSimpleCoordinateGameBoardDivider();
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
        printTopCoordinatesNumbers();
        printCoordinatesGameBoard(gameBoard);
        printBottomCoordinateNumbers();
    }

    private void printCoordinatesGameBoard(char[][] gameBoard) {
        printCoordinatesGameBoardDivider();
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
                printCoordinatesGameBoardDivider();
            }
        }
        printCoordinatesGameBoardDivider();
    }

    public void printCoordinatesSample() {
        printCoordinateInstructions();
        printSimpleCoordinateGameBoardDivider();
        printCoordinatesDemo();
    }

    private void printCoordinatesDemo() {
        for (int i = 0; i < GameBoard.GAME_BOARD_DIMENSION; i++) {
            for (int j = 0; j < GameBoard.GAME_BOARD_DIMENSION; j++) {
                System.out.print("|" + (j + 1) + "," + (i + 1));
                if (!endOfRowMatch(j)) {
                    System.out.println("|");
                    printSimpleCoordinateGameBoardDivider();
                }
            }
        }
    }

    private void printSimpleInstructions() {
        System.out.println("\nSimple Game Board");
        System.out.println("\nEnter a single digit to place your move\n");
    }

    private void printCoordinateInstructions() {
        System.out.println("\nCoordinates Game Board");
        System.out.println("\nEnter an x coordinate and a y coordinate to place your move\n");
    }

    private void printBottomCoordinateNumbers() {
        System.out.println("    1   2   3");
    }

    private boolean endOfSimpleRowMatch(int index) {
        return index == 2 || index == 5 || index == 8;
    }

    private boolean endOfRowMatch(int index) {
        return index != GameBoard.GAME_BOARD_DIMENSION - 1;
    }

    private void printTopCoordinatesNumbers() {
        System.out.println("    1   2   3");
    }

    private void printSimpleCoordinateGameBoardDivider() {
        System.out.println("|---|---|---|");
    }

    private void printCoordinatesGameBoardDivider() {
        System.out.println("  |---|---|---|");
    }

}
