package com.jesseoj98.tictactoe.util.printer.board.structure;

public class BoardStructurePrinter {

    public void printBoardDivider(int spaces, int columns) {
        printSpaces(spaces);
        printColumnsOrNumbers(columns, true, false);
    }

    public void printNumbers(int spaces, int numberOfNumbers, boolean printAdditionalSpaces) {
        printSpaces(spaces);
        printColumnsOrNumbers(numberOfNumbers, false, printAdditionalSpaces);
    }

    private void printColumnsOrNumbers(int timesToPrint, boolean printColumns, boolean printAdditionalSpaces) {
        for (int i = 0; i < timesToPrint; i++) {
            System.out.print(printColumns ? "|---" : (i + 1));
            System.out.print(printAdditionalSpaces ? "   " : "");
            if (printAdditionalSpaces && i == timesToPrint - 1) {
                break;
            }
            if (i == timesToPrint - 1) {
                System.out.print(printColumns ? "|" : timesToPrint);
                break;
            }
        }
        System.out.println();
    }

    private void printSpaces(int spaces) {
        if (spaces != 0) {
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
        }
    }

}
