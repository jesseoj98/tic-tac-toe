package com.jesseoj98.tictactoe.util.printer.space;

import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;

public class SpacePrinter {

    private static final BoardOccupier bo = new BoardOccupier();

    public String printSpace(char space, int index) {
        if (!bo.isSpaceOccupied(space)) {
            switch (index) {
                case 0:
                    return "1";
                case 1:
                    return "2";
                case 2:
                    return "3";
                case 3:
                    return "4";
                case 4:
                    return "5";
                case 5:
                    return "6";
                case 6:
                    return "7";
                case 7:
                    return "8";
                case 8:
                    return "9";
                default:
                    return " ";
            }
        } else {
            return Character.toString(space);
        }
    }

}
