package com.jesseoj98.tictactoe.util.looper.input;

import java.util.Scanner;

public class CoordinateInputLooper {

	private static final Scanner scanner = new Scanner(System.in);

	public int loopPlayerCoordinateInput(char[][] gameBoard) {

		int inputCoordinate;

		do {
			inputCoordinate = scanner.nextInt();
		} while (!(inputCoordinate == 1 || inputCoordinate == 2 || inputCoordinate == 3));

		return inputCoordinate;

	}

}
