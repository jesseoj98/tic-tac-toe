package com.jesseoj98.tictactoe.util.printer.result;

import com.jesseoj98.tictactoe.domain.Coordinate;
import com.jesseoj98.tictactoe.domain.Result;

import java.util.List;

public class ResultPrinter {

    public void printResult(Result result) {
        if (result.isPlayerWon()) {
            System.out.print("Congratulations! You won with positions ");
        } else {
            System.out.print("Too bad! Cpu won with positions ");
        }
        if (result.getWinningSimpleCoordinates() != null) {
            System.out.print(printPositions(result.getWinningSimpleCoordinates()));
        } else {
            System.out.print(printCoordinates(result.getWinningCoordinates()));
        }
    }

    private String printPositions(List<Integer> positions) {
        final StringBuilder spots = new StringBuilder();
        for (int i = 0; i < positions.size(); i++) {
            if (i != positions.size() - 1) {
                spots.append(positions.get(i) + 1).append(", ");
            } else {
                spots.append(positions.get(i) + 1);
            }
        }
        return spots.toString();

    }

    private String printCoordinates(List<Coordinate> coordinates) {
        final StringBuilder spots = new StringBuilder();
        for (int i = 0; i < coordinates.size(); i++) {
            if (i != coordinates.size() - 1) {
                spots.append("[").append(coordinates.get(i).getY() + 1).append(", ").append(coordinates.get(i).getX() + 1).append("]").append(", ");
            } else {
                spots.append("[").append(coordinates.get(i).getY() + 1).append(", ").append(coordinates.get(i).getX() + 1).append("]");
            }
        }
        return spots.toString();
    }

}
